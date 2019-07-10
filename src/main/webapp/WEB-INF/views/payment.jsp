<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-wrapper">
	<div class="container">
		<h3>
			관람료 : ${fee }<br> 성인 : ${adult }<br> 청소년 : ${teenager }<br>
			우대 : ${benefit }
		</h3>
		<h4 class="mb-3">Payment</h4>
		<form
			action="${pageContext.request.contextPath}/UpdatePayment/${schedule.movie.movieName }?cinemaName=${schedule.scheduleInfo.cinema.cineInfo.cinemaName}&roomName=${schedule.scheduleInfo.cinema.cineInfo.roomName }&startTime=${schedule.scheduleInfo.startTime }"
			method="post">
			<div class="d-block my-3">
				<div class="custom-control custom-radio">
					<input id="credit" name="paymentType" type="radio"
						class="custom-control-input" checked required> <label
						class="custom-control-label" for="credit">Credit card</label>
				</div>
				<div class="custom-control custom-radio">
					<input id="debit" name="paymentType" type="radio"
						class="custom-control-input" required> <label
						class="custom-control-label" for="debit">Debit card</label>
				</div>
				<div class="custom-control custom-radio">
					<input id="paypal" name="paymentType" type="radio"
						class="custom-control-input" required> <label
						class="custom-control-label" for="paypal">PayPal</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="cc-name">Name on card</label> <input type="text"
						class="form-control" id="cc-name" placeholder="" required>
					<small class="text-muted">Full name as displayed on card</small>
					<div class="invalid-feedback">Name on card is required</div>
				</div>
				<div class="col-md-6 mb-3">
					<label for="cc-number">Credit card number</label> <input
						type="text" class="form-control" id="cc-number" placeholder=""
						required>
					<div class="invalid-feedback">Credit card number is required</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 mb-3">
					<label for="cc-expiration">Expiration</label> <input type="text"
						class="form-control" id="cc-expiration" placeholder="" required>
					<div class="invalid-feedback">Expiration date required</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="cc-cvv">CVV</label> <input type="text"
						class="form-control" id="cc-cvv" placeholder="" required>
					<div class="invalid-feedback">Security code required</div>
				</div>
			</div>
			<hr class="mb-4">
			<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
				to checkout</button>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token}" />
				<input type="hidden" name="fee" value="${fee }"/>
		</form>
	</div>
</div>