package com.soaasignment.User.Service.impl;

import com.soaasignment.User.Service.entities.Content;
import com.soaasignment.User.Service.entities.Rating;
import com.soaasignment.User.Service.entities.User;
import com.soaasignment.User.Service.exceptions.ResourceNotFoundException;
import com.soaasignment.User.Service.repositories.UserRepository;
import com.soaasignment.User.Service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User saveUser(User user) {
        String userId =  UUID.randomUUID().toString();
        user.setUserid(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        ArrayList<User> userArrayList = (ArrayList<User>) userRepository.findAll();
        for (User user :
                userArrayList) {
            Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Rating[].class);
            List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

            List<Rating> ratingList = ratings.stream().map(rating ->{
                ResponseEntity<Content> contentResponseEntity = restTemplate.getForEntity("http://CONTENT-SERVICE/content/"+rating.getContentid(),Content.class);
                Content content = contentResponseEntity.getBody();
                rating.setContent(content);
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratingList);
        }
        return userArrayList;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Requested User Id not found" + userId));
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating ->{
        ResponseEntity<Content> contentResponseEntity = restTemplate.getForEntity("http://CONTENT-SERVICE/content/"+rating.getContentid(),Content.class);
        Content content = contentResponseEntity.getBody();
        rating.setContent(content);
        return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);



//        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), ArrayList.class);
//        user.setRatings(ratingsOfUser);

        return user;
    }

    @Override
    public User getUserName(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Requested User Id not found" + userId));
        return user;
    }
}
