package ru.clevertec.news.services.newsdto;

import org.springframework.stereotype.Service;
import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;

import java.util.ArrayList;

@Service
public class NewsDtoServiceImpl implements NewsDtoService{
    @Override
    public NewsDto convertToDto(News news) {
        return new NewsDto(news.getTitle(), news.getDate(), news.getArticle());
    }

    @Override
    public News convertToEntity(NewsDto newsDto) {
        News news = new News();
        news.setArticle(newsDto.getArticle());
        news.setDate(newsDto.getDate());
        news.setTitle(newsDto.getTitle());
        news.setCommentList(new ArrayList<>());
        return news;
    }
}
