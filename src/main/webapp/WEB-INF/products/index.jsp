<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products Index</title>
</head>
<body>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Qty</th>
	            <th>Price</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${products}" var="product">
		        <tr>
		            <td><c:out value="${product.title}"/></td>
		            <td><c:out value="${product.description}"/></td>
		            <td><c:out value="${product.qty}"/></td>
		            <td><c:out value="${product.price}"/></td>
		            <td>
		            	<a href="products/${product.id}">Details</a>
		            	<a href="products/${product.id}/edit">Edit</a>
		            	<a href="products/${product.id}/delete">Delete</a>
		            </td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>