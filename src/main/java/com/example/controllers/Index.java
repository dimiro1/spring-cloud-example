package com.example.controllers;

import com.example.events.IndexEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Index {
    private ApplicationEventPublisher publisher;

    @Autowired
    public Index(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @ResponseBody
    @RequestMapping("/")
    String index() {
        publisher.publishEvent(new IndexEvent(this, "Hello World"));

        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/hello")
    String hello() {
        return "OK";
    }
}
