<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Show</title>
</head>
<body>
	<h1>Category > show.jsp</h1>
	<p><c:out value="${category.name}"/></p>
	
	<h5>Products IN the category: <c:out value="${category.name}"/></h5>
	<c:forEach items="${category.products}" var="product">
		<c:out value="${product.title}" /> <a href="/categories/${category.id}/product/${product.id}/remove"><button>Remove</button></a>
	</c:forEach>
	<hr/>
	
	<h5>Products NOT in the category: <c:out value="${category.name}"/></h5>
	<c:forEach items="${products}" var="product">
		<c:out value="${product.title}" /> <a href="/categories/${category.id}/product/${product.id}/add"><button>Add</button></a>
	</c:forEach>
</body>
</html>