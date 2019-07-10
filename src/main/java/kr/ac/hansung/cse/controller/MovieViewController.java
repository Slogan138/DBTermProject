package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.service.MovieService;

@Controller
public class MovieViewController {
	
	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping("/movies")
	public String getMovies(Model model) {
		List<Movie> movies = movieService.getMovies();
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@RequestMapping("/viewMovie/{movieName}")
	public String viewProduct(@PathVariable String movieName, Model model) {
		
		Movie movie = movieService.getMovieByMovieName(movieName);
		model.addAttribute("movie", movie);
		return "viewMovie";
		
	}

}
