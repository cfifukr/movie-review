package com.example.movie_review_be.controller;

import com.example.movie_review_be.models.Review;
import com.example.movie_review_be.services.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/1.0/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){

        return new ResponseEntity<List<Review>>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Map<String, String> map){
        Review review =  reviewService.addReview(map.get("body"), map.get("imdb"));

        return new ResponseEntity<Review>(review, HttpStatus.CREATED);
    }
}
