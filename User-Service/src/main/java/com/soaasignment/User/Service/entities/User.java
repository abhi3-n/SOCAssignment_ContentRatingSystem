package com.soaasignment.User.Service.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userdata")
public class User {

    @Id
    @Column(name = "userid")
    private String userid;
    @Column(name = "uname")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private String dob;

    @Transient
    private List<Rating> ratings = new ArrayList();;
}
