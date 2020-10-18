package com.io.badri.vehicles.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "posts")
public class Post {

	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
		private int id;
	    private String title; // title of the post
		private String location; //location of the post
		private String photoURL;
		private Instant postedAt;
		
		@ManyToOne(optional = false) //fetch = FetchType.LAZY, 
		private User user;
		
		public Post() {}
		
		public Post(int id, String title, String location, String photoURL, Instant postedAt) {
			this.id = id;
			this.title = title;
			this.location = location;
			this.photoURL = photoURL;
			this.postedAt = postedAt;
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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", location=" + location
					+ ", photoURL=" + photoURL + ", postedAt=" + postedAt + "]";
		}		
}
