package ru.clevertec.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.news.entities.news.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
