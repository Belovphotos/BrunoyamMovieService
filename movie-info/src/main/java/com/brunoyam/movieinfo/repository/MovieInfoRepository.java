package com.brunoyam.movieinfo.repository;

import com.brunoyam.movieinfo.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long > {
}
