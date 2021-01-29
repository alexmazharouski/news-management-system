package ru.clevertec.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.news.dto.CommentDto;
import ru.clevertec.news.services.comment.CommentService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/news")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping(path = "/{id}/comments")
    public List<CommentDto> getCommentsForNews(@PathVariable int id) {
        return commentService.getCommentsForNews(id);
    }
}
