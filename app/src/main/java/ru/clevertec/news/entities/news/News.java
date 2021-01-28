package ru.clevertec.news.entities.news;

import lombok.Data;
import ru.clevertec.news.entities.comment.Comment;

import java.time.LocalDate;
import java.util.List;

@Data
public class News {
    private long id;
    private String title;
    private LocalDate date;
    private String article;
    private List<Comment> commentList;
}
