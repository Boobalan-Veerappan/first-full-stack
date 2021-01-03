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
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
  <form action="cartBook">
  <div class=" navbar-collapse" id="navbarText">
    <ul class="d-flex ml-auto">
      <span class="nav-item"><a class="nav-link text-white ">Hi ${username}</a></span>
      <span class="nav-item"><a type="sumbit" onclick="location.href = './cartBook';"  class="nav-link"><i class="fa fa-cart-plus" aria-hidden="true"></i> Craft</a></span>
      <span class="nav-item"><a onclick="location.href = './index.html';" class="nav-link"><i class="fa fa-sign-out"></i> LogOut</a></span>
    </ul>
    
  </div>
  </form>
</nav>
<form action="cart" class="container" >
<div class="row justify-content-center mt-3">
<table width=500 class="table" >
<thead class="thead-dark">
				<tr>

					<th>Name</th>
					<th>Author</th>
					<th> Publisher </th>
					<th>Preview</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Total</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="book" items="${cartItem}">
					<tr>

						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>
						<td ><c:out value="${book.publisher}" /> </td>
						<td><img alt="" width="100" height="100" src="${book.getImage()}"></td>
						
						<td><c:out value="${book.getDuplicate()}" /></td>
						<td><c:out value="${book.getPrice()}" /></td>
						<td><c:out value="${book.getDuplicate()*book.getPrice()}" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			</div>
			<div class="float-right"><h4>total:${total}</h4></div>
			
</form>

<a class="btn btn-primary" href="/checkout">CheckOut</a>
<div class="d-flex float-right" style="clear:both;">
<form action="login">
<button  class="btn btn-success" type="submit">Add More ..</button>
</form>&nbsp;
<form action="removeall">
<button type="submit" class="btn btn-primary" >remove all</button>
</form>
</div>
</body>
</html>