package com.picolite.controllers;


import com.picolite.fakedb.FakeDB;
import com.picolite.models.Article;
import com.picolite.tools.FancyText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {




    @RequestMapping("/article/{id}")
    public ModelAndView articleGet(@PathVariable("id") Integer articleId) {
        System.out.println("Getting article " + articleId);
        Article a = FakeDB.fetchArticle(articleId);
        ModelAndView mav = new ModelAndView("article");
        mav.addObject("title",a.getTitle());
        mav.addObject("game",a.getGameName());
        mav.addObject("content", FancyText.convert(a.getContent()));
        return mav;
    }
}
