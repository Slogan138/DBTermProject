<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">

		<h1>회원가입</h1>
		<p class="lead">한성 시네마 회원가입 절차입니다</p>

		<sf:form action="${pageContext.request.contextPath }/register"
			method="post" modelAttribute="user">
			

			<div class="form-group">
				<label for="username" style="font-weight:bold">아이디</label>
				<span style="color:#ff0000">${usernameMsg}</span>
				<sf:input path="username" id="username" class="form-control" />
				<sf:errors path="username" cssStyle="color: #ff0000" />
			</div>

			<div class="form-group">
				<label for="password" style="font-weight:bold">패스워드</label>
				<sf:password path="password" id="password" class="form-control" />
				<sf:errors path="password" cssStyle="color:#ff0000" />
			</div>

			<div class="form-group">
				<label for="email" style="font-weight:bold">이메일 주소</label><span style="color: #ff0000">${emailMsg}</span>
				<sf:input path="email" id="email" class="form-control" />
				<sf:errors path="email" cssStyle="color:#ff0000" />
			</div>
			
			<br>
				
			
			<input type="submit" value="제출" class="btn btn-info">
			
			<a href="<c:url value="/" /> " class="btn btn-danger">취소</a>

		</sf:form>
		<br>
	</div>
</div>