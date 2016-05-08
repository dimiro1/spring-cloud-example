package com.example.services;

class Repo {
    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public Repo setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Repo setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
