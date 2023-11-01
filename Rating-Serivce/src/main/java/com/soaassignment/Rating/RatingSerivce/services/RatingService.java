package com.soaassignment.Rating.RatingSerivce.services;

import com.soaassignment.Rating.RatingSerivce.entities.Rating;
import com.soaassignment.Rating.RatingSerivce.entities.RatingFormat;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);
    //get all rating
    List<Rating> getRatings();


    //get all by UserId
    List<Rating> getRatingByUserId(String userId);


    //get all by hotelId
    //List<Rating> getRatingByContentId(String contentId);
    //change
    List<RatingFormat> getRatingByContentId(String contentId);
}
