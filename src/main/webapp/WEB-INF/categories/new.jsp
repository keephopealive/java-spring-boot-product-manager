<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Categories New</title>
</head>
<body>
	<h1>categories > new.jsp</h1>
	<form:form action="/categories" method="post" modelAttribute="category">
	    <p>
	        <form:label path="name">Title</form:label>
	        <form:errors path="name"/>
	        <form:input type="text" path="name"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>