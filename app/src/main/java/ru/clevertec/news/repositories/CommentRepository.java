package ru.clevertec.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.comment.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
