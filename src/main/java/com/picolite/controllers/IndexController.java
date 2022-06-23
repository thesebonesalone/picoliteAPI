package com.picolite.controllers;


import com.picolite.tools.StringTools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(ModelMap modelMap)
    {
        modelMap.addAttribute("message",randomLandingMessage());
        return "index";
    }


    public String randomLandingMessage()
    {
        String[] handle = new String[]{"Welcome!", "Something Exciting!", "Something Less Exciting!"};
        return StringTools.getRandom(handle);
    }
}
