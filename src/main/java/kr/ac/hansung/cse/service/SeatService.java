package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.hansung.cse.dao.SeatDao;
import kr.ac.hansung.cse.model.Seat;

import org.springframework.stereotype.Service;

@Service
public class SeatService {

	@Autowired
	private SeatDao seatDao;

	public List<Seat> getCurrentSeats(String cinemaName, String roomName, String startTime) {
		return seatDao.getCurrentSeats(cinemaName, roomName, startTime);
	}

	public void updateSeat(String cinemaName, String roomName, String startTime, int seatNumber) {
		seatDao.updateSeat(cinemaName, roomName, startTime, seatNumber);
	}
}
