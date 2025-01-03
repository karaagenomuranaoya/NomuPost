package com.example.chatapp3.service;

import com.example.chatapp3.model.Post;
import com.example.chatapp3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 全ての投稿を取得
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 新しい投稿を保存
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    // 特定の投稿を取得
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    // 投稿を削除
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
