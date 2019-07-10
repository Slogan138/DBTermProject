package kr.ac.hansung.cse.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.MovieReply;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.MovieService;
import kr.ac.hansung.cse.service.ReplyService;
import kr.ac.hansung.cse.service.UserService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/viewMovie/reply", method=RequestMethod.GET)
	public String addReply(@RequestParam("movie") String movieName, Model model) {	
		
		MovieReply movieReply = new MovieReply();						
		
		model.addAttribute("movieName", movieName);
		model.addAttribute("movieReply", movieReply);
		return "addReply";
	}

	@RequestMapping(value="/viewMovie/reply", method=RequestMethod.POST)
	public String addReplyPost(@Valid MovieReply movieReply, BindingResult result, HttpServletRequest request, Principal principal, @RequestParam("movieName")String movieName) {
		
		System.out.println(movieName);
		
		if(result.hasErrors()) { System.out.println("Form data has some errors");
		  List<ObjectError> errors = result.getAllErrors();
		  
		  for(ObjectError error: errors) {
			  System.out.println(error.getDefaultMessage()); 
		  }
		  
		  return "addReply"; 
		  }
		  
		  User user = userService.getUserByUsername(principal.getName());
		  Movie movie = movieService.getMovieByMovieName(movieName);
		  movieReply.setUsers(user);
		  movieReply.setMovie(movie);
		  replyService.addReply(movieName, movieReply);
		  		  
		 												  
		  return "redirect:/movies";

	}
	
	
}
