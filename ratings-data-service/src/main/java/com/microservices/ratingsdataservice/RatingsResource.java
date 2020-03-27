package com.microservices.ratingsdataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.UserWiseRating;
import com.microservices.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
	
	@Autowired
	private RatingService service;
	
	@RequestMapping("user/{userId}")
	public UserWiseRating getUserWiseRating(@PathVariable String userId) {
		return service.getUserRating(userId);
		
	}
	
}
