package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.MovieDao;
import kr.ac.hansung.cse.model.Movie;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;

	public List<Movie> getMovies() {
		return movieDao.getMovies();
	}
	
	public void addMovie(Movie movie) {
		movieDao.addMovieItem(movie);
	}
	
	public Movie getMovieByMovieName(String movieName) {
		return movieDao.getMovieByMovieName(movieName);
	}
	
	public void updateMovie(Movie movie) {
		movieDao.updateMovieItem(movie);
	}
	
	public void deleteMovie(Movie movie) {
		movieDao.deleteMovieItem(movie);
	}

	public void updateRate(String movieName, String rate) {
		Movie movie = movieDao.getMovieByMovieName(movieName);
		movie.setViewingRate(rate);
		movieDao.updateMovieItem(movie);
	}


}
