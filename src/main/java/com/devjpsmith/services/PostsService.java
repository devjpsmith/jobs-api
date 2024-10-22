package com.devjpsmith.services;

import com.devjpsmith.models.Post;
import com.devjpsmith.repositories.PostsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostsService {
    private final PostsRepository _repository;

    public PostsService(PostsRepository repository) {
        _repository = repository;
    }

    public List<Post> getAllPosts() {
        return _repository.findAll();
    }

    public void addNewPost(Post post) {
        _repository.save(post);
    }

    public List<Post> searchAllPosts(Optional<String> term, Optional<String> sort) {
        String col = "postedDateTime";
        if (Objects.equals(sort.orElse(""), "-years")) col = "years";
        if (Objects.equals(sort.orElse(""), "-highPay")) col = "highPay";
        Sort sortCol = Sort.by(Sort.Direction.DESC, col);

        if (term.isEmpty())
            return _repository.findAll(sortCol);
//        return _repository.findByTitleContainingOrDescriptionContaining(term.get(), term.get(), sortCol);
        return _repository.searchByTitleOrDescription(term.get(), sortCol);
    }
}
