package com.example.movie_review_be.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "movies")
public class Movie {
    @Id
    private ObjectId id;

    private String imdb;

    private String title;

    private String releaseDate;

    private String trailer;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviews;

}
