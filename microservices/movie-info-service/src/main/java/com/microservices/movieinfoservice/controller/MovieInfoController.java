package com.microservices.movieinfoservice.controller;

import com.microservices.movieinfoservice.models.Movie;
import com.microservices.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${moviedb.api.key}")
    String apiKey;


    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

        MovieSummary movieSummary = this.restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }
}
