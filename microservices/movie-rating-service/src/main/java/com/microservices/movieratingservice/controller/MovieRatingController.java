package com.microservices.movieratingservice.controller;

import com.microservices.movieratingservice.models.Rating;
import com.microservices.movieratingservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingController {

    @GetMapping("/{movieId}")
    public Rating getMovieRatingsData(@PathVariable("movieId") String movieId){
        return new Rating(movieId,5);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable("userId") String userId){
       List<Rating> ratings = Arrays.asList(
                new Rating("100", 4),
                new Rating("200", 5)
        );

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);

        return userRating;

    }
}
