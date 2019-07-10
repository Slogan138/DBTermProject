<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>사용자 목록 관리</h2>
		<p>사용자 목록 현황</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-primary text-white">					
					<th>아이디</th>					
					<th>패스워드</th>
					<th>이메일</th>								
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="user" items="${usersList}">
					<tr>					
						<td>${user.username}</td>						
						<td>${user.password}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
</div>
