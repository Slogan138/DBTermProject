<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h2>극장 선택</h2>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>영화관 지점</th>
					<th>상영관</th>
					<th>상영 종류</th>
					<th>시작 시간</th>
					<th>종료 시간</th>
					<th>잔여 좌석</th>
					<th>예매</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="schedule" items="${schedules }" varStatus="status">
					<tr>
						<td>${schedule.scheduleInfo.cinema.cineInfo.cinemaName }</td>
						<td>${schedule.scheduleInfo.cinema.cineInfo.roomName }</td>
						<td>${roomTypes[status.index] }</td>
						<td>${schedule.scheduleInfo.startTime }</td>
						<td>${schedule.endTime }</td>
						<td>${schedule.remainSeatsCount }</td>
						<td><button type="button"
								class="btn btn-sm btn-outline-secondary"
								onClick="location.href='${pageContext.request.contextPath}/choiceSeat/${schedule.movie.movieName }?cinemaName=${schedule.scheduleInfo.cinema.cineInfo.cinemaName}&roomName=${schedule.scheduleInfo.cinema.cineInfo.roomName }&startTime=${schedule.scheduleInfo.startTime }&roomType=${roomTypes[status.index] }'">좌석선택</button>
						</td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
