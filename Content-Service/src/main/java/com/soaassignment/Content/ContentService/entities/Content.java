package com.soaassignment.Content.ContentService.entities;


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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name  = "content")
public class Content {

    @Id
    @Column(name = "contentid")
    private String contentid;
    @Column(name = "contentname")
    private String contentname;
    @Column(name = "contenttype")
    private String contenttype;
}
