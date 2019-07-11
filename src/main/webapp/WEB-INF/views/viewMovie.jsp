<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container-wrapper">
	<div class="container">

		<div class="row">
			<div class="col-md-4">
				<img src="<c:url value="/resources/images/${movie.imagePath }" />"
					class="img-thumbnail" alt="image" style="width: 80%">
			</div>


			<div class="col-md-6" style="font-size: 20px">
				<p style="font-size: 40px; font-weight: bold">${movie.movieName }</p>
				<p>
					<strong>장르 : </strong> ${movie.genre }
				</p>

				<p>
					<strong>감독 : </strong> ${movie.director }
				</p>
				<p>
					<strong>출연진 : </strong> ${movie.actor }
				</p>
				<p>
					<strong>개봉일 : </strong> ${movie.releaseDate }
				</p>
				<p>
					<strong>평점 : </strong>
					<fmt:formatNumber value="${movie.viewingRate}" pattern="0.0" />
				</p>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-8">
				<strong style="font-size: 20px">줄거리 </strong> <br>
				<div>
					<br>${movie.summary }</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md">
				<strong style="font-size: 20px"><br>관람평</strong><br><br>

				<table class="table table-hover">
					<tbody>
						<c:forEach var="reply" items="${movieReplies}">
							<tr>
								<td width="100">${reply.users.username}</td>
								<td width="100">${reply.rate }</td>
								<td>${reply.comments }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<p>
			<a href="<c:url value="/viewMovie/reply?movie=${movie.movieName}"/>"
				class="btn btn-info">댓글 작성</a>
		</p>

		<p></p>
	</div>
</div>


