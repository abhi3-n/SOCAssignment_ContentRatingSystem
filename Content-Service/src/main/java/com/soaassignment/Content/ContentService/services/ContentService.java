package com.soaassignment.Content.ContentService.services;

import com.soaassignment.Content.ContentService.entities.Content;

import java.util.List;

public interface ContentService {

    //create
    Content create(Content content);

    //get all contents
    List<Content> getAll();

    //get single
    Content getContent(String id);

}
