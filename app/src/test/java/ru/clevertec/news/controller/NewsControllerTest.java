package ru.clevertec.news.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.clevertec.news.entities.news.News;
import ru.clevertec.news.services.news.NewsService;
import ru.clevertec.news.services.newsdto.NewsDtoService;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(NewsController.class)
public class NewsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private NewsService newsService;
    @MockBean
    private NewsDtoService dtoService;

    @Test
    public void getNewsTest() throws Exception {
        mvc.perform(get("/api/news/" + 10)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment").doesNotExist());
    }

    @Test
    public void deleteNewsTest() throws Exception {
        mvc.perform(delete("/api/news/" + 10))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getAllNewsTest() throws Exception {
        List<News> list = Collections.singletonList(new News());
        when(newsService.getAllNews(1)).thenReturn(list);
        mvc.perform(get("/api/news")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(list.size())));
    }
}
