package com.picolite.fakedb;

import com.picolite.models.Article;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    public static List<Article> allArticles()
    {
        List<Article> articles = new ArrayList<>();
        articles.add(article1());
        return articles;
    }

    public static Article fetchArticle(Integer id)
    {

        return allArticles().get(id-1);
    }

    public static Article article1()
    {
        Article a = new Article();
        a.setId(1L);
        a.setTitle("A Test of Embedding With Zelda");
        a.setContent("\n" +
                "\n" +
                "This is a test of copying then pasting items via text\n" +
                "\n" +
                "<< http://localhost:8080/picolitemvc >> [[ Link test ]] \n" +
                "\n" +
                "/*/\n" +
                "\n" +
                "--the game loop\n" +
                "\n" +
                "function _init()\n" +
                "\t--toggle showing of bounding boxes\n" +
                "\tbb_show = true\n" +
                "\t\n" +
                "\t--begin with an empty array\n" +
                "\tgame_array = {}\n" +
                "\t--add the player to the array\n" +
                "\tadd(game_array, player(2,2))\n" +
                "end\n" +
                "\n" +
                "function _update60()\n" +
                " --itterate through the game array\n" +
                "\tfor obj in all(game_array) do\n" +
                "\t\t--execute the update function for each object\n" +
                "\t\tobj:update()\n" +
                "\tend\n" +
                "end\n" +
                "\n" +
                "function _draw()\n" +
                "\t--clear the screen\n" +
                "\tcls()\n" +
                "\t--draw the map\n" +
                "\tmap(0,0,0,0,16,16)\n" +
                "\t\n" +
                "\t--itterate through the game array\n" +
                "\tfor obj in all(game_array) do\n" +
                "\t\t--execute the draw function for each object\n" +
                "\t\tobj:draw()\n" +
                "\t\t\n" +
                "\t\tif bb_show then\n" +
                "\t\t\tbox = bb_coord(obj)\n" +
                "\t\t\trect(box.bbl, box.bbu,\n" +
                "\t\t\tbox.bbr, box.bbb,8)\n" +
                "\t\tend\n" +
                "\tend\n" +
                "\n" +
                "end\n" +
                "\n" +
                "/*/");
        a.setGameName("zelda");

        return a;
    }
}
