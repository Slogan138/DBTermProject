package kr.ac.hansung.cse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class MovieReply {

	@Id
	@GeneratedValue
	@Column(name = "reply_index")
	private int replyIndex;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@ManyToOne
	@JoinColumn(name = "movie_name")
	private Movie movie;

	@Min(value = 0)
	@Max(value = 10)
	private float rate;
	private String comments;

}
