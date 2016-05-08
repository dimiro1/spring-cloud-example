package com.example.events;

import org.springframework.context.ApplicationEvent;

public class IndexEvent extends ApplicationEvent {

    private String message;

    public IndexEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
