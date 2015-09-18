package org.sandbox.hateoas;

import org.springframework.hateoas.ResourceSupport;

/**
 * Author: zhangxin
 * Date:   15-9-18
 */
public class Article extends ResourceSupport {
    private String title;
    private String author;
    private String content;
    private Integer len;
    private Long timestamp;

    public Article(String title, String author, String content, Integer len, Long timestamp) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.len = len;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
