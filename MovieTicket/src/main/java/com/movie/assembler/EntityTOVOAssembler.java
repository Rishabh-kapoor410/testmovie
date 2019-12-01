package com.movie.assembler;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import com.movie.entity.Movie;
import com.movie.entity.User;
import com.movie.entity.vo.MovieVO;
import com.movie.entity.vo.UserVO;

public final class EntityTOVOAssembler {

	static Logger logger = Logger.getLogger(EntityTOVOAssembler.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("EntityTOVOAssembler");

	public static UserVO fillUserVO(User user) {
		UserVO userVO = new UserVO();
		Optional.ofNullable(user.getId()).ifPresent(x -> userVO.setId(x));
		Optional.ofNullable(user.getUsername()).ifPresent(x -> userVO.setUsername(x));
		Optional.ofNullable(user.getEmails()).ifPresent(x -> userVO.setEmail(x));
		return userVO;
	}

	public static MovieVO fillMovieVO(Movie movie) {
		MovieVO movieVO = new MovieVO();
		Optional.ofNullable(movie.getMovieId()).ifPresent(x -> movieVO.setId(x));
		Optional.ofNullable(movie.getMovieStatus()).ifPresent(x -> movie.setMovieStatus(x));
		Optional.ofNullable(movie.getMovieType()).ifPresent(x -> movie.setMovieType(x));
		Optional.ofNullable(movie.getTheaterId()).ifPresent(x -> movie.setTheaterId(x));

		return movieVO;

	}
}