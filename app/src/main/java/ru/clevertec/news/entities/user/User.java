package ru.clevertec.news.entities.user;

import lombok.Data;
import ru.clevertec.news.entities.comment.Comment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private long id;
    private String username;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
