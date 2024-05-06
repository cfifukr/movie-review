package com.example.movie_review_be.repositories;

import com.example.movie_review_be.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
