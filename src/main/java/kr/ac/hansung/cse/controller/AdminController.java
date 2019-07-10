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
import org.springframework.web.multipart.MultipartFile;

import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.MovieService;
import kr.ac.hansung.cse.service.ProductService;
import kr.ac.hansung.cse.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value="/userInventory")
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
	
	@RequestMapping(value="/movieInventory/addMovie", method=RequestMethod.GET)
	public String addMovie(Model model) {	
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		
		return "addMovie";
	}
	
	@RequestMapping(value="/movieInventory/addMovie", method=RequestMethod.POST)
	public String addMovietPost(@Valid Movie movie, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "addMovie";
		}
		
		MultipartFile movieImage = movie.getMovieImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + movieImage.getOriginalFilename());
		
		if(movieImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + movieImage.getName());
			System.out.println("filename : "  + movieImage.getOriginalFilename());
			System.out.println("size : "+ movieImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}
		
		if(movieImage != null && !movieImage.isEmpty()) {
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
	
	@RequestMapping(value="/movieInventory/updateMovie/{movieName}", method=RequestMethod.GET)
	public String updateProducts(@PathVariable String movieName, Model model) {	
		
		Movie movie = movieService.getMovieByMovieName(movieName);
				
		model.addAttribute("movie", movie);
		
		System.out.println(movie.getMovieName());
		
		return "updateMovie";
	}
	
	@RequestMapping(value="/movieInventory/updateMovie", method=RequestMethod.POST)
	public String updateMoviePost(@Valid Movie movie, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "updateMovie";
		}
		
		MultipartFile movieImage = movie.getMovieImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + movieImage.getOriginalFilename());
		
		if(movieImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + movieImage.getName());
			System.out.println("filename : "  + movieImage.getOriginalFilename());
			System.out.println("size : "+ movieImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}
		
		if(movieImage != null && !movieImage.isEmpty()) {
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
	
	@RequestMapping(value="/movieInventory/deleteMovie/{movieName}", method=RequestMethod.GET)
	public String deleteMovie(@PathVariable String movieName, HttpServletRequest request) {	
		
		Movie movie = movieService.getMovieByMovieName(movieName);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + movie.getImagePath());
		
		if(Files.exists(savePath)) {
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
	
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model) { //controller -> model -> view
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.GET)
	public String addProducts(Model model) {	
		
		Product product = new Product();
		product.setCategory("컴퓨터");
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "addProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + productImage.getOriginalFilename());
		
		if(productImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + productImage.getName());
			System.out.println("filename : "  + productImage.getOriginalFilename());
			System.out.println("size : "+ productImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}
		
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(savePath.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		product.setImageFileName(productImage.getOriginalFilename());
		
		productService.addProduct(product);
		
			
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/productInventory/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProducts(@PathVariable int id, HttpServletRequest request) {	
		
		Product product = productService.getProductById(id);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + product.getImageFileName());
		
		if(Files.exists(savePath)) {
			try {
				Files.delete(savePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		productService.deleteProduct(product);
		
		
		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/productInventory/updateProduct/{id}", method=RequestMethod.GET)
	public String updateProducts(@PathVariable int id, Model model) {	
		
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "updateProduct";
	}
	
	@RequestMapping(value="/productInventory/updateProduct", method=RequestMethod.POST)
	public String updateProductPost(@Valid Product product, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "updateProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path savePath = Paths.get(rootDirectory + "\\resources\\images\\" + productImage.getOriginalFilename());
		
		if(productImage.isEmpty() == false) {
			System.out.println("------------------file start ---------------------");
			System.out.println("name : " + productImage.getName());
			System.out.println("filename : "  + productImage.getOriginalFilename());
			System.out.println("size : "+ productImage.getSize());
			System.out.println("savePath : " + savePath);
			System.out.println("------------------file end ---------------------\n");
		}
		
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(savePath.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		product.setImageFileName(productImage.getOriginalFilename());
		
		productService.updateProduct(product);
			 
		 
		return "redirect:/admin/productInventory";
	}
}
