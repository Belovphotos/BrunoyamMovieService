package com.brunoyam.movieinfo.service;

import com.brunoyam.movieinfo.dto.MovieInfoDto;
import com.brunoyam.movieinfo.model.MovieInfo;

import java.util.List;

public interface MovieInfoService {
    List<MovieInfoDto> getMovieInfo();

    MovieInfoDto getMovieInfo (Long id);

    void addMovieInfo(MovieInfo movieInfoDto);

    void updateMovieInfo(Long id, MovieInfoDto movieInfoDto);

    void deleteMovieInfo(Long id);
}
