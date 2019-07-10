<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="container-wrapper">
	<div class="container">
		<h2> ${movie.movieName }</h2>
				
		<div class="row" >
			<div class="col-md-6">
				<img src="<c:url value="/resources/images/${movie.imagePath }" />" alt="image" style="width:80%" />
			</div>
			
			<div class="col-md-6">				
				<p> <strong>장르: </strong> ${movie.genre }</p>
				<p> <strong>감독: </strong> ${movie.director }</p>
				<p> <strong>출연진: </strong> ${movie.actor }</p>
				<p> <strong>개봉일: </strong> ${movie.releaseDate }</p>
				<p> <strong>평점: </strong> ${movie.viewingRate }</p>
				<p> <strong>줄거리: </strong> ${movie.summary }</p>												
			</div>
			
			<sf:form action="${pageContext.request.contextPath}/admin/movieInventory/addMovie?${_csrf.parameterName}=${_csrf.token}"
				method="post" modelAttribute="movie" enctype="multipart/form-data">
				
				<sf:hidden path="viewingRate" value="0" />
			
				<div class="form-group">
					<label for="summary">댓글</label>
					<sf:textarea path="summary" id="summary" class="form-control"/>
					
				</div>
				
			</sf:form>
		</div>	
	</div>	
</div>
		