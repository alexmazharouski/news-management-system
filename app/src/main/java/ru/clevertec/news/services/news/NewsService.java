package ru.clevertec.news.services.news;

import org.springframework.data.domain.Pageable;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;

import java.util.List;

public interface NewsService {
    News getNews(int newsId);

    void addNews(News news);

    void updateNews(NewsDto newsDto);

    void deleteNews(int newsId);

    List<News> getAllNews(Pageable pageable);
}
