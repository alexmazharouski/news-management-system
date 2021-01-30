package ru.clevertec.news.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.services.news.NewsService;
import ru.clevertec.news.services.newsdto.NewsDtoService;
import ru.clevertec.news.utils.Constants;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping(path = "api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsDtoService dtoService;

    @GetMapping(path = "/{id}")
    public News getNews(@PathVariable int id) {
        log.debug("Getting a news {}", id);
        try {
            return newsService.getNews(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/adding", consumes = "application/json")
    public ResponseEntity<String> addNews(@RequestBody NewsDto newsDto) {
        log.info("Adding a new News {}", newsDto);
        News newsForAdding = dtoService.convertToEntity(newsDto);
        newsService.addNews(newsForAdding);
        return new ResponseEntity<>(Constants.NEWS_ADDED, HttpStatus.CREATED);
    }

    @PostMapping(path = "/edit/{id}", consumes = "application/json")
    public ResponseEntity<String> updateNews(@RequestBody NewsDto newsDto, @PathVariable int id) {
        log.debug("Updating a news id {}", id);
        try {
            newsService.updateNews(newsDto, id);
            return new ResponseEntity<>(Constants.NEWS_UPDATED, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable int id) {
        log.debug("Deleting a news {}", id);
        try {
            newsService.deleteNews(id);
            return new ResponseEntity<>(Constants.NEWS_DELETED, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<News> getAllNews(@RequestParam(name = "page", defaultValue = "1") int pageNum) {
        return newsService.getAllNews(pageNum);
    }
}
