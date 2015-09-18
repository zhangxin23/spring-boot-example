package org.sandbox.controller;

import org.sandbox.hateoas.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
