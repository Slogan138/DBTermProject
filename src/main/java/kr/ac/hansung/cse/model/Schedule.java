package kr.ac.hansung.cse.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "schedule")
public class Schedule {

	@EmbeddedId
	private ScheduleInfo scheduleInfo;

	@ManyToOne
	@JoinColumn(name = "movie_name")
	private Movie movie;

	private String endTime;
	private String category;
	private int remainSeatsCount;

}
