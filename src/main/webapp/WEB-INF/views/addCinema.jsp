<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>상영관 생성하기</h1>
		<p class="lead">상영관를 생성할 수 있습니다</p>

		<sf:form
			action="${pageContext.request.contextPath}/admin/cinemaInventory/addCinema?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="cinema" enctype="multipart/form-data">

			<div class="form-group">
				<label for="CineInfo.cinemaName">상영관 이름</label>
				<sf:input path="CineInfo.cinemaName" id="CineInfo.cinemaName" class="form-control" />
				<sf:errors path="CineInfo.cinemaName" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="CineInfo.roomName">상영관 번호</label>
				<sf:input path="CineInfo.roomName" id="CineInfo.roomName" class="form-control" />
			</div>

			<div class="form-group">
				<label for="location">지역</label>
				<sf:input path="location" id="actor" class="form-control" />
				<sf:errors path="location" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="roomSeats">자리 개수</label>
				<sf:input path="roomSeats" id="roomSeats" class="form-control" />
				<sf:errors path="roomSeats" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="roomType">상영관 유형</label>
				<sf:input path="roomType" id="roomType" class="form-control" />
				<sf:errors path="roomType" cssStyle="color:#ff0000;" />
			</div>

			
			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/cinemaInventory" /> "
				class="btn btn-default">Cancel</a>
		</sf:form>
		<br>
	</div>
</div>