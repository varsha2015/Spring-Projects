package com.psl.training.springscheduler.controller;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.springscheduler.jobs.EmailJob;
import com.psl.training.springscheduler.payload.ScheduledEmailRequest;
import com.psl.training.springscheduler.payload.ScheduledEmailResponse;

@RestController
public class EmailJobSchedulerController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmailJobSchedulerController.class);

	@Autowired
	private Scheduler scheduler;

	@PostMapping("/scheduleEmail")
	public ResponseEntity<ScheduledEmailResponse> scheduleEmail(
			@Valid @RequestBody ScheduledEmailRequest scheduleEmailRequest) {
		try {
			ZonedDateTime dateTime = ZonedDateTime.of(
					scheduleEmailRequest.getDateTime(),
					scheduleEmailRequest.getTimeZone());
			if (dateTime.isBefore(ZonedDateTime.now())) {
				ScheduledEmailResponse scheduleEmailResponse = new ScheduledEmailResponse(
						false, "dateTime must be after current time");
				return ResponseEntity.badRequest().body(scheduleEmailResponse);
			}

			JobDetail jobDetail = buildJobDetail(scheduleEmailRequest);
			Trigger trigger = buildJobTrigger(jobDetail, dateTime);
			scheduler.scheduleJob(jobDetail, trigger);

			ScheduledEmailResponse scheduleEmailResponse = new ScheduledEmailResponse(
					true, jobDetail.getKey().getName(), jobDetail.getKey()
							.getGroup(), "Email Scheduled Successfully!");
			return ResponseEntity.ok(scheduleEmailResponse);
		} catch (SchedulerException ex) {
			logger.error("Error scheduling email", ex);

			ScheduledEmailResponse scheduleEmailResponse = new ScheduledEmailResponse(
					false, "Error scheduling email. Please try later!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(scheduleEmailResponse);
		}
	}

	private JobDetail buildJobDetail(ScheduledEmailRequest scheduleEmailRequest) {
		JobDataMap jobDataMap = new JobDataMap();

		jobDataMap.put("email", scheduleEmailRequest.getEmail());
		jobDataMap.put("subject", scheduleEmailRequest.getSubject());
		jobDataMap.put("body", scheduleEmailRequest.getBody());

		return JobBuilder.newJob(EmailJob.class)
				.withIdentity(UUID.randomUUID().toString(), "email-jobs")
				.withDescription("Send Email Job").usingJobData(jobDataMap)
				.storeDurably().build();
	}

	private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
		return TriggerBuilder
				.newTrigger()
				.forJob(jobDetail)
				.withIdentity(jobDetail.getKey().getName(), "email-triggers")
				.withDescription("Send Email Trigger")
				.startAt(Date.from(startAt.toInstant()))
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
								.withMisfireHandlingInstructionFireNow())
				.build();
	}
}
