<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-wrapper">
	<div class="container">
		<h2>${movie.movieName }</h2>
		<div class="row">
			<div class="col-md-6">
				<img src="<c:url value="/resources/images/${movie.imagePath }" />"
					alt="image" style="width: 80%" />
			</div>

			<div class="col-md-6">
				<p>
					<strong>장르: </strong> ${movie.genre }
				</p>
				<p>
					<strong>감독: </strong> ${movie.director }
				</p>
				<p>
					<strong>출연진: </strong> ${movie.actor }
				</p>
				<p>
					<strong>개봉일: </strong> ${movie.releaseDate }
				</p>
				<p>
					<strong>평점: </strong>					 
					  <fmt:formatNumber value="${movie.viewingRate}" pattern="0.0"/>
				</p>
				<p>
					<strong>줄거리: </strong> ${movie.summary }
				</p>

				<table>
					<c:forEach var="reply" items="${movieReplies}">
						<tr>
							<td>${reply.users.username}</td>
							<td>${reply.rate }</td>
							<td>${reply.comments }</td>
						</tr>
					</c:forEach>
				</table>
				<p>
					<a
						href="<c:url value="/viewMovie/reply?movie=${movie.movieName}"/>"
						class="btn btn-primary">Add Reply</a>
				</p>

				<p></p>
			</div>
		</div>
	</div>
</div>
