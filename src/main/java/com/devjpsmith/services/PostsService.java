package com.devjpsmith.services;

import com.devjpsmith.models.Post;
import com.devjpsmith.repositories.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    private final PostsRepository _repository;

    public PostsService(PostsRepository repository) {
        _repository = repository;
    }

    public List<Post> getAllPosts() {
        return _repository.find();
    }

    public void addNewPost(Post post) {
        _repository.save(post);
    }
}
