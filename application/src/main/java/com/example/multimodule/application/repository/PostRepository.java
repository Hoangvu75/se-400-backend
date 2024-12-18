package com.example.multimodule.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.multimodule.application.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

}
