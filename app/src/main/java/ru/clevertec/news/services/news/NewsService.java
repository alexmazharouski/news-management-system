package ru.clevertec.news.services.news;

import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;

import java.util.List;

public interface NewsService {
    News getNews(int id);

    void addNews(News news);

    void updateNews(NewsDto newsDto, int id);

    void deleteNews(int id);

    List<News> getAllNews(int pageNum);
}
