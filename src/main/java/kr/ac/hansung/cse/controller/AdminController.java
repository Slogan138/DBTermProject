package kr.ac.hansung.cse.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.hansung.cse.model.Cinema;
import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.Schedule;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.CinemaService;
import kr.ac.hansung.cse.service.MovieService;
import kr.ac.hansung.cse.service.ScheduleService;
import kr.ac.hansung.cse.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private CinemaService cinemaService;

	@Autowired
	private UserService userService;

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping
	public String adminPage() {
		return "admin";
	}

	@RequestMapping(value = "/scheduleInventory")
	public String adminSchedule(Model model) {

		List<Schedule> scheduleList = scheduleService.getSchedules();
		model.addAttribute("scheduleList", scheduleList);

		return "scheduleInventory";
	}

	@RequestMapping(value = "/scheduleInventory/addSchedule", method = RequestMethod.GET)
	public String addSchedule(Model model) {

		Schedule schedule = new Schedule();
		model.addAttribute("schedule", schedule);
		return "addSchedule";
	}

	@RequestMapping(value = "/scheduleInventory/addSchedule", method = RequestMethod.POST)
	public String addCinemaPost(@Valid Schedule schedule, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "addSchedule";
		}

		scheduleService.addSchedule(schedule);

		return "redirect:/admin/scheduleInventory";
	}

	@RequestMapping(value = "/cinemaInventory")
	public String adminCinema(Model model) {
		List<Cinema> cinemaList = cinemaService.getCinemas();
		model.addAttribute("cinemaList", cinemaList);
		System.out.println("Test");
		return "cinemaInventory";
	}

	@RequestMapping(value = "/userInventory")
	public String adminUsers(Model model) {
		List<User> usersList = userService.getAllUsers();
		model.addAttribute("usersList", usersList);
		return "userInventory";
	}

	@RequestMapping("/movieInventory")
	public String adminMovie(Model model) {
		List<Movie> movies = movieService.getMovies();
		model.addAttribute("movies", movies);

		return "movieInventory";
	}

	@RequestMapping(value = "/cinemaInventory/addCinema", method = RequestMethod.GET)
	public String addCinema(Model model) {

		Cinema cinema = new Cinema();

		model.addAttribute("cinema", cinema);

		return "addCinema";
	}

	@RequestMapping(value = "/cinemaInventory/addCinema", method = RequestMethod.POST)
	public String addCinemaPost(@Valid Cinema cinema, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "addCinema";
		}

		cinemaService.addCinema(cinema);

		return "redirect:/admin/cinemaInventory";
	}

	@RequestMapping(value = "/cinemaInventory/updateCinema", method = RequestMethod.GET)
	public String updateCinemas(@RequestParam("name") String name, @RequestParam("num") String num, Model model) {

		Cinema cinema = cinemaService.getCinemaByNameNum(name, num);

		model.addAttribute(cinema);

		return "updateCinema";
	}

	@RequestMapping(value = "/cinemaInventory/updateCinema", method = RequestMethod.POST)
	public String updateCinemaPost(@Valid Cinema cinema, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "updateCinema";
		}

		cinemaService.updateCinema(cinema);

		return "redirect:/admin/cinemaInventory";
	}

	@RequestMapping(value = "/cinemaInventory/deleteCinema", method = RequestMethod.GET)
	public String deleteCinema(@RequestParam("name") String name, @RequestParam("num") String num,
			HttpServletRequest request) {

		Cinema cinema = cinemaService.getCinemaByNameNum(name, num);

		cinemaService.deleteCinema(cinema);

		return "redirect:/admin/cinemaInventory";
	}

	@RequestMapping(value = "/movieInventory/addMovie", method = RequestMethod.GET)
	public String addMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);

		return "addMovie";
	}

	@RequestMapping(value = "/movieInventory/addMovie", method = RequestMethod.POST)
	public String addMovietPost(@Valid Movie movie, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "addMovie";
		}

		MultipartFile movieImage = movie.getMovieImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		Path savePath = Paths.get(rootDirectory + "/resources/images/" + movieImage.getOriginalFilename());

		if (movieImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + movieImage.getName());
			System.out.println("filename : " + movieImage.getOriginalFilename());
			System.out.println("size : " + movieImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}

		if (movieImage != null && !movieImage.isEmpty()) {
			try {
				movieImage.transferTo(new File(savePath.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		movie.setImagePath(movieImage.getOriginalFilename());

		movieService.addMovie(movie);

		return "redirect:/admin/movieInventory";
	}

	@RequestMapping(value = "/movieInventory/updateMovie/{movieName}", method = RequestMethod.GET)
	public String updateProducts(@PathVariable String movieName, Model model) {

		Movie movie = movieService.getMovieByMovieName(movieName);

		model.addAttribute("movie", movie);

		System.out.println(movie.getMovieName());

		return "updateMovie";
	}

	@RequestMapping(value = "/movieInventory/updateMovie", method = RequestMethod.POST)
	public String updateMoviePost(@Valid Movie movie, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "updateMovie";
		}

		MultipartFile movieImage = movie.getMovieImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		Path savePath = Paths.get(rootDirectory + "/resources/images/" + movieImage.getOriginalFilename());

		if (movieImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + movieImage.getName());
			System.out.println("filename : " + movieImage.getOriginalFilename());
			System.out.println("size : " + movieImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}

		if (movieImage != null && !movieImage.isEmpty()) {
			try {
				movieImage.transferTo(new File(savePath.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		movie.setImagePath(movieImage.getOriginalFilename());

		movieService.updateMovie(movie);

		return "redirect:/admin/movieInventory";
	}

	@RequestMapping(value = "/movieInventory/deleteMovie/{movieName}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable String movieName, HttpServletRequest request) {

		Movie movie = movieService.getMovieByMovieName(movieName);

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		Path savePath = Paths.get(rootDirectory + "/resources/images/" + movie.getImagePath());

		if (Files.exists(savePath)) {
			try {
				Files.delete(savePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		movieService.deleteMovie(movie);

		return "redirect:/admin/movieInventory";
	}

	@RequestMapping(value = "/scheduleInventory/deleteSchedule", method = RequestMethod.GET)
	public String deleteCinema(@RequestParam("cinemaName") String cinemaName, @RequestParam("roomName") String roomName,
			@RequestParam("startTime") String startTime, HttpServletRequest request) {

		Schedule schedule = scheduleService.getSchedule(cinemaName, roomName, startTime);

		scheduleService.deleteSchedule(schedule);

		return "redirect:/admin/scheduleInventory";
	}

	@RequestMapping(value = "/scheduleInventory/updateSchedule", method = RequestMethod.GET)

	public String updateSchedules(@RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model) {

		Schedule schedule = scheduleService.getSchedule(cinemaName, roomName, startTime);

		model.addAttribute(schedule);

		return "updateSchedule";
	}

	@RequestMapping(value = "/scheduleInventory/updateSchedule", method = RequestMethod.POST)

	public String updateSchedulePost(@Valid Schedule schedule, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "updateSchedule";
		}

		scheduleService.updateSchedule(schedule);

		return "redirect:/admin/scheduleInventory";
	}
}
