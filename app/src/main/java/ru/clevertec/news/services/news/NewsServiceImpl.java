package ru.clevertec.news.services.news;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.repositories.NewsRepository;
import ru.clevertec.news.utils.Constants;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

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

    @Override
    public void deleteNews(int id) {
        News news = getNews(id);
        newsRepository.delete(news);

    }

    @Override
    public List<News> getAllNews(int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, Constants.PAGE_SIZE);
        return newsRepository.findAll(pageable).toList();
    }
}
