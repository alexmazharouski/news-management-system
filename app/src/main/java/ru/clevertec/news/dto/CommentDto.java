package ru.clevertec.news.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class CommentDto {
    private final String message;
    private final String userName;
}
