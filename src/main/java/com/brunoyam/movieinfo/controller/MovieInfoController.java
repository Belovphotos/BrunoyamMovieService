package com.brunoyam.movieinfo.controller;

import com.brunoyam.movieinfo.dto.MovieInfoDto;
import com.brunoyam.movieinfo.model.MovieInfo;
import com.brunoyam.movieinfo.service.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-info")
@RequiredArgsConstructor
public class MovieInfoController {
    private final MovieInfoService movieInfoService;

    @GetMapping
    public List<MovieInfoDto> getMovieInfo() {
    return  movieInfoService.getMovieInfo();
    }

    @GetMapping("/{id}")
    public MovieInfoDto getMovieInfo(@PathVariable(name = "id") Long id){
        return  movieInfoService.getMovieInfo(id);
    }
    @PostMapping
    public void addMovieInfo(@RequestBody MovieInfo movieInfoDto){
        movieInfoService.addMovieInfo(movieInfoDto);
    }

    @PutMapping("/{id}")
    public void updateMovieInfo(@PathVariable(name = "id") Long id, MovieInfoDto movieInfoDto){
        movieInfoService.updateMovieInfo(id, movieInfoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieInfo(@PathVariable(name = "id") Long id){
        movieInfoService.deleteMovieInfo(id);
    }
}
