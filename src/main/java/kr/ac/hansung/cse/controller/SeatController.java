package kr.ac.hansung.cse.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime,
			@RequestParam("roomType") String roomType, @RequestParam("category") String category, Model model) {
		Schedule schedule = scheduleService.getSchedule(cinemaName, roomName, startTime);
		int[] remainSeatNumbers = seatService.getRemainSeats(cinemaName, roomName, startTime);
		int seatsCount = cinemaService.getSeatsCount(cinemaName, roomName);
		model.addAttribute("category", category);
		model.addAttribute("roomType", roomType);
		model.addAttribute("schedule", schedule);
		model.addAttribute("remainSeatNumbers", remainSeatNumbers);
		model.addAttribute("seatsCount", seatsCount);
		return "choiceSeat";
	}

	@RequestMapping(value = "/checkMySeatNumbers/{paymentIndex}")
	public String checkSeatNumbers(@PathVariable int paymentIndex, Model model, HttpServletResponse response)
			throws Exception {
		List<Seat> seats = seatService.getSeatsByPaymentIndex(paymentIndex);

		String startScript = "<script>alert('좌석 번호 :";
		String middleScript = " ";
		String endScript = "'); history.go(-1);</script>";

		for (Seat seat : seats)
			middleScript = middleScript.concat(Integer.toString(seat.getSeatNumber()) + " ");

		String resultScript = startScript.concat(middleScript);
		resultScript = resultScript.concat(endScript);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(resultScript);
		writer.flush();

		return "checkMySeatNumbers";
	}

}
