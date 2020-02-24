package com.bangelevenn.crudmaven.controller;

import com.bangelevenn.crudmaven.model.Post;
import com.bangelevenn.crudmaven.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/create-post") //create-blog
    public String showCreateForm(Post post) {return "create-post"; }


    @PostMapping("/create-post")
    public String createPost(@Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-post";
        }
        LocalDateTime now = LocalDateTime.now();
        post.setDate(now);
        postService.save(post);
        model.addAttribute("posts", postService.findAllByDateDesc());
        return "index";
    }


    @GetMapping("/posts")
    public String showListPosts(Model model) {
        model.addAttribute("posts", postService.findAllByDateDesc());
        return "index";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Post post = postService.findByIdPost(id);
        model.addAttribute("post", post);
        return "edit-post";
    }


    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") long id, @Valid Post post,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "edit-post";
        }
        postService.save(post);
        model.addAttribute("posts", postService.findAllByDateDesc());
        return "index";
    }


    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") long id, Model model) {
        Post post = postService.findByIdPost(id);
        postService.delete(id);
        model.addAttribute("posts", postService.findAllByDateDesc());
        return "index";
    }




}
