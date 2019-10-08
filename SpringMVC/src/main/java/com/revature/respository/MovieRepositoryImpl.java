package com.revature.respository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Movie;
import com.revature.util.SessionFactory;

/*
 *  In order to create beans outside of the XML, use "Spring Stereotypes." These tell the framework to manage
 *  the life cycle of any of this class. 
 *  
 *  There are specialized stereotypes which have conventional uses:
 *  
 *  @Component (a very general stereotype which should only be used when you don't know a more specific one
 *  @Service (used in the service layer of the application)
 *  @Repository (used in the data layer of the application)
 *  @Controller/@RestController (used in the web layer of our application)
 */
// This "value" corresponds to the name of the bean.
@Repository(value="movieRepository")
public class MovieRepositoryImpl implements MovieRepository{

//	@Override
//	public List<Movie> getAllMovies() {
//		List<Movie> movies = new ArrayList<>();
//		Session s = null;
//		Transaction tx = null;
//		try {
//			s = SessionFactory.getSession();
//			tx = s.beginTransaction();
//			// This is the HQL way of using Hibernate to query the database. It is object-oriented approach.
//			movies = s.createQuery("FROM Movie", Movie.class).getResultList();
//			tx.commit();
//		}catch(HibernateException e) {
//			e.printStackTrace();
//			tx.rollback();
//		}finally {
//			s.close();
//		}
//		return movies;
//	}
	
	/*
	 * We can also use SQL rather than HQL in order to do "Native Queries"
	 */
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			movies = s.createNativeQuery("SELECT * FROM Movie", Movie.class).list();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return movies;
	}
	
	public void insertMovie(Movie movie) {
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			/*
			 * You can either use save() or persist() here. Both will persist an object, but
			 * they do not work in the same way. The save() method promises to assign a unique
			 * identifier and then immediately save your object. Persist() only guarantees that
			 * your object will be persisted some time before the session ends.
			 */
			s.save(movie);
			//s.persist(m);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}
	
	public Movie getMovieById(int id) {
		Movie movie = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			// There are two methods that we can use to get a persistent instance: get() or load().
			// get() returns null if not found, load() returns an object not found exception.
			movie = s.get(Movie.class, id);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return movie;
	}
	
	public Movie getMovieByName(String name) {
		Movie movie = null;
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			// This will allow us to add restrictions to our query (similar to WHERE clause)
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
			Root<Movie> root = cq.from(Movie.class);
			cq.select(root).where(cb.equal(root.get("movie_title"), name));
			Query<Movie> q = s.createQuery(cq);
			movie = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return movie;
	}
	
	public void updateMovie(Movie movie) {
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			/*
			 * There are three ways to handle updates, merge() and update(),
			 * merge() updates a persistent entity with field values from a detached instance
			 * 
			 * update() transitions a passed object from detached to persistent; can't be called
			 * on transient objects or you'll get a PersistenceException.
			 * 
			 * saveOrUpate() makes an object persistent regardless of its state (transient or detached).
			 */
			s.merge(movie);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}
}
