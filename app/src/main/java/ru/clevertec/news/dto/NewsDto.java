package ru.clevertec.news.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class NewsDto {
    private String title;
    private LocalDate date;
    private String article;
}
