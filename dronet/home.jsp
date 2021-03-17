

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
<script>

window.onload = function getEmail() {
	//var email = session.getAttribute("user");
	//var email='<%=Session("user")%>';
	var email = localStorage.getItem("email");
	console.log(email);
	document.getElementById("username").innerHTML = email +" logged in"; 
	// (EXTRA) TO CLEAR
  // localStorage.removeItem("KEY");
  //find in preferences - advanced - storage
}
  //	<link href="style.css" rel="stylesheet" type="text/css"> below script
</script>
	<link href="http://localhost:8080/dronet/styles.css" rel="stylesheet" type="text/css"/>

</head>
<body >
<div >
    
	 
	 <ul>
  <li><a href="carousel" >Home</a></li>
  <li><a href="products">Browse Products</a></li>
  <li><a href="changeLocation">Change Location</a></li>
  <li><a href="dashboard">Data</a></li>
    <li><a href="carousel">Log Out</a></li>
<li style="float:right;"><a style="color:#FF4D00;" id="username">Dronet</a></li>
</ul>
	 
	<h1>Welcome</h1>
	
	
	<p >Here at Dronet we are expanding our horizons and looking at innovative ways to deliver pharmaceutical drugs to those in need.</p>

		
		
		<h2>Make an order today and we will deliver your product by the end of the day!</h2>
		
			<h1>About Us</h1>
			<p style="text-align:centre;">Inspired by the current climate where people are limited to their homes as the Corona Virus pandemic has caused havoc accross the world. Dronet came about with the simple but innovative idea to provide Drone As A Service to those in need of medical suplies but cant leave their home as they are elderly, struggle with mobility or even because they are in quarantine.</p>

<p style="text-align:centre;">We use autonomous Drone Missions to deliver the product you select to your location in mere minutes. With the use of a Dronekit Python Web API which sends MAVLink messages to the drone telling it to fly to your GPS co-ordinates. It will land at your location for a number of seconds so you can take your product before taking off to the next location or returning to us.Just tick the checkbox next to your product on the products page, make the purchase and we will deliver the product to your door by the end of the day!</p>



	
	</div>
</body>
</html>