package com.soaassignment.Content.ContentService.controllers;


import com.soaassignment.Content.ContentService.entities.Content;
import com.soaassignment.Content.ContentService.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content ){
        return ResponseEntity.status(HttpStatus.CREATED).body(contentService.create(content));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<Content> getSingleContent(@PathVariable String contentId){
        return ResponseEntity.status(HttpStatus.OK).body(contentService.getContent(contentId));
    }

    @GetMapping
    public  ResponseEntity<List<Content>> getAll(){
        return ResponseEntity.ok(contentService.getAll());
    }

    @GetMapping("/name/{contentId}")
    public ResponseEntity<String> getContentName(@PathVariable String contentId){
        return ResponseEntity.status(HttpStatus.OK).body((contentService.getContent(contentId)).getContentname());
    }
}
