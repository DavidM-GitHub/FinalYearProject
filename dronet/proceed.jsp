<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
<script >
    

    </script>
	<link href="http://localhost:8080/dronet/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body >
<div class="body">
    <h1 class="title">Dronet</h1>
		
		
		<h2>Login</h2>
		<form action= "http://localhost:8080/dronet/restful-services/sampleservice/logincustomer" method="GET" > 
        		<p>Email: <input style="margin-left:7.1em" id="email" placeholder="davidm@gmail.com" type="text" name="email" /></p>
				<p>Password: 	<input style="margin-left:5em" id="password" placeholder="password123" type="text" name="password" /> </p></br>
        <input class="button" type="submit" value="Login" onclick="store()"/>
    </form></br>
	
	<h2>Not Registered? Sign Up Here</h2></br>
		<form action= "http://localhost:8080/dronet/restful-services/sampleservice/registration" method="GET"> 
	<input class="button" type="submit" value="Sign Up" onclick="registration()">
	    </form></br>

	
	
	
	
	</div>
</body>
</html>