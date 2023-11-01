package com.soaassignment.Rating.RatingSerivce.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "ratingid")
    private String ratingid;
    @Column(name = "userid")
    private String userid;
    @Column(name = "contentid")
    private String contentid;
    @Column(name = "rating")
    private int rating;
    @Column(name = "feedback")
    private String feedback;
}
