package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@EmbeddedId
	private PaymentInfo paymentInfo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "cinema_name"), @JoinColumn(name = "room_name"),
			@JoinColumn(name = "start_time") })
	private Schedule schedule;

	@Min(value = 1)
	@Max(value = 500)
	private int seatNumber;

}
