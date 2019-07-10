<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>댓글 생성하기</h1>
		${movieName }
		<p class="lead">댓글 생성하기</p>	
		<sf:form action="${pageContext.request.contextPath}/viewMovie/reply?${_csrf.parameterName}=${_csrf.token}&movieName=${movieName }"
				method="post" modelAttribute="movieReply"  enctype="multipart/form-data">
				
										
				<div class="form-group">
					<label for="comments"><strong>댓글</strong></label>
					<sf:textarea path="comments" id="comments" class="form-control"/>
					<sf:errors path="comments" cssStyle="color:#ff0000;" />					
				</div>
				
				
				<div class="form-group">
					<label for="rate">평점</label>
					<sf:input path="rate" id="rate" class="form-control" />
				</div>
				  						
				 <%-- <sf:hidden path="movie" value="${movie}" /> --%>

						
				<input type="submit" value="submit" class="btn btn-default">   
			</sf:form>
		<br>
	</div>
</div>	
	
	