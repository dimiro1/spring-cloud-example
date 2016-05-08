package com.example.events;

import com.example.services.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class IndexListener implements ApplicationListener<IndexEvent> {
    private GitHubService github;

    @Autowired
    public IndexListener(GitHubService github) {
        this.github = github;
    }

    @Override
    public void onApplicationEvent(IndexEvent event) {
        System.out.println(github.listRepos("dimiro1"));
    }
}