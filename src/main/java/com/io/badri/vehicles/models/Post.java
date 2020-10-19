package com.io.badri.vehicles.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String title; // title of the post
	private String location = "Unknown"; // location of the post
	private String photoURL;
	private Instant postedAt = Instant.now();

//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "countryid", insertable = false, updatable = false)
//	private Country country;
//
//	private Integer countryid;

	public Post() {
	}

	public Post(int id, String title, String location, String photoURL, Instant postedAt) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.photoURL = photoURL;
		this.postedAt = postedAt;
		//this.countryid = countryid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Instant getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Instant postedAt) {
		this.postedAt = postedAt;
	}
	
	

//	public Country getCountry() {
//		return country;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}
//
//	public Integer getCountryid() {
//		return countryid;
//	}
//
//	public void setCountryid(Integer countryid) {
//		this.countryid = countryid;
//	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", location=" + location + ", photoURL=" + photoURL
				+ ", postedAt=" + postedAt + "]";
	}
}
