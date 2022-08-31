package com.brunoyam.movieinfo.service.impl;

import com.brunoyam.movieinfo.dto.MovieInfoDto;
import com.brunoyam.movieinfo.model.MovieInfo;
import com.brunoyam.movieinfo.repository.MovieInfoRepository;
import com.brunoyam.movieinfo.service.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService {
    private final MovieInfoRepository movieInfoRepository;

    @Override
    public List<MovieInfoDto> getMovieInfo() {
        List<MovieInfoDto> movieInfoDtoList = new LinkedList<>();

        List<MovieInfo> movieInfoList = movieInfoRepository.findAll();
        for (MovieInfo movieInfo : movieInfoList) {
            MovieInfoDto movieInfoDto = new MovieInfoDto();

            movieInfoDto.setId(movieInfo.getId());
            movieInfoDto.setName(movieInfo.getName());
            movieInfoDto.setCategory(movieInfo.getCategory());
            movieInfoDto.setDescription(movieInfo.getDescription());

            movieInfoDtoList.add(movieInfoDto);
        }
        return movieInfoDtoList;
    }

    @Override
    public MovieInfoDto getMovieInfo(Long id) {

        MovieInfo movieInfo = getMovieInfoById(id);

        MovieInfoDto movieInfoDto = new MovieInfoDto();

        movieInfoDto.setId(movieInfo.getId());
        movieInfoDto.setName(movieInfo.getName());
        movieInfoDto.setCategory(movieInfo.getCategory());
        movieInfoDto.setDescription(movieInfo.getDescription());

        return movieInfoDto;
    }

    @Override
    public void addMovieInfo(MovieInfo movieInfoDto) {
        MovieInfo movieInfo = new MovieInfo();

        movieInfo.setId(movieInfoDto.getId());
        movieInfo.setName(movieInfoDto.getName());
        movieInfo.setCategory(movieInfoDto.getCategory());
        movieInfo.setDescription(movieInfoDto.getDescription());

        movieInfoRepository.save(movieInfo);

    }

    @Override
    public void updateMovieInfo(Long id, MovieInfoDto movieInfoDto) {
        MovieInfo movieInfo = getMovieInfoById(id);

        movieInfo.setName(movieInfoDto.getName());
        movieInfo.setCategory(movieInfoDto.getCategory());
        movieInfo.setDescription(movieInfoDto.getDescription());

        movieInfoRepository.save(movieInfo);
    }

    @Override
    public void deleteMovieInfo(Long id) {
        movieInfoRepository.deleteById(id);
    }
    private MovieInfo getMovieInfoById(Long id) {

        Optional<MovieInfo> optionalMovieInfo = movieInfoRepository.findById(id);

        if (!optionalMovieInfo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Фильм с индентификатором %d не найден", id));
        }
        return optionalMovieInfo.get();
    }
}
