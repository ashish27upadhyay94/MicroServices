package com.microservices.model;

import java.util.List;

public class UserWiseRating {

	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "UserWiseRating [ratings=" + ratings + "]";
	}
	
}
