package ru.clevertec.news.entities.comment;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.entities.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "usersid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "newsid")
    private News news;
}
