package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Using annotations to map a model, instead of using an XML file
 */

// This says the class is mapped to some entity in the DB
@Entity

// Species the model with the table name
@Table(name="movie")
public class Movie {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// This specifies this field is the primary key
	@Id	
	@Column(name="movie_id")
	private int movie_id;
	@Column(name="movie_title")
	private String movie_title;
	@ManyToOne
	@JoinColumn(name="genre")
	private Genre genre;
	@ManyToOne
	@JoinColumn(name="academy")
	private Academy academy;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int movie_id, String movie_title, Genre genre, Academy academy) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.genre = genre;
		this.academy = academy;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_Title() {
		return movie_title;
	}

	public void setMovie_Title(String movie_title) {
		this.movie_title = movie_title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academy == null) ? 0 : academy.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + movie_id;
		result = prime * result + ((movie_title == null) ? 0 : movie_title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (academy == null) {
			if (other.academy != null)
				return false;
		} else if (!academy.equals(other.academy))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (movie_id != other.movie_id)
			return false;
		if (movie_title == null) {
			if (other.movie_title != null)
				return false;
		} else if (!movie_title.equals(other.movie_title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + movie_title + ", genre=" + genre + ", academy=" + academy + "]";
	}
}

