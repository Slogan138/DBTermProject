package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Seat;

@Repository
@Transactional
public class SeatDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Seat> getCurrentSeats(String cinemaName, String roomName, String startTime) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Seat where cinema_name = :cinemaName and room_name = :roomName and start_time = :startTime order by seatNumber asc");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("startTime", startTime);
		List<Seat> seats = query.getResultList();

		return seats;
	}

	public List<Seat> getPaymentByPaymentIndex(int paymentIndex) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Seat where payment_index = :paymentIndex");
		query.setParameter("paymentIndex", paymentIndex);
		return query.getResultList();
	}

	public void updateSeat(Seat seat) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(seat);
		session.flush();
	}

	public void deleteSeat(int paymentIndex) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Seat where payment_index = :paymentIndex");
		query.setParameter("paymentIndex", paymentIndex);
		query.executeUpdate();

	}
}
