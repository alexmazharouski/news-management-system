package ru.clevertec.news.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.services.news.NewsService;
import ru.clevertec.news.services.newsdto.NewsDtoService;
import ru.clevertec.news.services.user.Constants;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "api/news")
public class NewsController {

    private NewsService newsService;
    private NewsDtoService dtoService;

    public NewsController(NewsService newsService, NewsDtoService dtoService) {
        this.newsService = newsService;
        this.dtoService = dtoService;
    }

    @GetMapping(path = "/{id}")
    public NewsDto getNews(@PathVariable int id) {
        News news = newsService.getNews(id);
        try {
            return dtoService.convertToDto(news);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/adding", consumes = "application/json")
    public ResponseEntity<String> addNews(@RequestBody NewsDto newsDto) {
        News newsForAdding = dtoService.convertToEntity(newsDto);
        newsService.addNews(newsForAdding);
        return new ResponseEntity<>(Constants.NEWS_ADDED, HttpStatus.OK);
    }

    @PostMapping(path = "/edit/{id}", consumes = "application/json")
    public ResponseEntity<String> updateNews(@RequestBody NewsDto newsDto, @PathVariable int id) {
        try {
            newsService.updateNews(newsDto, id);
            return new ResponseEntity<>("Good", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
