package com.example.movie_review_be.controller;


import com.example.movie_review_be.services.MovieService;
import com.example.movie_review_be.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/1.0/movies")
public class MovieController {



    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }



    @PostMapping
    public void addMovie(){

    }
}
