<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products Show</title>
</head>
<body>
	<h1>products > show.jsp</h1>
	<p><c:out value="${product.title}"/></p>
	<p><c:out value="${product.description}"/></p>
	<p><c:out value="${product.qty}"/></p>
	<p><c:out value="${product.price}"/></p>
</body>
</html>