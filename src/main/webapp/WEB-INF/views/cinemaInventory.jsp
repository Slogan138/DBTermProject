<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Cinema Inventory</h2>
		<p>상영관 현황</p>			
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>상영관 이름</th>
					<th>상영관 번호</th>					
					<th>지역</th>
					<th>자리 개수</th>
					<th>상영관 유형</th>					
					<th> </th>
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
							<a href="<c:url value="/admin/cinemaInventory/updateCinema/?name=${cinema.cineInfo.cinemaName }&num=${cinema.cineInfo.roomName}"/>"><i class="far fa-edit fa-2x"></i></a>
							<a href="<c:url value="/admin/cinemaInventory/deleteCinema/?name=${cinema.cineInfo.cinemaName }&num=${cinema.cineInfo.roomName}"/>"><i class="fa fa-times fa-2x"></i></a> 							 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<c:url value="/admin/cinemaInventory/addCinema/"/>" class="btn btn-primary">Add Cinema</a>
		
	</div>
</div>
