package com.psl.training.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.demo.model.Rating;
import com.psl.training.demo.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@GetMapping("/{movieId}")
	public Rating getRatings(@PathVariable("movieId") String movieId){
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/user/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId){
		UserRating userRating = new UserRating();
		List<Rating> ratingsList = Arrays.asList(new  Rating("1001", 3),new Rating("1002", 4));
		userRating.setUserRatings(ratingsList);
		return userRating;
	}
}
