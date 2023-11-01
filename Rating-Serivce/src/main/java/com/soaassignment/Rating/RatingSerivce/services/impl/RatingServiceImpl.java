package com.soaassignment.Rating.RatingSerivce.services.impl;

import com.soaassignment.Rating.RatingSerivce.entities.Rating;
import com.soaassignment.Rating.RatingSerivce.entities.RatingFormat;
import com.soaassignment.Rating.RatingSerivce.repositories.RatingRepository;
import com.soaassignment.Rating.RatingSerivce.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingid(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
//    public List<Rating> getRatings() {
//        return ratingRepository.findAll();
//    }
    public List<RatingFormat> getRatings(){
        List<Rating> ratings = ratingRepository.findAll();

        List<RatingFormat> ratingFormats = new ArrayList<>();
        for (Rating rating : ratings) {
            RatingFormat ratingFormat = new RatingFormat();
            System.out.println("content id - "+rating.getContentid());
            String contentName = restTemplate.getForObject("http://CONTENT-SERVICE/content/name/" + rating.getContentid(), String.class);
            ratingFormat.setContentName(contentName);

            String userId = rating.getUserid();
            String userName = restTemplate.getForObject("http://USER-SERVICE/users/name/" + userId, String.class);
            ratingFormat.setUserName(userName);

            ratingFormat.setRating(rating.getRating());
            ratingFormat.setFeedback(rating.getFeedback());

            ratingFormats.add(ratingFormat);
        }
        return ratingFormats;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByuserid(userId);
    }

    @Override
    //change
    public List<RatingFormat> getRatingByContentId(String contentId) {

        List<Rating> ratings = ratingRepository.findBycontentid(contentId);
        String contentName = restTemplate.getForObject("http://CONTENT-SERVICE/content/name/" + contentId, String.class);
        List<RatingFormat> ratingFormats = new ArrayList<>();
        for (Rating rating : ratings) {
            RatingFormat ratingFormat = new RatingFormat();

            ratingFormat.setContentName(contentName);

            String userId = rating.getUserid();
            String userName = restTemplate.getForObject("http://USER-SERVICE/users/name/" + userId, String.class);
            ratingFormat.setUserName(userName);

            ratingFormat.setRating(rating.getRating());
            ratingFormat.setFeedback(rating.getFeedback());

            ratingFormats.add(ratingFormat);
        }
        return ratingFormats;
    }
//    public List<Rating> getRatingByContentId(String contentId) {
    //return ratingRepository.findBycontentid(contentId);
//}
}
