package kr.ac.hansung.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.PaymentDao;
import kr.ac.hansung.cse.model.Payment;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	public void updatePayment(Payment payment) {
		paymentDao.updatePayment(payment);
	}

}
