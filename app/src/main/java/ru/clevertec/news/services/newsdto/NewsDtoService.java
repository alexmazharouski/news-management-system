package ru.clevertec.news.services.newsdto;

import ru.clevertec.news.dto.NewsDto;
import ru.clevertec.news.entities.news.News;

public interface NewsDtoService {

    News convertToEntity(NewsDto newsDto);

}
