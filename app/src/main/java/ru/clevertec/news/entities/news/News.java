package ru.clevertec.news.entities.news;

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
    private int id;
    private String title;
    private LocalDate date;
    private String article;
    @OneToMany(mappedBy = "news", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;
}
