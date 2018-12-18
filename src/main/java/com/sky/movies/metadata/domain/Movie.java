package com.sky.movies.metadata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {

    private String id;

    private String name;

    private String parentalControlLevel;
}
