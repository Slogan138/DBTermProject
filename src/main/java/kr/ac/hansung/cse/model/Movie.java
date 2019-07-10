package kr.ac.hansung.cse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@Column(name = "movie_name")
	private String movieName;

	private String viewingRate;
	private String releaseDate;
	private String director;
	private String actor;
	private String genre;
	private String summary;
	private String imagePath;
	
	@Transient
	private MultipartFile movieImage;

}
