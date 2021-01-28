package ru.clevertec.news.entities.news;

import lombok.Data;
import ru.clevertec.news.entities.comment.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class News {
    @Id
    private long id;
    private String title;
    private LocalDate date;
    private String article;
    @OneToMany(mappedBy = "news")
    private List<Comment> commentList;
}
