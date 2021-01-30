package ru.clevertec.news.services.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.news.dto.CommentDto;
import ru.clevertec.news.entities.comment.Comment;
import ru.clevertec.news.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentApiService implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentDto> getCommentsForNews(int newsId) {
        List<CommentDto> dtoList = new ArrayList<>();
        for (Comment comment : commentRepository.findByNewsId(newsId)) {
            dtoList.add(new CommentDto(comment.getMessage(), comment.getUser().getUsername()));
        }
        return dtoList;
    }
}
