package kr.ac.hansung.cse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.model.Payment;
import kr.ac.hansung.cse.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@RequestMapping("/payment/{movieName}")
	public String insertPaymentInfo(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model,
			HttpServletRequest request) {
		int adult = Integer.parseInt(request.getParameter("adult"));
		int teenager = Integer.parseInt(request.getParameter("teenager"));
		int benefit = Integer.parseInt(request.getParameter("benefit"));

		int fee = (10000 * adult) + (8000 * teenager) + (6000 * benefit);
		model.addAttribute("adult", adult);
		model.addAttribute("teenager", teenager);
		model.addAttribute("benefit", benefit);
		model.addAttribute("fee", fee);
		model.addAttribute("cinemaName", cinemaName);
		model.addAttribute("roomName", roomName);
		model.addAttribute("startTime", startTime);
		return "payment";
	}

	@RequestMapping("/updatePayment/{movieName}")
	public String updatePayment(@PathVariable String movieName, @RequestParam("cinemaName") String cinemaName,
			@RequestParam("roomName") String roomName, @RequestParam("startTime") String startTime, Model model,
			HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String userId = authentication.getName();

		Payment payment = new Payment();

		int fee = Integer.parseInt(request.getParameter("fee"));

		model.addAttribute("payment", payment);
		return "updatePayment";
	}

}
