<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products Edit</title>
</head>
<body>
	<h1>products > edit.jsp</h1>
	<form:form action="/products/${product.id}/update" method="post" modelAttribute="product">
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input type="text" path="title"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
	    </p>
	    <p>
	        <form:label path="qty">Qty</form:label>
	        <form:errors path="qty"/>
	        <form:input type="number" path="qty"/>
	    </p>
	    <p>
	        <form:label path="price">Price</form:label>
	        <form:errors path="price"/>     
	        <form:input type="number" path="price"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>