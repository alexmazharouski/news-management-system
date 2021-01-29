package ru.clevertec.news.services.news;

import org.springframework.stereotype.Service;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.repositories.NewsRepository;

import java.util.NoSuchElementException;

@Service
public class NewsServiceImpl implements NewsService{

    private NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News getNews(int id) {
        return newsRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void updateNews(NewsDto newsDto, int id) {
        News news = getNews(id);
        news.setTitle(newsDto.getTitle());
        news.setArticle(newsDto.getArticle());
        news.setDate(newsDto.getDate());
        newsRepository.save(news);
    }
}
