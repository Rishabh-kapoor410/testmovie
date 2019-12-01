package com.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.assembler.EntityTOVOAssembler;
import com.movie.assembler.VOToEntityAssembler;
import com.movie.entity.Movie;
import com.movie.entity.User;
import com.movie.entity.vo.MovieVO;
import com.movie.service.IMovieService;
import com.movie.user.repository.IMovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	IMovieRepository movieRepo;

	@Override
	public MovieVO save(MovieVO movieVO) {
		Movie movie = new Movie();
		Movie dBmovie = movieRepo.save(VOToEntityAssembler.fillMovie(movieVO, movie));
		return EntityTOVOAssembler.fillMovieVO(dBmovie);
		
	}

}
