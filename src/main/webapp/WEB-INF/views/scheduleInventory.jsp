<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>스케줄 관리</h2>
		<p>스케줄 현황</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary text-white">
					<th>지점</th>
					<th>상영관 번호</th>
					<th>상영관 유형</th>
					<th>자리 개수</th>
					<th>영화 제목</th>
					<th>시작 시간</th>
					<th>종료 시간</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="schedule" items="${scheduleList }">
					<tr>
						<td>${schedule.scheduleInfo.cinema.cineInfo.cinemaName }</td>
						<td>${schedule.scheduleInfo.cinema.cineInfo.roomName}</td>
						<td>${schedule.category}</td>
						<td>${schedule.remainSeatsCount }</td>
						<td>${schedule.movie.movieName }</td>
						<td>${schedule.scheduleInfo.startTime }</td>
						<td>${schedule.endTime }</td>
						<td><a
							href="<c:url value="/admin/scheduleInventory/updateSchedule/?startTime=${schedule.scheduleInfo.startTime }&cinemaName=${schedule.scheduleInfo.cinema.cineInfo.cinemaName}&roomName=${schedule.scheduleInfo.cinema.cineInfo.roomName}"/>"><i
								class="far fa-file-alt fa-2x"></i></a> <a
							href="<c:url value="/admin/scheduleInventory/deleteSchedule/?startTime=${schedule.scheduleInfo.startTime }&cinemaName=${schedule.scheduleInfo.cinema.cineInfo.cinemaName}&roomName=${schedule.scheduleInfo.cinema.cineInfo.roomName}"/>"><i
								class="far fa-trash-alt fa-2x"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="/admin/scheduleInventory/addSchedule/"/>"
			class="btn btn-primary">스케줄 추가하기</a>

	</div>
</div>
