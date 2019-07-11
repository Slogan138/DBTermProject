<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>스케쥴 수정하기</h1>
		<p class="lead">스케쥴을 수정할 수 있습니다</p>

		<sf:form
			action="${pageContext.request.contextPath}/admin/scheduleInventory/updateSchedule?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="schedule" enctype="multipart/form-data">

			<div class="form-group">
				<label for="cinemaName" style="font-weight: bold">영화관 이름</label>
				<sf:input path="ScheduleInfo.Cinema.CineInfo.cinemaName" id="cinema_name" class="form-control" />
				<sf:errors path="ScheduleInfo.Cinema.CineInfo.cinemaName" cssStyle="color:#ff0000;" />
			</div>



			<div class="form-group">
				<label for="roomName" style="font-weight: bold">상영관 이름</label>
				<sf:input path="ScheduleInfo.Cinema.CineInfo.roomName" id="room_name" class="form-control" />
				<sf:errors path="ScheduleInfo.Cinema.CineInfo.roomName" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="movieName" style="font-weight: bold">영화 제목</label>
				<sf:input path="Movie.movieName" id="movie_name" class="form-control" />
				<sf:errors path="Movie.movieName" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="startTime" style="font-weight: bold">시작 시간</label>
				<sf:input path="ScheduleInfo.startTime" id="start_time" class="form-control" />
				<sf:errors path="ScheduleInfo.startTime" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="endTime" style="font-weight: bold">종료 시간</label>
				<sf:input path="endTime" id="end_time" class="form-control" />
				<sf:errors path="endTime" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="category" style="font-weight: bold">상영 종류</label>
				<sf:input path="category" id="category" class="form-control" />
				<sf:errors path="category" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="remainSeatsCount" style="font-weight: bold">상영관
					좌석 수</label>
				<sf:input path="remainSeatsCount" id="remain_seats_count"
					class="form-control" />
				<sf:errors path="remainSeatsCount" cssStyle="color:#ff0000;" />
			</div>


			<input type="submit" value="등록" class="btn btn-info">
			<a href="<c:url value="/admin/scheduleInventory" /> "
				class="btn btn-danger">취소</a>
		</sf:form>
		<br>
	</div>
</div>