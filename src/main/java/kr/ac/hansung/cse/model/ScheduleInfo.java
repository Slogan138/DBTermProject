package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ScheduleInfo implements Serializable {

	private static final long serialVersionUID = -3546901577949830017L;

	@MapsId("cinema")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "cinema_name"), @JoinColumn(name = "room_name") })
	private Cinema cinema;

	@Column(name = "start_time")
	private String startTime;

}