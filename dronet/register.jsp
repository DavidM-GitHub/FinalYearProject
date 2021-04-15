<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="http://localhost:8080/dronet/signin.css" rel="stylesheet">
</head>
<body id="registration" class="text-center">
    
	 

	
	
	<main class="form-signin">
	<h1 class="h3 mb-3 fw-normal">Register Here</h1>
<form action= "http://localhost:8080/dronet/restful-services/sampleservice/registercustomer" method="GET"> 
<label for="inputName" class="visually-hidden">Name</label>
    <input type="name" id="name" class="form-control" placeholder="Full Name" name="name" required autofocus>
 <label for="inputEmail" class="visually-hidden">Email address</label>
    <input type="email" id="email" class="form-control" placeholder="Email address" name="email" required autofocus>
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input type="password" id="password" class="form-control" placeholder="Password" name="password" required>
	<label for="inputAdmin" class="visually-hidden">Admin</label>
    <input type="text" id="admin" class="form-control" placeholder="Admin? yes/no" name="admin" required>
		 <button class="w-100 btn btn-lg btn-primary button" type="submit">Register</button>
		</form>
		
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

</body>
</html>