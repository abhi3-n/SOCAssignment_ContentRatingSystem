package com.soaassignment.Content.ContentService.impl;

import com.soaassignment.Content.ContentService.entities.Content;
import com.soaassignment.Content.ContentService.exceptions.ResourceNotFoundException;
import com.soaassignment.Content.ContentService.repositiories.ContentRepository;
import com.soaassignment.Content.ContentService.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;
    @Override

    public Content create(Content content) {
        String id = UUID.randomUUID().toString();
        content.setContentid(id);
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content getContent(String id) {
        return contentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Content with given id not found"));
    }
}
