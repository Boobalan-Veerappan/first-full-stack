<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.heraizen.DTO.BookList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Order Items</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
  <form action="cartBook">
  <div class=" navbar-collapse" id="navbarText">
    <ul class="d-flex ml-auto">
      <span class="nav-item">${username}</span>
      <span class="nav-item"><a type="sumbit" onclick="location.href = './cartBook';"  class="nav-link"><i class="fa fa-cart-plus" aria-hidden="true"></i> Craft</a></span>
      <span class="nav-item"><a onclick="location.href = './index.html';" class="nav-link"><i class="fa fa-sign-out"></i> LogOut</a></span>
    </ul>
    
  </div>
  </form>
</nav>
	<div class="text-center">
		<h3>
			Your Order Book is <b>"${book.getSubtitle()}"</b>
		</h3>
		<br> <img width="500" height="500" alt=""
			src="${book.getImage()}" />
	</div>
	<div class>
		<div class="row">
			<div class="col-md-1 offset-md-5">
				<span class="font-weight-bold">Title</span> <span
					class="float-right"> : </span>
			</div>
			<div class="col-md-6">${book.getTitle()}</div>
			<div class="col-md-1 offset-md-5">

				<span class="font-weight-bold">SubTitle</span> <span
					class="float-right"> : </span>
			</div>
			<div class="col-md-6">${book.getSubtitle()}</div>
			<div class="col-md-1 offset-md-5">
				<span class="font-weight-bold">Author</span>
				<div class="float-right">:</div>
			</div>
			<div class="col-md-6">${book.getAuthor()}</div>
			<div class="col-md-1 offset-md-5">

				<span class="font-weight-bold">Pages</span> <span
					class="float-right"> : </span>
			</div>

			<div class="col-md-6">${book.getPages()}</div>
			<div class="col-md-1 offset-md-5">

				<span class="font-weight-bold">Description</span> <span
					class="float-right"> : </span>
			</div>

			<div class="col-md-6">${book.getDescription()}</div>
		</div>

	</div> 
<div class="text-center">
<form action="cartBook">

<button type="submit" class="btn btn-primary" name="cartbook" action="login" value="${book.getid()}"  >
Confirm
</button>
</form>
<button type="button" class="btn btn-dark" onclick="location.href = './index.html';" >logout</button>
</div>

</body>
</html>