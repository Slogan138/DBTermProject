package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.Schedule;
import kr.ac.hansung.cse.model.Seat;
import kr.ac.hansung.cse.service.CinemaService;
import kr.ac.hansung.cse.service.ScheduleService;
import kr.ac.hansung.cse.service.SeatService;

@Controller
public class SeatController {

	@Autowired
	private SeatService seatService;
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "/choiceSeat/{movieName}")
	public String getCurrentSeats(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model) {
		Schedule schedule = scheduleService.getSchedule(cinemaName, roomName, startTime);
		List<Seat> seats = seatService.getCurrentSeats(cinemaName, roomName, startTime);
		int seatsCount = cinemaService.getSeatsCount(cinemaName, roomName);

		model.addAttribute("schedule", schedule);
		model.addAttribute("seats", seats);
		model.addAttribute("seatsCount", seatsCount);
		return "choiceSeat";
	}
}
