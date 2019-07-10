package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.hansung.cse.dao.CinemaDao;
import kr.ac.hansung.cse.dao.PaymentDao;
import kr.ac.hansung.cse.dao.ScheduleDao;
import kr.ac.hansung.cse.dao.SeatDao;
import kr.ac.hansung.cse.model.Seat;
import kr.ac.hansung.cse.model.Payment;
import kr.ac.hansung.cse.model.Schedule;

import org.springframework.stereotype.Service;

@Service
public class SeatService {

	@Autowired
	private SeatDao seatDao;
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private CinemaDao cinemaDao;

	@SuppressWarnings("null")
	public int[] getRemainSeats(String cinemaName, String roomName, String startTime) {
		List<Seat> currentSeats = seatDao.getCurrentSeats(cinemaName, roomName, startTime);
		int seatsCount = cinemaDao.getSeatsCount(cinemaName, roomName);
		int[] remainSeats = new int[seatsCount];

		for (int i = 1; i < seatsCount + 1; i++) {
			remainSeats[i - 1] = i;
		}

		for (int i = 0; i < seatsCount; i++) {
			for (Seat current : currentSeats)
				if (remainSeats[i] == current.getSeatNumber())
					remainSeats[i] = 0;
		}

		return remainSeats;
	}

	public void updateSeat(String cinemaName, String roomName, String startTime, int seatNumber, String movieName,
			int username) {
		Seat seat = new Seat();

		List<Payment> payment = paymentDao.getPayment(cinemaName, roomName, movieName, username);

		Schedule schedule = scheduleDao.getSchdule(cinemaName, roomName, startTime);

		seat.setPayment(payment.get(payment.size() - 1));
		seat.setSchedule(schedule);
		seat.setSeatNumber(seatNumber);

		seatDao.updateSeat(seat);

	}
}
