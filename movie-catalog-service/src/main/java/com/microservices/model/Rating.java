package com.microservices.model;

public class Rating {
	private int movieId;
	private double rating;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double d) {
		this.rating = d;
	}

	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", rating=" + rating + "]";
	}

}
