package com.psl.training.demo.model;

public class CatalogItem {
	private String movieName;
	private String category;
	private int rating;

	public CatalogItem() {
		// TODO Auto-generated constructor stub
	}

	public CatalogItem(String movieName, String category, int rating) {
		super();
		this.movieName = movieName;
		this.category = category;
		this.rating = rating;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
