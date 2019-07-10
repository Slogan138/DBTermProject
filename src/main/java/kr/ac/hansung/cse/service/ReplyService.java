package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.MovieDao;
import kr.ac.hansung.cse.dao.MovieReplyDao;
import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.MovieReply;

@Service
public class ReplyService {
	
	@Autowired
	private MovieReplyDao movieReplyDao;
	
	@Autowired
	private MovieDao movieDao;
	
	public List<MovieReply> getReply(String movieName) {
		return movieReplyDao.getMovieReply(movieName);
	}

	public void addReply(String movieName, MovieReply movieReply) {
		movieReply = updateRate(movieName,movieReply);
		movieReplyDao.addMovieReply(movieReply);
		 
	}
	
	public MovieReply updateRate(String movieName, MovieReply movieReply) {
		List<MovieReply> movieReplies = getReply(movieName);
		float total = 0;
		for(MovieReply reply : movieReplies) {
			total += reply.getRate();
		}
		
		total += movieReply.getRate();
		
		float avg = total/(movieReplies.size()+1);
		Movie movie = movieDao.getMovieByMovieName(movieName);
		
		movie.setViewingRate(Float.toString(avg));
		movieDao.updateMovieItem(movie);
		
		return movieReply;
		
	}
}
