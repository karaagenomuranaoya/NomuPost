package com.example.chatapp3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.example.chatapp3.service.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.chatapp3.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.chatapp3.model.Post;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    
    //コメントの作成
    @PostMapping
    public String createComment(@ModelAttribute Comment comment, @RequestParam Long post, Model model) {
        Post associatedPost = postService.getPostById(post);
        comment.setPost(associatedPost);
        commentService.saveComment(comment);
        return "redirect:/" + post; // 投稿詳細ページにリダイレクト
    }
    
    // @PostMapping("/delete/{commentId}")
    // public String deleteComment(@PathVariable Long commentId, @RequestParam Long postId) {
    //     commentService.deleteComment(commentId);
    //     return "redirect:/posts/" + postId; // 投稿詳細ページにリダイレクト
    // }
    
    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id, @RequestParam Long postId) {
        System.out.println("Deleting comment with ID: " + id);
        System.out.println("Associated post ID: " + postId);
        commentService.deleteComment(id);
        return "redirect:/" + postId;
    }
}
