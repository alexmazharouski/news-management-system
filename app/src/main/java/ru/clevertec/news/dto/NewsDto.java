package ru.clevertec.news.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsDto {
    private final int id;
    private final String title;
    private final LocalDate date;
    private final String article;
}
