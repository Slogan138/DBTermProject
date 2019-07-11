<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="container-wrapper">
	<div class="container">
		<h1>영화 평가하기</h1>

		<sf:form
			action="${pageContext.request.contextPath}/viewMovie/reply?${_csrf.parameterName}=${_csrf.token}&movieName=${movieName }"
			method="post" modelAttribute="movieReply"
			enctype="multipart/form-data">


			<div class="form-group">
				<label for="comments" style="font-weight:bold">평가</label>
				<sf:textarea path="comments" id="comments" class="form-control" />
				<sf:errors path="comments" cssStyle="color:#ff0000;" />
			</div>


			<div class="form-group">
				<label for="rate" style="font-weight:bold">평점</label>
				<sf:input type="number" min="0" max="10" path="rate" id="rate"
					class="form-control" />
			</div>
			
			<input type="submit" value="제출" class="btn btn-info">
		</sf:form>
		<br>
	</div>
</div>

