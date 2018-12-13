<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search Product</title>
</head>
<body>
	<h1>Search Product by Name</h1>
	<c:forEach items="${products}" var="product">
		<c:out value="${product.getTitle()}"/>
	</c:forEach>
	<form action="/products/search/" method="get">
		<input type="text" name="title" />
		<input type="submit" />
	</form>
</body>
</html>