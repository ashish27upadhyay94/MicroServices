package com.microservices.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.microservices.model.Rating;
import com.microservices.model.UserWiseRating;

@Service
public class RatingService {

	public UserWiseRating getUserRating(String userId) {
		if ("ashish".equalsIgnoreCase(userId)) {
			return getAshishRating();
		}
		return null;
	}

	private UserWiseRating getAshishRating() {
		UserWiseRating userWiseRating = new UserWiseRating();
		List<Rating> listOfRatings = new ArrayList<Rating>();
		Rating ratingMove1 = new Rating();
		Rating ratingMove2 = new Rating();
		ratingMove1.setMovieId(109069);
		ratingMove1.setRating(3.5);
		ratingMove2.setMovieId(109061);
		ratingMove2.setRating(4.2);
		listOfRatings.add(ratingMove1);
		listOfRatings.add(ratingMove2);
		userWiseRating.setRatings(listOfRatings);
		return userWiseRating;
	}
}
