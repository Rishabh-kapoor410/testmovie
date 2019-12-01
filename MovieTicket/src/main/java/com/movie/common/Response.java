package com.movie.common;

import java.util.Collection;

public class Response<T> {
	private String message; 
	private Collection<T> data;
	private String succes;
	private String error;
	private int count;
	public Response(String message, Collection<T> data, String succes, String error, int count) {
		super();
		this.message = message;
		this.data = data;
		this.succes = succes;
		this.error = error;
		this.count = count;
	}
	public Response(String message, Collection<T> data) {
		super();
		this.message = message;
		this.data = data;
	}
	public Response(String message, Collection<T> data, String succes) {
		super();
		this.message = message;
		this.data = data;
		this.succes = succes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Collection<T> getData() {
		return data;
	}
	public void setData(Collection<T> data) {
		this.data = data;
	}
	public String getSucces() {
		return succes;
	}
	public void setSucces(String succes) {
		this.succes = succes;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
