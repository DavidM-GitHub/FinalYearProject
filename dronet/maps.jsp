<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Update GPS Co-Ordinates</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>

	<script>
      // Initialize and add the map
      function initMap() {
		  var locations = [   
		   		["hq",53.502956, -6.450588]
		,["42",53.503247, -6.451038]
		,["43",53.503310, -6.450093]
		,["48",53.502956, -6.450588]
    ]; 
        // The location of Uluru
        const uluru = { lat: 53.5032596, lng: -6.4508143 };
        // The map, centered at Uluru
        const map = new google.maps.Map(document.getElementById("map"), {
          zoom: 15,
          center: new google.maps.LatLng(locations[0][1], locations[0][2]),
        });
		var infowindow = new google.maps.InfoWindow();
		var marker,i;
        for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });
	  google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent("Customer ID: "+locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
		}
      }
    </script>
    <!-- Custom styles for this template -->
    <link href="http://localhost:8080/dronet/maps.css" rel="stylesheet">
  </head>
  <body >
    <header >
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 " href="#">Dronet</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="carousel">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">My Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
        </ul>
        <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="index">Sign out</a>
    </li>
  </ul>
      </div>
    </div>
  </nav>
</header>
    <div id="map"></div>
	<div id="mapheader">
        <h1 id="heading" class="h2 "><u>Delivery Locations</u></h1>
</div>
<script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCaRGxXQ8eIkhPlnUojB42dQbgEQSprSBA&callback=initMap&libraries=&v=weekly"
      async
    ></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

  </body>
</html>
