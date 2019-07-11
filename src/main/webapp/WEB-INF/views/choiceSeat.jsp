<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
th {
	background: powderblue;
}
</style>

<div class="container-wrapper">
	<div class="container">
		<h2>좌석 선택</h2>
		<form
			action="${pageContext.request.contextPath}/payment/${schedule.movie.movieName }?cinemaName=${schedule.scheduleInfo.cinema.cineInfo.cinemaName}&roomName=${schedule.scheduleInfo.cinema.cineInfo.roomName }&startTime=${schedule.scheduleInfo.startTime }&roomType=${roomType }"
			method="post">
			<div class="row">
				<div class="col-md-2 mb-3">
					<strong>성인</strong> <select name="adult" class="custom-select">
						<option value=0 selected>0</option>
						<option value=1>1</option>
						<option value=2>2</option>
						<option value=3>3</option>
						<option value=4>4</option>
						<option value=5>5</option>
						<option value=6>6</option>
						<option value=7>7</option>
						<option value=8>8</option>
						<option value=9>9</option>
						<option value=10>10</option>
					</select>
				</div>
				<div class="col-md-2 mb-3">
					<strong>청소년</strong> <select name="teenager" class="custom-select">
						<option value=0 selected>0</option>
						<option value=1>1</option>
						<option value=2>2</option>
						<option value=3>3</option>
						<option value=4>4</option>
						<option value=5>5</option>
						<option value=6>6</option>
						<option value=7>7</option>
						<option value=8>8</option>
						<option value=9>9</option>
						<option value=10>10</option>
					</select>
				</div>
				<div class="col-md-2 mb-3">
					<strong>우대</strong> <select name="benefit" class="custom-select">
						<option value=0 selected>0</option>
						<option value=1>1</option>
						<option value=2>2</option>
						<option value=3>3</option>
						<option value=4>4</option>
						<option value=5>5</option>
						<option value=6>6</option>
						<option value=7>7</option>
						<option value=8>8</option>
						<option value=9>9</option>
						<option value=10>10</option>
					</select>
				</div>
			</div>
			<table class="table table-striped">
				<thead>
					<tr class="bg-success">
						<th></th>
						<th></th>
						<th>S</th>
						<th></th>
						<th>C</th>
						<th></th>
						<th>R</th>
						<th></th>
						<th>E</th>
						<th></th>
						<th>E</th>
						<th></th>
						<th>N</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0" end="${seatsCount-15 }" step="15">
						<tr>
							<c:forEach var="j" begin="1" end="15" step="1">
								<td><c:set var="loop_flag" value="false" /> <c:forEach
										var="remainSeatNumber" items="${remainSeatNumbers }">
										<c:if test="${not loop_flag }">
											<c:if test="${remainSeatNumber == (i+j)}">
												<input type="checkbox" id="${i+j }" name="seatNumber"
													value="${i+j }" />${i+j }
													<c:set var="loop_flag" value="true" />
											</c:if>
										</c:if>
									</c:forEach></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<button class="btn btn-primary btn-lg btn-block" type="submit">결제
				정보 입력</button>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token}" />
		</form>
		<br>
	</div>
</div>