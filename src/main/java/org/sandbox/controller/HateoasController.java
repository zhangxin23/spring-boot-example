package org.sandbox.controller;

import org.sandbox.hateoas.Article;
import org.sandbox.orm.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Author: zhangxin
 * Date:   15-9-18
 */
@RestController
@RequestMapping("hateoas/")
public class HateoasController {

    @RequestMapping(value = "articles/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getArticles(@PathVariable("title")String title) {
        Article article = new Article(title, "spring-boot", "1234567890987654321", 19, System.currentTimeMillis());
        article.add(linkTo(methodOn(HateoasController.class).getArticles(title)).withSelfRel());
        article.add(linkTo(methodOn(PersonController.class).getPerson(5)).withRel("author"));
        article.add(linkTo(methodOn(PersonController.class).setPersonObject(new Person())).withRel("author_obj"));
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public ResponseEntity<?> getArticleSet() {
        List<Article> articleList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Article article = new Article("article_" + i, "spring boot example", "content_" + i,
                                          "spring boot example".length(), System.currentTimeMillis());

            article.add(linkTo(methodOn(HateoasController.class).getArticles(article.getTitle())).withSelfRel());
            article.add(linkTo(methodOn(PersonController.class).getPerson(i)).withRel("author"));
            articleList.add(article);
        }

        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }
}
