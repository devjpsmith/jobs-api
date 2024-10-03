package com.devjpsmith.controllers;

import com.devjpsmith.models.Post;
import com.devjpsmith.services.PostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostsController {
    private final PostsService _service;

    public PostsController(PostsService service) {
        _service = service;
    }

    @GetMapping("posts")
    public List<Post> get() {
        return _service.getAllPosts();
    }

    @PostMapping("posts")
    public void post(@RequestBody Post post) {
        _service.addNewPost(post);
    }

    @GetMapping("posts/{id}")
    public Post getById(@PathVariable int id) {
        return null;
    }
}
