<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-wrapper">
	<div class="container">
		<form
			action="${pageContext.request.contextPath}/updatePayment/${movieName }?cinemaName=${cinemaName }&roomName=${roomName }&startTime=${startTime }"
			method="post">
			<h3>
				관람료 : ${fee }<br> 성인 : ${adult }<br> 청소년 : ${teenager }<br>
				우대 : ${benefit }<br>좌석 번호 :
				<c:forEach var="seatNumber" items="${seatNumbers }">
					<input type="checkbox" id="${seatNumber }" name="seatNumber"
						value="${seatNumber }" checked />${seatNumber }
		</c:forEach>
			</h3>

			<h4 class="mb-3">Payment</h4>

			<div class="d-block my-3">
				<div class="custom-control custom-radio">
					<input id="credit" name="paymentType" type="radio"
						class="custom-control-input" value="신용 카드" checked required>
					<label class="custom-control-label" for="credit">신용 카드</label>
				</div>
				<div class="custom-control custom-radio">
					<input id="phone" name="paymentType" type="radio"
						class="custom-control-input" value="휴대폰 결제" required> <label
						class="custom-control-label" for="phone">휴대폰 결제</label>
				</div>
				<div class="custom-control custom-radio">
					<input id="ticket" name="paymentType" type="radio"
						class="custom-control-input" value="관람권" required> <label
						class="custom-control-label" for="ticket">관람권</label>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label for="cc-number">Credit card number</label> <input
						type="text" class="form-control" id="cc-number"
						placeholder="XXXX-XXXX-XXXX-XXXX">
					<div class="invalid-feedback">Credit card number is required</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 mb-3">
					<label for="cc-expiration">Expiration</label> <input type="text"
						class="form-control" id="cc-expiration" placeholder="XX/XX">
					<div class="invalid-feedback">Expiration date required</div>
				</div>
				<div class="col-md-3 mb-3">
					<label for="cc-cvv">CVV</label> <input type="text"
						class="form-control" id="cc-cvv" placeholder="XXX">
					<div class="invalid-feedback">Security code required</div>
				</div>
			</div>
			<hr class="mb-4">
			<button class="btn btn-primary btn-lg btn-block" type="submit">Continue
				to checkout</button>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token}" /> <input type="hidden" name="fee"
				value="${fee }" /><input type="hidden" name="totalReservSeatsCount"
				value="${totalReservSeatsCount }" />

		</form>
	</div>
</div>