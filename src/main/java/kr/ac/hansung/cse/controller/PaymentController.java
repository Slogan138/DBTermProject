package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.Payment;
import kr.ac.hansung.cse.service.PaymentService;
import kr.ac.hansung.cse.service.ScheduleService;
import kr.ac.hansung.cse.service.SeatService;
import kr.ac.hansung.cse.service.UserService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private UserService userService;
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("/payment/{movieName}")
	public String insertPaymentInfo(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model,
			HttpServletRequest request) {
		int adult = Integer.parseInt(request.getParameter("adult"));
		int teenager = Integer.parseInt(request.getParameter("teenager"));
		int benefit = Integer.parseInt(request.getParameter("benefit"));

		int fee = paymentService.calcFee(adult, teenager, benefit);

		String[] seatNumbers = request.getParameterValues("seatNumber");

		int totalReservSeatsCount = adult + teenager + benefit;

		if (seatNumbers.length == (adult + teenager + benefit))
			model.addAttribute("seatNumbers", seatNumbers);
		else
			return "redirect:" + request.getHeader("Referer");

		model.addAttribute("adult", adult);
		model.addAttribute("teenager", teenager);
		model.addAttribute("benefit", benefit);
		model.addAttribute("fee", fee);
		model.addAttribute("totalReservSeatsCount", totalReservSeatsCount);

		model.addAttribute("cinemaName", cinemaName);
		model.addAttribute("roomName", roomName);
		model.addAttribute("startTime", startTime);
		model.addAttribute("movieName", movieName);

		return "payment";
	}

	@RequestMapping("/updatePayment/{movieName}")
	public String updatePayment(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model,
			HttpServletRequest request, HttpSession session) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String paymentType = request.getParameter("paymentType");
		int fee = Integer.parseInt(request.getParameter("fee"));

		String[] seatNumbers = request.getParameterValues("seatNumber");

		int userId = userService.getUserByUsername(username).getId();

		int totalReservSeatsCount = Integer.parseInt(request.getParameter("totalReservSeatsCount"));

		paymentService.updatePayment(cinemaName, roomName, movieName, username, paymentType, fee);

		for (String seatNumber : seatNumbers)
			seatService.updateSeat(cinemaName, roomName, startTime, Integer.parseInt(seatNumber), movieName, userId);

		scheduleService.decreaseReaminSeatsCount(totalReservSeatsCount, cinemaName, roomName, startTime);

		model.addAttribute("seatNumbers", seatNumbers);
		model.addAttribute("fee", fee);
		model.addAttribute("paymentType", paymentType);

		return "updatePayment";
	}

	@RequestMapping("/checkMyPayment")
	public String checkMyPayment(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		int userId = userService.getUserByUsername(username).getId();
		List<Payment> payments = paymentService.getPaymentByUserId(userId);

		model.addAttribute("payments", payments);
		return "checkMyPayment";
	}

	@RequestMapping("/deleteMyPayment/{movieName}")
	public String deleteMyPayment(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("paymentType") String paymentType,
			@RequestParam("fee") int fee, Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		int userId = userService.getUserByUsername(username).getId();
		paymentService.deleteMyPayment(userId, movieName, cinemaName, roomName, paymentType, fee);
		return "deleteMyPayment";
	}

}
