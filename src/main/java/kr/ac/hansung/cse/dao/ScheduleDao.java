package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Schedule;

@Repository
@Transactional
public class ScheduleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Schedule> getSchedules() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Schedule");
		@SuppressWarnings("deprecation")
		List<Schedule> scheduleList = query.list();

		return scheduleList;
	}

	public List<Schedule> getScheduleByMovieName(String movieName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Schedule where movie_name = :movieName");
		query.setParameter("movieName", movieName);
		List<Schedule> schedules = query.getResultList();

		return schedules;
	}

	public Schedule getSchdule(String cinemaName, String roomName, String startTime) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Schedule where cinema_name = :cinemaName and room_name = :roomName and start_time = :startTime");
		query.setParameter("cinemaName", cinemaName);
		query.setParameter("roomName", roomName);
		query.setParameter("startTime", startTime);
		Schedule schedule = (Schedule) query.uniqueResult();

		return schedule;
	}

	public void updateSchedule(Schedule schedule) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(schedule);
		session.flush();
	}

	public void addSchedule(Schedule schedule) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(schedule);
		session.flush();

	}

	public Schedule deleteSchedule(Schedule schedule) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(schedule);

		return schedule;
	}
}
