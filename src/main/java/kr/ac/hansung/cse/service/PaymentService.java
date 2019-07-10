package kr.ac.hansung.cse.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.CinemaDao;
import kr.ac.hansung.cse.dao.MovieDao;
import kr.ac.hansung.cse.dao.PaymentDao;
import kr.ac.hansung.cse.dao.SeatDao;
import kr.ac.hansung.cse.dao.UserDao;
import kr.ac.hansung.cse.model.CineInfo;
import kr.ac.hansung.cse.model.Cinema;
import kr.ac.hansung.cse.model.Movie;
import kr.ac.hansung.cse.model.Payment;
import kr.ac.hansung.cse.model.Seat;
import kr.ac.hansung.cse.model.User;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private CinemaDao cinemaDao;
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SeatDao seatDao;

	public void updatePayment(String cinemaName, String roomName, String movieName, String username, String paymentType,
			int fee) {

		Payment payment = new Payment();

		Cinema cinema = cinemaDao.getCinemaByCinemaNameAndRoomName(cinemaName, roomName);

		Movie movie = movieDao.getMovieByMovieName(movieName);

		User user = userDao.getUserByUsername(username);

		payment.setCinema(cinema);
		payment.setMovie(movie);
		payment.setUser(user);
		payment.setPaymentType(paymentType);
		payment.setFee(fee);

		paymentDao.updatePayment(payment);
	}

	public int calcFee(int adult, int teenager, int benefit) {
		return (10000 * adult) + (8000 * teenager) + (6000 * benefit);
	}

	public List<Payment> getPaymentByUserId(int userId) {
		return paymentDao.getPaymentsByUserId(userId);
	}

	public void deleteMyPayment(int userId, String movieName, String cinemaName, String roomName, String paymentType,
			int fee) {

		List<Seat> willDelete = seatDao.getPaymentByPaymentIndex(paymentDao
				.getUniquePayment(userId, movieName, cinemaName, roomName, paymentType, fee).getPaymentIndex());
		int paymentIndex = paymentDao.getUniquePayment(userId, movieName, cinemaName, roomName, paymentType, fee)
				.getPaymentIndex();

		seatDao.deleteSeat(paymentIndex);

		paymentDao.deleteMyPayment(paymentIndex);
	}
}
