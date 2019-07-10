package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.Product;

@Repository
@Transactional
public class MovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Movie> getMovies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Movie");
		
		@SuppressWarnings("deprecation")
		List<Movie> movieList = query.list();
		
		return movieList;
		
	}
	
	
	public void addMovieItem(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
		session.flush();
	}
	
	public void deleteMovieItem(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(movie);
		session.flush();
	}
	
	public Movie getMovieByMovieName(String movieName) {
		Session session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, movieName);
		
		return movie;
	}
	
	public void updateMovieItem(Movie movie) {
 		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
		session.flush();
	}
	

}
