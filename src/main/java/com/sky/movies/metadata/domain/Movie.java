package com.sky.movies.metadata.domain;

public class Movie {

    private String id;

    private String name;

    private String parentalControlLevel;

    public Movie(String id, String name, String parentalControlLevel) {
        this.id = id;
        this.name = name;
        this.parentalControlLevel = parentalControlLevel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentalControlLevel() {
        return parentalControlLevel;
    }
}
