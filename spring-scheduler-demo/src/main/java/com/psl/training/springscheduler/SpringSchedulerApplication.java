package com.psl.training.springscheduler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulerApplication {
	private int count;
	 private static final Logger LOGGER=LoggerFactory.getLogger(SpringSchedulerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerApplication.class, args);
	}

	@Scheduled(initialDelay=500, fixedRate=500)
	public void printTask(){
		System.out.println(" Printing task executed by scheduler....." + LocalDateTime.now());
		/**/
	}	
	

	@Scheduled(fixedRate=1000)
	public void counterTask(){
		
		//try {
			System.out.println(Thread.currentThread().getName()+" counter = "+count++);
/*			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	}
}


