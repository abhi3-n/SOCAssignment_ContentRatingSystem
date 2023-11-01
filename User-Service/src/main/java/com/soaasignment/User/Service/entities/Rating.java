package com.soaasignment.User.Service.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingid;
    private String userid;
    private String contentid;
    private String rating;
    private String feedback;
    private Content content;
}
