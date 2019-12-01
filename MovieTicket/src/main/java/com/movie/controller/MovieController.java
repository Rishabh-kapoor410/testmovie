package com.movie.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.common.Constants;
import com.movie.common.Response;
import com.movie.entity.vo.MovieVO;
import com.movie.entity.vo.UserVO;
import com.movie.security.auth.JwtAuthenticationToken;
import com.movie.service.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	static Logger logger = Logger.getLogger(MovieController.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("MovieController");
	
	@Autowired
	IMovieService movieService;
	
	
	@PostMapping()
	@RequestMapping("/newMovie")
	public Response<?> postNewMovie(JwtAuthenticationToken token, @RequestBody MovieVO movieVO) {
		Collection<MovieVO> colMovieVO = new ArrayList<>();
		try {

			MovieVO rsltMovieVO = movieService.save(movieVO);
			if (rsltMovieVO.getId() != null) {
				colMovieVO.add(rsltMovieVO);
				return new Response<MovieVO>("Movie Saved Successfull", colMovieVO, Constants.success);
			}
			return new Response<UserVO>("Movie Save Unsuccessfull", Collections.EMPTY_LIST);
		} catch (Exception e) {
			logger.info(confidentialMarker + ",Exception in the class{} ," + e.getLocalizedMessage());
			return new Response<UserVO>("Movie Save Unsuccessfull " + e.getLocalizedMessage(), Collections.EMPTY_LIST);
		}

	}

}
