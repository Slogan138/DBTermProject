package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.ScheduleDao;
import kr.ac.hansung.cse.model.Schedule;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;

	public List<Schedule> getSchedules() {
		return scheduleDao.getSchedules();
	}

	public List<Schedule> getScheduleByMovieName(String movieName) {

		return scheduleDao.getScheduleByMovieName(movieName);
	}

	public Schedule getSchedule(String cinemaName, String roomName, String startTime) {
		return scheduleDao.getSchdule(cinemaName, roomName, startTime);
	}

	public void addSchedule(Schedule schedule) {
		scheduleDao.addSchedule(schedule);

	}

	public void deleteSchedule(Schedule schedule) {
		scheduleDao.deleteSchedule(schedule);
	}

	public void updateSchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
	}

}
