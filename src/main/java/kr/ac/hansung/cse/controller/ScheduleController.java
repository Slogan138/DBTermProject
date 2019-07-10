package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Schedule;
import kr.ac.hansung.cse.service.CinemaService;
import kr.ac.hansung.cse.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping("/schedule/{movieName}")
	public String getSchedules(@PathVariable String movieName, Model model) {
		List<Schedule> schedules = scheduleService.getScheduleByMovieName(movieName);
		String[] roomTypes = new String[schedules.size()];
		for (int i = 0; i < schedules.size(); i++)
			roomTypes[i] = schedules.get(i).getScheduleInfo().getCinema().getRoomType();

		model.addAttribute("roomTypes", roomTypes);
		model.addAttribute("schedules", schedules);
		return "schedules";
	}

}
