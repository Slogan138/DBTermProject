package kr.ac.hansung.cse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Payment;

@Repository
@Transactional
public class PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void updatePayment(Payment payment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(payment);
		session.flush();
	}
}
