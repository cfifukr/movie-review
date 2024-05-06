package com.example.movie_review_be.controller;


import com.example.movie_review_be.models.Review;
import com.example.movie_review_be.services.MovieService;
import com.example.movie_review_be.models.Movie;
import com.example.movie_review_be.services.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/1.0/movies")
public class MovieController {



    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    //MOVIE ENDPOINTS
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.findById(id), HttpStatus.FOUND);
    }

    @GetMapping("imdb/{imdb}")
    public ResponseEntity<Optional<Movie>> getMovieByImdb(@PathVariable String imdb){
        return new ResponseEntity<Optional<Movie>>(movieService.findByImdb(imdb), HttpStatus.FOUND);
    }



    @PostMapping
    public void addMovie(){

        Movie movie = new Movie(ObjectId.get(),
                "test4",
                "test4",
                "test4",
                "test4",
                "test4",
                new ArrayList<String>(),
                new ArrayList<String>(),
                new ArrayList<Review>());
        movieService.addMovie(movie);

    }



    //REVIEW ENDPOINTS


}
