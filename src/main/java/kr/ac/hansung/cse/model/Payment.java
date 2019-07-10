package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "payment")
@Entity
public class Payment implements Serializable {

	private static final long serialVersionUID = -8613748833734007035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_index")
	private int paymentIndex;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "cinema_name"), @JoinColumn(name = "room_name") })
	private Cinema cinema;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_name")
	private Movie movie;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private User user;

	private String paymentType;

	@Min(value = 1)
	private int fee;

}
