package ru.clevertec.news.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.news.News;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Integer> {
}
