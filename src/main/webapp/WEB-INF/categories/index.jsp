<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Categories Index</title>
</head>
<body>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${categories}" var="category">
		        <tr>
		            <td><c:out value="${category.name}"/></td>
		            <td>
		            	<a href="categories/${category.id}">Details</a>
		            	<a href="categories/${category.id}/edit">Edit</a>
		            	<a href="categories/${category.id}/delete">Delete</a>
		            </td>
		        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</body>
</html>