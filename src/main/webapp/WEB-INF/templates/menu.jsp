<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>
<%-- 	<div class="navbar navbar-dark bg-dark shadow-sm">
		<div class="container d-flex justify-content-between">
			<a href="#" class="navbar-brand d-flex align-items-center"> <svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" aria-hidden="true"
					class="mr-2" viewBox="0 0 24 24" focusable="false">
						<path
						d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z" />
						<circle cx="12" cy="13" r="4" /></svg> <strong>Album</strong>
			</a>
		</div>		
	</div> --%>
	
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a href="#" class="navbar-brand d-flex align-items-center"> <svg
					xmlns="http://www.w3.org/2000/svg" width="20" height="20"
					fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" aria-hidden="true"
					class="mr-2" viewBox="0 0 24 24" focusable="false">
						<path
						d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z" />
						<circle cx="12" cy="13" r="4" /></svg> <strong>Hansung Cinema</strong>
			</a>
		
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/"/>">Home <span class="sr-only">(current)</span></a>
				</li>
					
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/movies"/>">Movies</a></li>
																			
				<c:if test="${pageContext.request.userPrincipal.name != null }">
					<c:if test="${pageContext.request.userPrincipal.name == 'admin' }">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>">AdminPage</a></li>
					</c:if>
					
					
					<%-- <li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">Logout</a></li> --%>
					<li class="nav-item"><a class="nav-link" href="javascript:document.getElementById('logout').submit()">Logout</a>
					</li>
					
					<form id="logout" action="<c:url value="/logout" />" method="post">
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					</form>
					
				</c:if>
				 
				<c:if test="${pageContext.request.userPrincipal.name==null }">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/login"/>">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/register"/>">Register</a>
					</li>
				</c:if>
				
			
			</ul>
		
		</div>
	</nav>
</header>

<%-- <header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">Carousel</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value="/"/>">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/products"/>">Products</a></li>
					
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/admin"/>">Admin</a></li>
					
				<c:if test="${pageContext.request.userPrincipal.name != null }">
					<c:if test="${pageContext.request.userPrincipal.name == 'admin' }">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/admin"/>">AdminPage</a></li>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name != 'admin' }">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/cart"/>">Cart</a></li>
					</c:if>
					
					<li class="nav-item"><a class="nav-link" href="<c:url value="/logout"/>">Logout</a></li>
					<li class="nav-item"><a class="nav-link" href="javascript:document.getElementById('logout').submit()">Logout</a>
					</li>
					
					<form id="logout" action="<c:url value="/logout" />" method="post">
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					</form>
					
				</c:if>
				 
				<c:if test="${pageContext.request.userPrincipal.name==null }">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/login"/>">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value="/register"/>">Register</a>
					</li>
				</c:if>
				
			
			</ul>
			<form class="form-inline mt-2 mt-md-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</header> --%>
