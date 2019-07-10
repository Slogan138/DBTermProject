package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.CinemaDao;
import kr.ac.hansung.cse.model.Cinema;

@Service
public class CinemaService {

	@Autowired
	private CinemaDao cinemaDao;

	public int getSeatsCount(String cinemaName, String roomName) {
		return cinemaDao.getSeatsCount(cinemaName, roomName);
	}

	public void addCinema(Cinema cinema) {
		cinemaDao.addCinemaItem(cinema);
	}

	public void updateCinema(Cinema cinema) {
		cinemaDao.updateCinemaItem(cinema);
	}

	public void deleteCinema(Cinema cinema) {
		cinemaDao.deleteCinemaItem(cinema);
	}

	public List<Cinema> getCinemas() {
		return cinemaDao.getCinemas();
	}

	public Cinema getCinemaByNameNum(String name, String num) {
		return cinemaDao.getCinemByNameNum(name, num);
	}

}
