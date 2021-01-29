package ru.clevertec.news.services.comment;

import ru.clevertec.news.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsForNews(int id);
}
