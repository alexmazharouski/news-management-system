package ru.clevertec.news.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.enums.ResponseType;
import ru.clevertec.news.services.news.NewsService;
import ru.clevertec.news.services.newsdto.NewsDtoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsDtoService dtoService;

    @GetMapping(path = "/{id}")
    public News getNews(@PathVariable int id) {
        try {
            return newsService.getNews(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ResponseType> addNews(@RequestBody NewsDto newsDto) {
        News newsForAdding = dtoService.convertToEntity(newsDto);
        newsService.addNews(newsForAdding);
        return new ResponseEntity<>(ResponseType.ADDED, HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<ResponseType> updateNews(@RequestBody NewsDto newsDto) {
        try {
            newsService.updateNews(newsDto);
            return new ResponseEntity<>(ResponseType.UPDATED, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseType> deleteNews(@PathVariable int id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>(ResponseType.DELETED, HttpStatus.OK);
    }

    @GetMapping
    public List<News> getAllNews(@PageableDefault(page = 1, size = 5) Pageable pageable) {
        return newsService.getAllNews(pageable);
    }
}
