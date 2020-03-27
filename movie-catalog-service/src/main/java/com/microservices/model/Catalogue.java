package com.microservices.model;

public class Catalogue {
	private String name;
	private String desc;
	private double rating;

	/**
	 * @param name
	 * @param desc
	 * @param d
	 */
	public Catalogue(String name, String desc, double d) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = d;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Catalogue [name=" + name + ", desc=" + desc + ", rating=" + rating + "]";
	}

}
