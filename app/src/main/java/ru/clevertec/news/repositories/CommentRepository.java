package ru.clevertec.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.comment.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comment where newsid=:newsId", nativeQuery = true)
    List<Comment> findByNewsId(@Param("newsId") Integer newsId);
}
