package ru.clevertec.news.entities.news;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import ru.clevertec.news.entities.comment.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
    private List<Comment> commentList;
}
