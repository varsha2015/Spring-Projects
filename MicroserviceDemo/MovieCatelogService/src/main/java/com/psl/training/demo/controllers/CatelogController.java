package com.psl.training.demo.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.psl.training.demo.model.CatalogItem;
import com.psl.training.demo.model.Movie;
import com.psl.training.demo.model.Rating;
import com.psl.training.demo.model.UserRating;

@RestController
public class CatelogController {

	@Autowired
	RestTemplate template;

	@Autowired
	WebClient.Builder bilder;

	@GetMapping("/catalog/{userId}")
	public List<CatalogItem> getCatalogItems(
			@PathVariable("userId") String userId) {

		
		UserRating ratings = template.getForObject("http://localhost:8078/ratings/user/"+userId, UserRating.class);
		System.out.println(ratings); 
		return ratings.getUserRatings()
				.stream()
				.map(r -> {
					Movie movie = template.getForObject("http://localhost:8089/movies/" + r.getMovieId(),Movie.class);
					/*Movie movie=bilder.build()
							.get()
							.uri("http://localhost:8089/movies/" + r.getMovieId())
							.retrieve()
							.bodyToMono(Movie.class)
							.block();*/
					return new CatalogItem(movie.getMovieName(), "Comedy", r
							.getRating());
				}).collect(Collectors.toList());
	}

	@GetMapping("/hi")
	public String sayHello() {
		return "Welcome";
	}
}
