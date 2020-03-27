package com.microservices.moviecatalogservice.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Rating;
import com.microservices.model.UserWiseRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class Ratings {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getRatings", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "50"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "5000") }, threadPoolKey = "userRatingBulkHead", threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "20"),
					@HystrixProperty(name = "maxQueueSize", value = "10")

	})
	// coreSize - max concurrent thread at time
	public UserWiseRating getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratings/user/" + userId, UserWiseRating.class);
	}

	public UserWiseRating getRatings(String userId) {
		UserWiseRating userWiseRatings = new UserWiseRating();
		List<Rating> listOfRatings = new ArrayList<Rating>();
		Rating rate = new Rating();
		rate.setMovieId(109069);
		rate.setRating(5.5);
		listOfRatings.add(rate);
		userWiseRatings.setRatings(listOfRatings);
		return userWiseRatings;
	}
}
