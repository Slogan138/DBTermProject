package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Cinema;
import kr.ac.hansung.cse.model.CineInfo;


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
	
	public List<Cinema> getCinemas() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cinema");
		
		@SuppressWarnings("deprecation")
		List<Cinema> cinemaList = query.list();
		
		return cinemaList;
		
	}
	
	public void addCinemaItem(Cinema cinema) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cinema);
		session.flush();
	}
	
	public void deleteCinemaItem(Cinema cinema) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cinema);
		session.flush();
	}
	
	public void updateCinemaItem(Cinema cinema) { 		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cinema);
		session.flush();
	}
	
	public Cinema getCinemByNameNum(String name, String num) {
		Session session = sessionFactory.getCurrentSession();
		CineInfo info = new CineInfo();
		info.setCinemaName(name);
		info.setRoomName(num);		
		Cinema cinema = (Cinema) session.get(Cinema.class, info);
		
		return cinema;
	}
}
