
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<h3>
					좌석 번호 :
					<c:forEach var="seatNumber" items="${seatNumbers }">${seatNumber } </c:forEach>
					<br> 관람료 : ${fee }<br> 결제 방법 : ${paymentType }<br>
					결제가 완료되었습니다.
				</h3>
			</div>
		</section>
	</div>

	<div class="container">
		<p>			
			<a href="<c:url value="/"/>" class="btn btn-primary">홈으로</a>
		</p>
	</div>
</div>