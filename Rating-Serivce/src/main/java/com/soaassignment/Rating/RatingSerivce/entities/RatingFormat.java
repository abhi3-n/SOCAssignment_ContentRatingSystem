package com.soaassignment.Rating.RatingSerivce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingFormat {
    private String contentName;
    private String userName;
    private int rating;
    private String feedback;
}
