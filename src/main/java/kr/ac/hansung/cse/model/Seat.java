package kr.ac.hansung.cse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seat_index")
	private int seatIndex;

	@ManyToOne
	@JoinColumn(name = "payment_index")
	private Payment payment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "cinema_name"), @JoinColumn(name = "room_name"),
			@JoinColumn(name = "start_time") })
	private Schedule schedule;

	@Min(value = 1)
	@Max(value = 500)
	private int seatNumber;

}
