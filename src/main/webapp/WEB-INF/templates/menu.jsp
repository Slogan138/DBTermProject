<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>

	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"
		id="navBack">
		<a href="<c:url value="/"/>"
			class="navbar-brand d-flex align-items-center"> <i
			class="fas fa-film"></i> &nbsp; <strong>Hansung Cinema</strong>
		</a>

		<div class="collapse navbar-collapse" id="">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item"><a class="nav-link" id="navItem"
					href="<c:url value="/movies"/>">영화</a></li>

				<c:if test="${pageContext.request.userPrincipal.name != null }">
					<c:if test="${pageContext.request.userPrincipal.name == 'admin' }">
						<li class="nav-item"><a class="nav-link" id="navItem"
							href="<c:url value="/admin"/>">관리 페이지</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name != null }">
						<li class="nav-item"><a class="nav-link" id="navItem"
							href="<c:url value="/checkMyPayment"/>">예매내역</a>
					</c:if>
					<li class="nav-item"><a class="nav-link" id="navItem"
						href="javascript:document.getElementById('logout').submit()">로그아웃</a>
					</li>

					<form id="logout" action="<c:url value="/logout" />" method="post">
						<input type="hidden" name="${_csrf.parameterName }"
							value="${_csrf.token }" />
					</form>

				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name==null }">
					<li class="nav-item"><a class="nav-link" id="navItem"
						href="<c:url value="/login"/>">로그인</a></li>
					<li class="nav-item"><a class="nav-link" id="navItem"
						href="<c:url value="/register"/>">회원가입</a></li>
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
