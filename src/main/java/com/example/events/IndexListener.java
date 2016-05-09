package com.example.events;

import com.example.services.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IndexListener implements ApplicationListener<IndexEvent> {
    private RestTemplate template;

    @Autowired
    public IndexListener(RestTemplate template) {
        this.template = template;
    }

    @Override
    public void onApplicationEvent(IndexEvent event) {
        template.getForObject("http://localhost:5000/hello", String.class);
    }
}
