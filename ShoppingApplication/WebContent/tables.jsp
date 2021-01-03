<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@page import="java.util.List"%>
<%@page import="com.heraizen.DTO.BookList"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page import=" com.mongodb.client.AggregateIterable" %>
        <%@ page  import=" com.mongodb.client.AggregateIterable" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "icon" href =  
"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRay0SfdAYA00zHxcHegaJME8l_83R5k1u4vQ&usqp=CAU" 
        type = "image/x-icon"> 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>List of Books</title>
</head>
<body>
<div class="text-center">
<h3>Table Book List</h3>
</div>
<br/>

<form action="cart" class="container" >
<div class="row justify-content-center">
<table width=500 class="table" >
<thead class="thead-dark">
				<tr>

					<th>Name</th>
					<th>Author</th>
					<th> Publisher </th>
					<th>Add To Cart</th>
					
				</tr>
				</thead>
				<tbody>
				<c:forEach var="book" items="${tables}">
					<tr>

						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>
						<td ><c:out value="${book.publisher}" /> </td>
						<td>
						<button type="submit" name="submit" value="${book.title}"  action="cart" > <i class="fa fa-cart-plus" aria-hidden="true"></i>
							cart
							</button>
							</td>
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			
</form>
<script type="text/javascript">


</script>
</body>
</html>