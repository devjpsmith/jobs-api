package com.devjpsmith.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Post {
    @Id
    public int id;
    public String title;
    public String description;
    public int years;
    public List<String> skills;
    public int lowPay;
    public int highPay;
    public DateTime expirationDateTime;
    public DateTime postedDateTime;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + years +
                ", skills=" + skills +
                ", lowPay=" + lowPay +
                ", highPay=" + highPay +
                ", expirationDateTime" + expirationDateTime +
                ", postedDateTime" + postedDateTime +
                '}';
    }
}
