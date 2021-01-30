package ru.clevertec.news.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.news.dto.CommentDto;
import ru.clevertec.news.services.comment.CommentService;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping(path = "/{newsId}")
    public List<CommentDto> getCommentsForNews(@PathVariable int newsId) {
        return commentService.getCommentsForNews(newsId);
    }
}
