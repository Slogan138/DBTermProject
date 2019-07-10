package kr.ac.hansung.cse.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 8408379383826326451L;

	@OneToOne
	@JoinColumn(name = "payment_index")
	private Payment payment;

}