package com.microservices.moviecatalogservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservices.model.Catalogue;
import com.microservices.model.UserWiseRating;
import com.microservices.moviecatalogservice.component.MovieInfo;
import com.microservices.moviecatalogservice.component.Ratings;

@RestController
@RequestMapping("/catalouge")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	Ratings ratings;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<Catalogue> getCatalouge(@PathVariable String userId) {

		// calling rating data service
		UserWiseRating userWiseRating = ratings.getUserRating(userId);

		// calling Movie Info service
		List<Catalogue> list = movieInfo.getMovies(userWiseRating);
		return list;
	}

}
