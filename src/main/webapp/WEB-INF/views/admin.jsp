<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Administrator Page</h2>		
	</div>


	<div class="container">
		<h2>
			<a href="<c:url value="/admin/movieInventory"/>"> Movie Inventory</a>
		</h2>
	</div>

	<div class="container">
		<h2>
			<a href="<c:url value="/admin/userInventory"/>"> User Inventory</a>
		</h2>
	</div>

	<div class="container">
		<h2>
			<a href="<c:url value="/admin/cinemaInventory"/>">Cinema
				Inventory</a>
		</h2>
	</div>

</div>