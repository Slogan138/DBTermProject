<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>관리 페이지</h2>
	</div>
	<br>
	<br>
	<br>

	<div class="card-deck">
		<div class="card bg-primary">
			<div class="card-body text-center">
				<p class="card-text">
					<a style="color: white; font-weight: bold; font-size: 20px;"
						href="<c:url value="/admin/movieInventory"/>"> 영화 목록 관리</a>
				</p>
			</div>
		</div>

		<div class="card bg-primary">
			<div class="card-body text-center">
				<p class="card-text">
					<a style="color: white; font-weight: bold; font-size: 20px;"
						href="<c:url value="/admin/userInventory"/>"> 사용자 목록 관리</a>
				</p>
			</div>
		</div>

		<div class="card bg-primary">
			<div class="card-body text-center">
				<p class="card-text">
					<a style="color: white; font-weight: bold; font-size: 20px;"
						href="<c:url value="/admin/cinemaInventory"/>">영화관 관리</a>
				</p>
			</div>
		</div>
		
		<div class="card bg-primary">
			<div class="card-body text-center">
				<p class="card-text">
					<a style="color: white; font-weight: bold; font-size: 20px;"
						href="<c:url value="/admin/scheduleInventory"/>">스케줄 관리</a>
				</p>
			</div>
		</div>
	</div>

</div>
</div>
