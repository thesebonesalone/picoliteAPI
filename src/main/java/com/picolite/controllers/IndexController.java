package com.picolite.controllers;


import com.picolite.fakedb.FakeDB;
import com.picolite.models.ArticleContainer;
import com.picolite.tools.StringTools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


@Controller
public class IndexController {


    @RequestMapping("")
    public String home(Model model)
    {
        ArticleContainer articleContainer = new ArticleContainer();
        articleContainer.setArticles(FakeDB.allArticles());
        model.addAttribute("Articles", articleContainer);
        return "index";
    }



    public String randomLandingMessage()
    {
        String[] handle = new String[]{"Welcome!", "Something Exciting!", "Something Less Exciting!"};
        return StringTools.getRandom(handle);
    }
}