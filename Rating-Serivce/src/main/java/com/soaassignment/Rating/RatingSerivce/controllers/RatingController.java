package com.soaassignment.Rating.RatingSerivce.controllers;

import com.soaassignment.Rating.RatingSerivce.entities.Rating;
import com.soaassignment.Rating.RatingSerivce.entities.RatingFormat;
import com.soaassignment.Rating.RatingSerivce.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/content/{contentId}")
    //public ResponseEntity<List<Rating>> getRatingByContentId(@PathVariable String contentId){ change
    public ResponseEntity<List<RatingFormat>> getRatingByContentId(@PathVariable String contentId){
        return ResponseEntity.ok(ratingService.getRatingByContentId(contentId));
    }
}
