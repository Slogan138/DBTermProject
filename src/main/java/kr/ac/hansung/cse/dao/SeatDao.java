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
				"from Seat where cinema_name = :cinemaName and room_name = :roomName and start_time = :startTime");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("startTime", startTime);
		@SuppressWarnings("unchecked")
		List<Seat> seats = query.getResultList();
		return seats;
	}

	public void updateSeat(String cinemaName, String roomName, String startTime, int seatNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"insert into Seat(cinema_name,room_name,start_time,seatNumber) values (:cinemaName,:roomName,:startTime,:seatNumber");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("startTime", startTime);
		query.setParameter("seatNumber", seatNumber);
		query.executeUpdate();
	}

}
