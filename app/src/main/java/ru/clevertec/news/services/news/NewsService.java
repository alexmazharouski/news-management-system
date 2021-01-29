package ru.clevertec.news.services.news;

import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;

public interface NewsService {
    News getNews(int id);

    void addNews(News news);

    void updateNews(NewsDto newsDto, int id);
}
