package ru.clevertec.news.entities.user;

import lombok.Data;
import ru.clevertec.news.entities.comment.Comment;

import java.util.List;

@Data
public class User {
    private long id;
    private String username;
    private List<Comment> comments;
}
