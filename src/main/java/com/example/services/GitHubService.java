package com.example.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@FeignClient(value = "github", url = "https://api.github.com/", fallback = GitHubServiceFallback.class)
public interface GitHubService {
    @RequestMapping(method = RequestMethod.GET, value = "users/{user}/repos", consumes = "application/json")
    List<Repo> listRepos(@PathVariable("user") String user);
}

@Component
class GitHubServiceFallback implements GitHubService {
    @Override
    public List<Repo> listRepos(String user) {
        return Collections.emptyList();
    }
}

