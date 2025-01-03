package com.example.chatapp3.repository;

import com.example.chatapp3.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // デフォルトでCRUD操作が可能
}
