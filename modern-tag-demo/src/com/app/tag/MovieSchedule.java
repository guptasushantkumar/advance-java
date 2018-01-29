package com.app.tag;

public class MovieSchedule {

	private String movieName;
	
	private String showTimes;
	
	public MovieSchedule(String movieName, String showTimes) {
		super();
		this.movieName = movieName;
		this.showTimes = showTimes;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}
	
	
}
