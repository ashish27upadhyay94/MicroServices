package com.microservices.movieinfoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Movie;
import com.microservices.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	@Autowired
	private MovieService service;

	@RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable int movieId) {

		return service.getMovies(movieId);

	}
}
