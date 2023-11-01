package com.soaassignment.Rating.RatingSerivce.repositories;

import com.soaassignment.Rating.RatingSerivce.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {
    public List<Rating> findByuserid(String userId);
    public List<Rating> findBycontentid(String contentId);
}
