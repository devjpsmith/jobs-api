package com.devjpsmith.repositories;

import com.devjpsmith.models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTitleContainingOrDescriptionContaining(String title, String description, Sort sort);

    @Query("select p from Post p where p.title like %?1% or p.description like %?1%")
    List<Post> searchByTitleOrDescription(String term1, Sort sort);
}
