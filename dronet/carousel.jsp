<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Homepage</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/">
    
<!--<script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>-->
    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

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
    <link href="http://localhost:8080/dronet/carousel.css" rel="stylesheet">
  <!--  <link href="http://localhost:8080/dronet/dashboard.css" rel="stylesheet"> -->

  </head>
  <body>
    
<header >
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="carousel">Dronet</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="carousel">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="myprofile">My Profile</a>
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
<div class="container-fluid">
  <div class="row">
<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="dashboard">
              <span data-feather="home"></span>
              Data Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="orders">
              <span data-feather="file"></span>
              My Orders
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="browseProducts">
              <span data-feather="shopping-cart"></span>
              Browse Products
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="changeLocation">
              <span data-feather="users"></span>
              Change Address
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ordermaps">
              <span data-feather="bar-chart-2"></span>
              Waypoint Map
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Quick Navigation</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/dronet/restful-services/sampleservice/carousel#equipment">
              <span data-feather="file-text"></span>
              Equipment & Technologies
            </a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/dronet/restful-services/sampleservice/carousel#innovation">
              <span data-feather="file-text"></span>
              Innovation
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/dronet/restful-services/sampleservice/carousel#beginnings">
              <span data-feather="file-text"></span>
              New Beginnings
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="http://localhost:8080/dronet/restful-services/sampleservice/carousel#delivery">
              <span data-feather="file-text"></span>
              Delivery Process
            </a>
          </li>
        </ul>
      </div>
    </nav>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

  <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
		<img src="https://sky-viper.com/wp-content/uploads/2018/08/4-1280x427.png" alt="skyviper" width="100%" height="100%"></svg>

        <div class="container">
          <div class="carousel-caption text-right">
            <h1>Drone Delivery As a Service.</h1>
            <p>Order today and get your product by the end of the day! <a class="btn btn-dark btn-lg btn-primary" href="browseProducts">Order Now</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
				<img src="https://www.outstandingdrone.com/wp-content/uploads/2018/03/air-aircraft-aviate-388846.jpg" alt="skyviper" width="100%" height="100%"></svg>

        <div class="container">
          <div class="carousel-caption" id="caption2">
            <h1>Fast and Efficient.</h1>
            <p>Drone Missions last no longer than 10 minutes from the time it takes off until the time it returns to us. <a class="btn btn-dark btn-lg btn-primary" href="dashboard">Learn more</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false">
						<img src="http://roadsafegis.com/wp-content/uploads/2015/01/map-525349_1280.png" alt="skyviper" width="100%" height="100%"></svg>

        <div class="container">
          <div class="carousel-caption text-end" id="caption3">
            <h1>Need to change your Location?</h1>
            <p>We deliver everywhere just enter your gps co-ordinates and press submit <a class="btn btn-lg btn-dark btn-primary" href="changeLocation">Browse gallery</a></p>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row" id="equipment">
      <div class="col-lg-4" >     
		<img src="https://a248.e.akamai.net/f/248/9086/10h/origin-d5.scene7.com/is/image/bluestembrands/4NN5QC0000010_VA_999" alt="skyviper" width="50%" height="50%">
        <h2>Our Drone</h2>
        <p>The drone we use to make the deliveries is the SkyViper Journey. It is lightweight, durable and has built-in GPS which allows us to send it to precise co-ordinates</p>
        <p><a class="btn btn-secondary" href="https://www.amazon.com/dp/B07G1RJNN9/ref=dp_prsubs_2?currency=EUR&language=en_US">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
	  
      <div class="col-lg-4">        
		<img src="https://www.filepicker.io/api/file/2OcMXUjTPmcyby9OPaxc" alt="skyviper" width="70%" height="50%">
        <h2>How is it done?</h2>
        <p>With the use of a Dronekit Python Web API we send MAVLink messages to the drone telling it to fly to your GPS co-ordinates</p>
        <p><a class="btn btn-secondary" href="https://dronekit-python.readthedocs.io/en/latest/">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
	  
      <div class="col-lg-4">
      		<img src="https://sites.google.com/site/npaecopterguide/_/rsrc/1467137205307/source-codes/mission-planner-source-code/mavlink.jpg" alt="MAVLink" width="100%" height="50%">
		<h2>What's MAVLink?</h2>
        <p>MAVLink is a messaging protocol used for communicating with drones by sending different commands to the drone telling it what to do.</p>
        <p><a class="btn btn-secondary" href="https://mavlink.io/en/">View details &raquo;</a></p>
      </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette" id="innovation">
      <div class="col-md-7">
        <h2 class="featurette-heading">Innovation. <span class="text-muted">Forward Thinking.</span></h2>
        <p class="lead">Here at Dronet we are expanding our horizons and looking at innovative ways to deliver pharmaceutical drugs to those in need.</p>
      </div>
      <div class="col-md-5">
		<title>Pharmaceutical Drugs</title>
		      <img src="https://www.openaccessgovernment.org/wp-content/uploads/2020/10/drugsssssssssssssss.jpg" alt="MAVLink" width="100%" height="100%">


      </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette" id="beginnings">
      <div class="col-md-7 order-md-2">
        <h2 class="featurette-heading">How we came about. <span class="text-muted">New beginings. </span></h2>
        <p class="lead">Inspired by the current climate where people are limited to their homes as the Corona Virus pandemic has caused havoc accross the world. Dronet came about with the simple but innovative idea to provide Drone As A Service to those in need of medical suplies that cant leave their home as they are elderly, struggle with mobility or even because they are in quarantine</p>
      </div>
      <div class="col-md-5 order-md-1">
	  </br>
		<img src="https://media.istockphoto.com/photos/drone-delivering-first-aid-box-advancing-medical-industry-logistics-picture-id1172364265?k=6&m=1172364265&s=612x612&w=0&h=ax2BJoe6UzlfOlcQgSviTigsBVHKyxGuUKGcVrtz8zY=" alt="Medical Supplies" width="100%" height="85%">

      </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette" id="delivery">
      <div class="col-md-7">
        <h2 class="featurette-heading">How it works. <span class="text-muted">Delivery Process.</span></h2>
        <p class="lead">The Drone will takeoff and head towards you, it will land at your location for a number of seconds so you can take your product before taking off to the next location or returning to us.</p>
      </div>
      <div class="col-md-5">
	  		<title>Pharmaceutical Drugs</title>
		<img src="https://internetofbusiness.com/wp-content/uploads/2018/08/flytrex.png" alt="Delivery Process" width="100%" height="100%">
      </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


  <!-- FOOTER -->
  <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2017–2021 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer>
</main>
</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

      
  </body>
</html>
