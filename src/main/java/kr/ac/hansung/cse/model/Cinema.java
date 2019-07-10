package kr.ac.hansung.cse.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "cinema")
@Entity
public class Cinema {

	@EmbeddedId
	private CineInfo cineInfo;

	private String location;
	private String roomType;
	private int roomSeats;

}
