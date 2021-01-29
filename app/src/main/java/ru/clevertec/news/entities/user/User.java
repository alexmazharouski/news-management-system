package ru.clevertec.news.entities.user;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.clevertec.news.entities.comment.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
