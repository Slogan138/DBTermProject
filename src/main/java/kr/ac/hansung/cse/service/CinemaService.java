package kr.ac.hansung.cse.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.hansung.cse.dao.CinemaDao;

import org.springframework.stereotype.Service;

@Service
public class CinemaService {

	@Autowired
	private CinemaDao cinemaDao;

	public int getSeatsCount(String cinemaName, String roomName) {
		return cinemaDao.getSeatsCount(cinemaName, roomName);
	}

}
