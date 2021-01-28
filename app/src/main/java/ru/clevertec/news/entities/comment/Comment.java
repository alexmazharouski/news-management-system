package ru.clevertec.news.entities.comment;

import lombok.Data;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.entities.user.User;

import java.time.LocalDate;

@Data
public class Comment {
    private long id;
    private String message;
    private LocalDate date;
    private User user;
    private News news;
}
