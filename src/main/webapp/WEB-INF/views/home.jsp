<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main role="main">

<section class="jumbotron text-center" width="100%" height="100"
	style="padding-bottom: 0px; padding-top: 0px; padding-right: 0px; padding-left: 0px; margin-bottom: 0px;">

	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="<c:url value="/resources/images/spridermanMain.jpg" />"
					alt="image" />
				<div class="carousel-caption">
					<h3>스파이더맨: 파 프롬 홈</h3>
					<p>모든 것이 다시 시작된다!</p>
				</div>

			</div>
			<div class="carousel-item">
				<img src="<c:url value="/resources/images/toystoryMain.jpg" />"
					alt="image" />
				<div class="carousel-caption">
					<h3>토이스토리4</h3>
					<p>우리의 여행은 아직 끝나지 않았다!</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="<c:url value="/resources/images/avengersMain.jpg" />"
					alt="image" />
				<div class="carousel-caption">
					<h3>어벤져스4</h3>
					<p>Whatever it takes.</p>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>
</section>



<div class="album py-5 bg-light">
	<div class="container">
		<div class="row">
			<c:forEach var="movie" items="${movies }">
				<div class="col-md-3">
					<div class="card mb-3 shadow-sm">
						<img src="<c:url value="/resources/images/${movie.imagePath}" />"
							alt="image" width="100%" height="225" />

						<div class="card-body">
							<p class="card-text">${movie.movieName}</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary"
										onClick="location.href='${pageContext.request.contextPath}/viewMovie/${movie.movieName }'">상세정보</button>
								</div>
								<c:if test="${pageContext.request.userPrincipal.name != null }">
									<button type="button" class="btn btn-sm btn-outline-secondary"
										onClick="location.href='${pageContext.request.contextPath}/schedule/${movie.movieName }'">예매하기</button>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name == null }">
									<button type="button" class="btn btn-sm btn-outline-secondary"
										onClick="location.href='${pageContext.request.contextPath}/login'">예매하기</button>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
</main>
