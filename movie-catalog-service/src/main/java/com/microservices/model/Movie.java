package com.microservices.model;

public class Movie {
	private int movieId;
	private String movieName;
	private String description;

	public Movie() {
		super();
	}

	/**
	 * @param movieId
	 * @param movieName
	 * @param description
	 */
	public Movie(int movieId, String movieName, String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", description=" + description + "]";
	}

}
