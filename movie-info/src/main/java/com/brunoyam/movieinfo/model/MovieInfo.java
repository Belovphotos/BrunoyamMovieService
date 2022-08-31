package com.brunoyam.movieinfo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MovieInfo {
    @Id
    private Long id;
    private String name;
    private String category;
    private String description;
}
