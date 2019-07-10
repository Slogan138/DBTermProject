<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>영화 추가하기</h1>
		<p class="lead">새로운 영화를 추가할 수 있습니다</p>

		<sf:form
			action="${pageContext.request.contextPath}/admin/movieInventory/addMovie?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="movie" enctype="multipart/form-data">

			<div class="form-group">
				<label for="movieName" style="font-weight:bold">영화 제목</label>
				<sf:input path="movieName" id="movie_name" class="form-control" />
				<sf:errors path="movieName" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="director" style="font-weight:bold">감독</label>
				<sf:input path="director" id="director" class="form-control" />
			</div>

			<div class="form-group">
				<label for="actor" style="font-weight:bold">출연진</label>
				<sf:input path="actor" id="actor" class="form-control" />
				<sf:errors path="actor" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="genre" style="font-weight:bold">장르</label>
				<sf:input path="genre" id="genre" class="form-control" />
				<sf:errors path="genre" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="releaseDate" style="font-weight:bold">개봉일</label>
				<sf:input path="releaseDate" id="releaseDate" class="form-control" />
				<sf:errors path="releaseDate" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="summary" style="font-weight:bold">줄거리</label>
				<sf:textarea path="summary" id="summary" class="form-control" rows="5"/>
				<sf:errors path="summary" cssStyle="color:#ff0000;" />
			</div>

			<div class="form-group">
				<label for="movieImage" style="font-weight:bold">영화 포스터</label>
				<sf:input path="movieImage" id="movieImage" type="file"
					class="form-control" />
			</div>
			
			<sf:hidden path="viewingRate" value="0" />

			<input type="submit" value="등록" class="btn btn-info">
			<a href="<c:url value="/admin/movieInventory" /> "
				class="btn btn-danger">취소</a>
		</sf:form>
		<br>
	</div>
</div>