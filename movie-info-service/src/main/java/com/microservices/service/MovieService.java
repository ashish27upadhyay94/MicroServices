package com.microservices.service;

import org.springframework.stereotype.Service;

import com.microservices.model.Movie;

@Service
public class MovieService {

	public Movie getMovies(int movieId) {
		return getAllMovies(movieId);
	}

	private Movie getAllMovies(int movieId) {
		Movie movie;
		switch (movieId) {
		case 109069:
			movie = new Movie(movieId, "Transformer", "Good Movie");
			break;
		case 109061:
			movie = new Movie(movieId, "Game Of Thrones", "Very Good Movie");
			break;

		default:
			movie = null;
			break;
		}
		return movie;
	}
}
