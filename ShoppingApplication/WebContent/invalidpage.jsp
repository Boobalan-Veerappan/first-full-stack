<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="text-center">
<h3 class="text-danger"> 
Sorry Invalid UserName and Password
</h3>
<div class="justify-content-center d-flex">
<div style="width:500px;height:300px;background-image: linear-gradient(to bottom right, tomato, gold);" class="justify-content-center d-flex flex-column">
<form action="login" class="px-3" method="Get">

 <label for="UserName" class="d-block float-left"><b>Username</b></label>
      <input type="text" class="w-100" placeholder="Enter Username" name="UserName" required>

      <label for="password" class="d-block float-left"><b>Password</b></label>
      <input type="password" class="w-100" placeholder="Enter Password" name="password" required>
      <div class="text-center">
<button type="submit" class="btn btn-primary mt-3">login</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>