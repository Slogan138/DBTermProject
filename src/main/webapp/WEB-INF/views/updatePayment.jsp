<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<h2>
					관람료 : ${payment.fee }<br> 결제 방법 : ${payment.paymentType } 결제가
					완료되었습니다.
				</h2>
			</div>
		</section>
	</div>

	<div class="container">
		<p>
			<a href="<c:url value="/" />"> Hansung Cinema Homepage</a>
		</p>
	</div>
</div>