package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.MovieReply;

@Repository
@Transactional
public class MovieReplyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addMovieReply(MovieReply movieReply) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movieReply);
		session.flush();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieReply> getMovieReply(String movieName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MovieReply where movie_name= ?");
		query.setParameter(0, movieName);
		@SuppressWarnings("deprecation")
		List<MovieReply> movieReplytList = query.list();
		
		return movieReplytList;
	}
	
	

}
