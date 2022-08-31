package com.brunoyam.moviecategory.controller;

import com.brunoyam.moviecategory.dto.MovieDto;

import com.brunoyam.moviecategory.service.MovieCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieCategoryController {

    private final MovieCategoryService movieCategoryService;

    @GetMapping
    public List<MovieDto> getMovieCategory(@RequestParam(name = "category") String category){
        return movieCategoryService.getMovieByCategory(category);
    }
}
