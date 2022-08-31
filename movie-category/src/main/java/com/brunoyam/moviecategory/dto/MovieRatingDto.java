package com.brunoyam.moviecategory.dto;

import lombok.Data;

import javax.persistence.Id;
@Data
public class MovieRatingDto {
    @Id
    private Long id;
    private String name;
    private Double rating;
}
