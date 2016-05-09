package com.example.controllers;

import com.example.events.IndexEvent;
import com.example.services.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Controller
public class Index {
    private static final Logger LOG = LoggerFactory.getLogger(Index.class);
    private ApplicationEventPublisher publisher;
    private GitHubService github;

    @Autowired
    public Index(ApplicationEventPublisher publisher, GitHubService github) {
        this.publisher = publisher;
        this.github = github;
    }

    @ResponseBody
    @RequestMapping("/")
    String index() {
        LOG.info("Hello World");
        publisher.publishEvent(new IndexEvent(this, "Hello World"));

        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/hello")
    String hello() {
        github.listRepos("dimiro1");
        return "OK";
    }
}
