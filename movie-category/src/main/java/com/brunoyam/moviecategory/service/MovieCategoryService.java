package com.brunoyam.moviecategory.service;

import com.brunoyam.moviecategory.dto.MovieDto;

import java.util.List;

public interface MovieCategoryService {


    List<MovieDto> getMovieByCategory(String category);

}
