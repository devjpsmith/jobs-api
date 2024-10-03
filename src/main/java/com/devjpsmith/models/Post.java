package com.devjpsmith.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Post {
    public int id;
    public String title;
    public String description;
    public int experience;
    public List<String> skills;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", skills=" + skills +
                '}';
    }
}
