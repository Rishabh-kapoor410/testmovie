package com.movie.service;

import org.springframework.stereotype.Service;

import com.movie.entity.vo.MovieVO;

@Service
public interface IMovieService {

	MovieVO save(MovieVO movieVO);

}
