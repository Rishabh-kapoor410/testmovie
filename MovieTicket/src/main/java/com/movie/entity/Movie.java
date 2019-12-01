package com.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.movie.common.Constants.MovieStatus;
import com.movie.common.Constants.MovieType;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "movieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	private Long theaterId;
	private MovieType movieType;
	private MovieStatus movieStatus;

	public Long getMovieId() {
		return movieId;
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

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
