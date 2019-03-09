package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @GetMapping("/test")
    public ModelAndView home(Map<String, Object> model) {

        List<Article> articles = IntStream.range(0, 10)
                .mapToObj(i -> generateArticle("Article Title " + i))
                .collect(Collectors.toList());
    
        model.put("articles", articles);

        return new ModelAndView("main", model);
    }

    private Article generateArticle(String title) {
        Article article = new Article();
        article.setTitle(title);
        article.setBody(
                "test!!");
        return article;
    }


}
