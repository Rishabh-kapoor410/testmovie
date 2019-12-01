package com.movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.movie.entity.vo.AddressVO;
import com.movie.entity.vo.MovieVO;

public class Theatre {

	@Id
	@Column(name = "theatreId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long theaterId;
	private String theaterName;
	private AddressVO adress;

	private List<MovieVO> movies;
	float rating;
	public Long getTheaterId() {
		return theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public AddressVO getAdress() {
		return adress;
	}
	public List<MovieVO> getMovies() {
		return movies;
	}
	public float getRating() {
		return rating;
	}
	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public void setAdress(AddressVO adress) {
		this.adress = adress;
	}
	public void setMovies(List<MovieVO> movies) {
		this.movies = movies;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
}
