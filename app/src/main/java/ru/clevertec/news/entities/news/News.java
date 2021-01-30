package ru.clevertec.news.entities.news;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import ru.clevertec.news.entities.comment.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String title;

    private LocalDate date;

    private String article;

    @OneToMany(mappedBy = "news", cascade = CascadeType.REMOVE)
    @JsonIgnore
    @ToString.Exclude
    private List<Comment> commentList;
}
