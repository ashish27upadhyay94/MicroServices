package com.microservices.moviecatalogservice.component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.Catalogue;
import com.microservices.model.Movie;
import com.microservices.model.UserWiseRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class MovieInfo {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalouge", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "50"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "5000") })
	/*
	 * circuitBreaker.errorThresholdPercentage : how long circuit breaker gonna
	 * sleep before it retries again
	 */
	public List<Catalogue> getMovies(UserWiseRating userWiseRating) {
		return userWiseRating.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
					Movie.class);
			return new Catalogue(movie.getMovieName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());
	}

	/**
	 * <h1>Fall Back Method - Circuit Breaker</h1>
	 * 
	 * @param userWiseRating
	 * @return list<Catalogue> : returns List of Catalog
	 */
	public List<Catalogue> getFallbackCatalouge(UserWiseRating userWiseRating) {
		return Arrays.asList(new Catalogue("No Movie", "No Description", 0.0));
	}
}
