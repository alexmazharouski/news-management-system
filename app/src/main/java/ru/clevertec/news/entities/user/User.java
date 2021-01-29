package ru.clevertec.news.entities.user;

import lombok.Getter;
import lombok.Setter;
import ru.clevertec.news.entities.comment.Comment;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
