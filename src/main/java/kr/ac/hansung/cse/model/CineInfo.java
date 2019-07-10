package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
public class CineInfo implements Serializable {

	private static final long serialVersionUID = -868478146854212776L;

	@Column(name = "cinema_name")
	private String cinemaName;
	@Column(name = "room_name")
	private String roomName;

}