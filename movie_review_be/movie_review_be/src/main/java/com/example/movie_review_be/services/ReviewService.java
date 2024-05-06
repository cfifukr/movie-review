package com.example.movie_review_be.services;


import com.example.movie_review_be.models.Movie;
import com.example.movie_review_be.models.Review;
import com.example.movie_review_be.repositories.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Transactional(readOnly = true)
    public List<Review> getAllReviews(){

        return reviewRepository.findAll();

    }


    @Transactional(readOnly = true)
    public Optional<Review> getReviewById(ObjectId id){

        return reviewRepository.findById(id);


    }


    @Transactional
    public Review addReview(String body, String imdb){
        Review review = reviewRepository.save(new Review(body));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdb").is(imdb))
                .apply(new Update().push("reviews").value(review.getId()))
                .first();

        return review;
    }
}
