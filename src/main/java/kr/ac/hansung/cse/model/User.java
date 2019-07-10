package kr.ac.hansung.cse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int id;

	@Column(name = "username")
	@NotEmpty(message = "The username must not be null")
	private String username;

	@NotEmpty(message = "The password must not be null")
	private String password;

	@NotEmpty(message = "The email must not be null")
	private String email;

	private boolean enabled = false;

	private String authority;

}
