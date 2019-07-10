package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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

	public List<Payment> getPayment(String cinemaName, String roomName, String movieName, int username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Payment where cinema_name = :cinemaName and room_name = :roomName and movie_name = :movieName and user_id = :username");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("movieName", movieName);
		query.setParameter("username", username);
		List<Payment> payments = query.getResultList();
		return payments;
	}

	public List<Payment> getPaymentsByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Payment where user_id = :username");
		query.setParameter("username", userId);
		return query.getResultList();
	}

	public Payment getUniquePayment(int userId, String movieName, String cinemaName, String roomName,
			String paymentType, int fee) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Payment where user_id = :userId and movie_name = :movieName and cinema_Name = :cinemaName and room_name = :roomName and paymentType = :paymentType and fee = :fee");
		query.setParameter("userId", userId);
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("paymentType", paymentType);
		query.setParameter("fee", fee);
		query.setParameter("movieName", movieName);

		return (Payment) query.getSingleResult();
	}

	public void deleteMyPayment(int paymentIndex) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Payment where payment_index = :paymentIndex");
		query.setParameter("paymentIndex", paymentIndex);
		query.executeUpdate();
	}

	public Payment getPaymentByPaymentIndex(int paymentIndex) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Payment where payment_index = :paymentIndex");
		query.setParameter("paymentIndex", paymentIndex);

		return (Payment) query.getSingleResult();
	}
}
