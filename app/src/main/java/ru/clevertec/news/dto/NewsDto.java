package ru.clevertec.news.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class NewsDto {
    private final String title;
    private final LocalDate date;
    private final String article;
}
