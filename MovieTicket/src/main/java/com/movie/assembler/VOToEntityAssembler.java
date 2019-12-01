package com.movie.assembler;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.movie.entity.Movie;
import com.movie.entity.User;
import com.movie.entity.vo.MovieVO;
import com.movie.entity.vo.UserVO;

public final class VOToEntityAssembler {

	public static User fillUser(UserVO userVO, User user) {
		
	
		Optional.ofNullable(userVO.getUsername()).ifPresent(x -> user.setUsername(x));
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional.ofNullable(userVO.getPassword()).ifPresent(x -> user.setPassword(bcrypt.encode(x)));
		Optional.ofNullable(userVO.getEmail()).ifPresent(x -> user.setEmails(x));
		return user;
	}

	public static Movie fillMovie(MovieVO movieVO, Movie movie) {
		Optional.ofNullable(movieVO.getId()).ifPresent(x -> movie.setMovieId(x));
		Optional.ofNullable(movieVO.getMovieStatus()).ifPresent(x -> movie.setMovieStatus(x));
		Optional.ofNullable(movieVO.getMovieType()).ifPresent(x -> movie.setMovieType(x));
		Optional.ofNullable(movieVO.getTheaterId()).ifPresent(x -> movie.setTheaterId(x));
		return movie;
	}
	
}
