package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="genre")
public class Genre {

	@Id @Column(name="genre_id")
	private int genre_id;
	@Column(name="genre_name")
	private String genre_name;
	// Using Hibernate you can map relationships, here we have a one to many, mapped from the genre side
	// If used on the other side -> @ManyToOne(fetch=FetchType.Eager, mappedBy="genre")
	// Eager, will fetch all of the associated objects when retrieving our genres.
	// The other way is lazy loading, it would return proxies rather than the actual associations. 
	// It does this by subclassing the class, which is why a Hibernate entity cannot be a final class.
	//@OneToMany(fetch=FetchType.EAGER, mappedBy="genre")
	//private List<Movie> movies;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(int genre_id, String genre_name) {
		super();
		this.genre_id = genre_id;
		this.genre_name = genre_name;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

//	public List<Movie> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + genre_id;
		result = prime * result + ((genre_name == null) ? 0 : genre_name.hashCode());
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
		Genre other = (Genre) obj;
		if (genre_id != other.genre_id)
			return false;
		if (genre_name == null) {
			if (other.genre_name != null)
				return false;
		} else if (!genre_name.equals(other.genre_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", genre_name=" + genre_name + "]";
	}
}
