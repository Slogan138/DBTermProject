<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>상영관 목록 관리</h2>
		<p>상영관 목록 현황</p>			
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary text-white">
					<th>상영관 이름</th>
					<th>상영관 번호</th>					
					<th>지역</th>
					<th>상영관 유형</th>
					<th>좌석 갯수</th>					
					<th>수정/삭제 </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cinema" items="${cinemaList }">				
					<tr>
						<td>${cinema.cineInfo.cinemaName }</td>
						<td>${cinema.cineInfo.roomName }</td>											
						<td>${cinema.location }</td>
						<td>${cinema.roomType }</td>
						<td>${cinema.roomSeats }</td>						
						<td>						
							<a href="<c:url value="/admin/cinemaInventory/updateCinema/?name=${cinema.cineInfo.cinemaName }&num=${cinema.cineInfo.roomName}"/>"><i class="far fa-file-alt fa-2x"></i></a>
							<a href="<c:url value="/admin/cinemaInventory/deleteCinema/?name=${cinema.cineInfo.cinemaName }&num=${cinema.cineInfo.roomName}"/>"><i class="far fa-trash-alt fa-2x"></i></a> 							 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="/admin/cinemaInventory/addCinema/"/>" class="btn btn-primary">상영관 추가하기</a>
		
	</div>
</div>
