package kr.ac.hansung.cse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Cinema;

@Repository
@Transactional
public class CinemaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int getSeatsCount(String cinemaName, String roomName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select roomSeats from Cinema where cinema_name = :cinemaName and room_name = :roomName");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		int seatsCount = (Integer) query.uniqueResult();

		return seatsCount;
	}

	public Cinema getCinemaByCinemaNameAndRoomName(String cinemaName, String roomName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cinema where cinema_name = :cinemaName and room_name = :roomName");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		return (Cinema) query.uniqueResult();
	}
}
