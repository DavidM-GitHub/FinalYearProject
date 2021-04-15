<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Dronet Sign In</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="http://localhost:8080/dronet/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
  
    
<main class="form-signin">
  <form action= "http://localhost:8080/dronet/restful-services/sampleservice/logincustomer" method="GET">
    <img class="mb-4 image" src="fyplogo.PNG" alt="" width="300" height="160">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <label for="inputEmail" class="visually-hidden">Email address</label>
    <input type="email" id="email" class="form-control" placeholder="Email address" name="email" required autofocus>
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input type="password" id="password" class="form-control" placeholder="Password" name="password" required>
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary button" type="submit">Sign in</button>
	  </form>
			<form action= "http://localhost:8080/dronet/restful-services/sampleservice/registration" method="GET"> 
	<button class="w-100 btn btn-lg btn-primary" type="submit">Register</button>
	</form>
    <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

  </body>
</html>
