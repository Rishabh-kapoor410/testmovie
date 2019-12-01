package com.movie.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.movie.common.Constants.MovieStatus;
import com.movie.common.Constants.MovieType;

@JsonInclude(Include.NON_NULL)
public class MovieVO {
	private Long id;
	private Long theaterId;
	private MovieType movieType;
	private MovieStatus movieStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTheaterId() {
		return theaterId;
	}
	public MovieType getMovieType() {
		return movieType;
	}
	public MovieStatus getMovieStatus() {
		return movieStatus;
	}
	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}
	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}
	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
}
