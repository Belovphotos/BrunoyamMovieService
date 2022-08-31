package com.brunoyam.moviecategory.service.impl;


import com.brunoyam.moviecategory.dto.MovieDto;
import com.brunoyam.moviecategory.dto.MovieInfoDto;
import com.brunoyam.moviecategory.dto.MovieRatingDto;
import com.brunoyam.moviecategory.service.MovieCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCategoryServiceImpl implements MovieCategoryService {
    @Value("${movieinfo.service.url}")
    private  String movieInfoServiceUrl;
    @Value("${movierating.service.url}")
    private  String movieRatingServiceUrl;

    private final RestTemplate restTemplate;

    @Override
    public List<MovieDto> getMovieByCategory(String category) {
        List<MovieInfoDto> movieInfoDtoList = getMovieInfo();
        List<MovieRatingDto> movieRatingDtoList = getMovieRating();

        List<MovieDto> movies = new LinkedList<>();

        for (MovieInfoDto movieInfoDto : movieInfoDtoList) {
            if (category.equals(movieInfoDto.getCategory())) {
                MovieDto movieDto = new MovieDto();
                movieDto.setName(movieInfoDto.getName());
                movieDto.setCategory(movieInfoDto.getCategory());
                movieDto.setDescription(movieInfoDto.getDescription());

                movies.add(movieDto);
            }
        }

        for (MovieDto movieDto :
                movies) {
            String movieName = movieDto.getName();
            for (MovieRatingDto movieRatingDto :
                    movieRatingDtoList) {
                if (movieName.equals(movieRatingDto.getName())) {
                    movieDto.setRating(movieRatingDto.getRating());
                    break;
                }
            }
        }
        return movies;
    }

    public List<MovieInfoDto> getMovieInfo() {
        ResponseEntity<List<MovieInfoDto>> responseMovieInfo = restTemplate.exchange(movieInfoServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieInfoDto>>() {
                });

        return responseMovieInfo.getBody();
    }

    public List<MovieRatingDto> getMovieRating() {
        ResponseEntity<List<MovieRatingDto>> responseMovieRating = restTemplate.exchange(movieRatingServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieRatingDto>>() {
                });
        return responseMovieRating.getBody();
    }
}
