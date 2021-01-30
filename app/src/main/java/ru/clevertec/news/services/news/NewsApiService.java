package ru.clevertec.news.services.news;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.repositories.NewsRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NewsApiService implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public News getNews(int newsId) {
        return newsRepository.findById(newsId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public void updateNews(NewsDto newsDto) {
        News news = getNews(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setArticle(newsDto.getArticle());
        news.setDate(newsDto.getDate());
        newsRepository.save(news);
    }

    @Override
    public void deleteNews(int newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public List<News> getAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable).toList();
    }
}
