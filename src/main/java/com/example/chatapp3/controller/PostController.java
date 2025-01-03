package com.example.chatapp3.controller;

import com.example.chatapp3.model.Post;
import com.example.chatapp3.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }
    
    @PostMapping
    public String savePost(@ModelAttribute Post post) {
        postService.savePost(post);
        
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }
    
}
