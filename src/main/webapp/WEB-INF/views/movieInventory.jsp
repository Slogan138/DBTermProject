<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container-wrapper">
	<div class="container">
		<h2>Movie Inventory</h2>
		<p>영화 상영 현황</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>영화 포스터</th>
					<th>제목</th>					
					<th>장르</th>
					<th>감독</th>
					<th>출연진</th>
					<th>개봉일</th>
					<th>줄거리</th>
					<th>평점</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${movies }">
					<tr>
						<td><img src="<c:url value="/resources/images/${movie.imagePath}" />"
						alt="image" style="width:100%"/> </td>
						<td>${movie.movieName }</td>
						<td>${movie.genre }</td>
						<td>${movie.director }</td>
						<td>${movie.actor }</td>
						<td>${movie.releaseDate }</td>
						<td>${movie.summary }</td>
						<td> <fmt:formatNumber value="${movie.viewingRate }" pattern="0.0"/> </td>

						<td>						
							<a href="<c:url value="/admin/movieInventory/updateMovie/${movie.movieName }"/>"><i class="far fa-edit fa-2x"></i></a>
							<a href="<c:url value="/admin/movieInventory/deleteMovie/${movie.movieName }"/>"><i class="fa fa-times fa-2x"></i></a>							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="/admin/movieInventory/addMovie/"/>" class="btn btn-primary">Add Movie</a>
		
	</div>
</div>
