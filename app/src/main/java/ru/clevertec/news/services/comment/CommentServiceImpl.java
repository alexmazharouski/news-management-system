package ru.clevertec.news.services.comment;

import org.springframework.stereotype.Service;
import ru.clevertec.news.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
