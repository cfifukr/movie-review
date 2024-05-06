package com.example.movie_review_be.services;

import com.example.movie_review_be.models.Movie;
import com.example.movie_review_be.repositories.MovieRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private  MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<Movie> getAllMovies(){

        return movieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findById(ObjectId objectId){

        return movieRepository.findById(objectId);
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findByImdb(String imdb){

        return movieRepository.findMovieByImdb(imdb);
    }


    @Transactional
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
}
