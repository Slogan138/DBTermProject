<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${flag }">
	<script>
		alert('예매 수와 좌석 수를 확인하여 주세요.');
		history.go(-1);
	</script>
</c:if>


<div class="container-wrapper">
	<div class="container">
		<form
			action="${pageContext.request.contextPath}/updatePayment/${movieName }?cinemaName=${cinemaName }&roomName=${roomName }&startTime=${startTime }"
			method="post">
			<h4>
				관람료 : ${fee }<br>
				<c:if test="${adult != 0 }"> 성인 : ${adult }<br>
				</c:if>

				<c:if test="${teenager != 0 }"> 청소년 : ${teenager }<br>
				</c:if>

				<c:if test="${benefit !=0 }"> 우대 : ${benefit }<br>
				</c:if>
				좌석 번호 :
				<c:forEach var="seatNumber" items="${seatNumbers }">
					<input type="hidden" id="${seatNumber }" name="seatNumber"
						value="${seatNumber }" checked />${seatNumber }
		</c:forEach>
			</h4>
			<br>
			<h4 class="mb-3">결제 정보 입력</h4>

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
					<label for="cc-number">신용 카드 번호</label> <input type="text"
						class="form-control" id="cc-number"
						placeholder="XXXX-XXXX-XXXX-XXXX">
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 mb-3">
					<label for="cc-expiration">유효 기간</label> <input type="text"
						class="form-control" id="cc-expiration" placeholder="XX/XX">
				</div>
				<div class="col-md-3 mb-3">
					<label for="cc-cvv">보안 코드</label> <input type="text"
						class="form-control" id="cc-cvv" placeholder="XXX">
				</div>
			</div>
			<hr class="mb-4">
			<button class="btn btn-primary btn-lg btn-block" type="submit">결제
				하기</button>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token}" /> <input type="hidden" name="fee"
				value="${fee }" /><input type="hidden" name="totalReservSeatsCount"
				value="${totalReservSeatsCount }" />

		</form>
		<br>
	</div>
</div>