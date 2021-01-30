package ru.clevertec.news.dto;

import lombok.Data;

@Data
public class CommentDto {
    private final String message;
    private final String userName;
}
