package com.soaassignment.Content.ContentService.repositiories;

import com.soaassignment.Content.ContentService.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,String> {
}
