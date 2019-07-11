<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>스케줄 추가하기</h1>
		<p class="lead">새로운 스케줄을 추가할 수 있습니다</p>

		<sf:form
			action="${pageContext.request.contextPath}/admin/scheduleInventory/addSchedule?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="movie" enctype="multipart/form-data">

			<div class="form-group">
				<label for="movieName" style="font-weight: bold">지점</label>
				<sf:input path="movieName" id="movie_name" class="form-control" />
				<sf:errors path="movieName" cssStyle="color:#ff0000;" />
			</div>

			<%-- <div class="form-group">
				<label for="director" style="font-weight: bold">상영관 번호</label>
				<sf:input path="director" id="director" class="form-control" />
			</div>

			<div class="form-group">
				<label for="actor" style="font-weight: bold">상영관 유형</label>
				<sf:input path="actor" id="actor" class="form-control" />
				<sf:errors path="actor" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="genre" style="font-weight: bold">자리개수</label>
				<sf:input path="genre" id="genre" class="form-control" />
				<sf:errors path="genre" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="releaseDate" style="font-weight: bold">영화제목</label>
				<sf:input path="releaseDate" id="releaseDate" class="form-control" />
				<sf:errors path="releaseDate" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="summary" style="font-weight: bold">시작시간</label>
				<sf:input path="releaseDate" id="releaseDate" class="form-control" />
				<sf:errors path="releaseDate" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="endTime" style="font-weight: bold">종료시간</label>
				<sf:input path="endTime" id="endTime" class="form-control" />
				<sf:errors path="endTime" cssStyle="color:#ff0000;" />
			</div>


			<input type="submit" value="등록" class="btn btn-info">
			<a href="<c:url value="/admin/movieInventory" /> "
				class="btn btn-danger">취소</a> --%>
		</sf:form> 
		<br>
	</div>
</div>