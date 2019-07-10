<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>예매 확인</h2>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>영화관 지점</th>
					<th>상영관</th>
					<th>시작 시간</th>
					<th>영화 명</th>
					<th>예매 종류</th>
					<th>관람료</th>
					<th>예매 취소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="payment" items="${payments }" varStatus="status">
					<tr>

						<td>${payment.cinema.cineInfo.cinemaName }</td>
						<td>${payment.cinema.cineInfo.roomName }</td>
						<td>${startTimes[status.index] }</td>
						<td>${payment.movie.movieName }</td>
						<td>${payment.paymentType }</td>
						<td>${payment.fee }</td>
						<td><button type="button"
								class="btn btn-sm btn-outline-secondary"
								onClick="location.href='${pageContext.request.contextPath}/deleteMyPayment/${payment.movie.movieName}?cinemaName=${payment.cinema.cineInfo.cinemaName }&roomName=${payment.cinema.cineInfo.roomName }&paymentType=${payment.paymentType }&fee=${payment.fee }&startTime=${startTimes[status.index] }'">예매
								취소</button></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>