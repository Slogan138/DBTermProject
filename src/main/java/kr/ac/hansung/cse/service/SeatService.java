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
	public String[] getRemainSeats(String cinemaName, String roomName, String startTime) {
		List<String> currentSeats = seatDao.getCurrentSeats(cinemaName, roomName, startTime);
		int seatsCount = cinemaDao.getSeatsCount(cinemaName, roomName);
		String[] remainSeats = new String[seatsCount];

		for (int i = 1; i < seatsCount + 1; i++) {
			remainSeats[i - 1] = Integer.toString(i);
		}

		for (int i = 0; i < seatsCount; i++) {
			for (int j = 0; j < currentSeats.size(); j++) {
				if (remainSeats[i].equals(currentSeats.get(j)))
					remainSeats[i] = null;
				break;
			}
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
