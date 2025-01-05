package com.example.chatapp3.controller;

import com.example.chatapp3.model.Post;
import com.example.chatapp3.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.chatapp3.model.Comment;



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

    @PostMapping("/deletepost")
    public String deletePost(@RequestParam Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
    
    @GetMapping("/edit")
    public String editPostForm(@RequestParam Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "edit-post";
    }
    
    @PostMapping("/edit")
    public String updatePost(@ModelAttribute Post post) {
        postService.updatePost(post);
        return "redirect:/";
    }
    
    @PostMapping("/reset")
    public String reset() {
        return "redirect:/";
    }

    @GetMapping("/{postId}")
    public String getPostDetails(@PathVariable Long postId, Model model) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "post-detail";
    }
}
