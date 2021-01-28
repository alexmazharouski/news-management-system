package ru.clevertec.news.entities.comment;

import lombok.Data;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.entities.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Entity
public class Comment {
    @Id
    private long id;
    private String message;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "users")
    private User user;
    @ManyToOne
    @JoinColumn(name = "news")
    private News news;
}
