package com.devjpsmith.controllers;

import com.devjpsmith.models.Post;
import com.devjpsmith.services.PostsService;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostsController {
    private final PostsService _service;

    public PostsController(PostsService service) {
        _service = service;
    }

    @GetMapping("posts")
    public List<Post> get(@RequestParam Optional<String> _term, @RequestParam Optional<String> _sort) {
        return _service.searchAllPosts(_term, _sort);
    }

    @PostMapping("posts")
    public void post(@RequestBody Post post) {
        _service.addNewPost(post);
    }

    @GetMapping("posts/{id}")
    public Post getById(@PathVariable int id) {
        return null;
    }


    @GetMapping("load")
    public void load() {
        ArrayList<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"), 80000, 90000,
                        new DateTime(2024, 10, 26, 11, 59, 59),
                        new DateTime(2024, 10, 19, 11, 59, 59)),
                new Post(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React"), 60000, 70000,
                        new DateTime(2024, 11,2, 11, 59, 59),
                        new DateTime(2024, 10, 15, 11, 59, 59)),
                new Post(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis"), 130000, 140000,
                        new DateTime(2024, 11, 15, 11, 59, 59),
                        new DateTime(2024, 10, 17, 11, 59, 59)),
                new Post(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching"), 65000, 70000,
                        new DateTime(2024, 10, 29, 1, 59, 59),
                        new DateTime(2024, 10, 10, 11, 59, 59)),
                new Post(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App"), 95000, 100000,
                        new DateTime(2024, 11, 5, 11, 59, 59),
                        new DateTime(2024, 10, 20, 11, 59, 59))
        ));

        for (Post post: posts){
            _service.addNewPost(post);
        }
    }
}
