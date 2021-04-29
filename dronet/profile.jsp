<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://js.stripe.com/v3/">
	
	</script>

    <link href="http://localhost:8080/dronet/carousel.css" rel="stylesheet">

</head>
<body >
<div class="body">
    
	 
<header >
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Dronet</a>
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
      <a class="nav-link" href="#">Sign out</a>
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
            <a class="nav-link" href="#">
              <span data-feather="file"></span>
              Orders
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="browseProducts">
              <span data-feather="shopping-cart"></span>
              Products
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="changeLocation">
              <span data-feather="users"></span>
              My Details
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Waypoint Map
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="layers"></span>
              Integrations
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
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Current month
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Last quarter
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Social engagement
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              Year-end sale
            </a>
          </li>
        </ul>
      </div>
    </nav>
	
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" >

	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 id="heading" class="h2">My Details</h1>
        
      </div>
	  <div id="heading">
	  <h3>Name</h3>
	  <p>David Murphy</p>
	  </br>
	  <h3>Email</h3>
	  <p>dave@g.c</p>
	  </br>
	  <h3>Current Address</h3>
	  <p class="col-4">Meadowbank Hill Meadowbank Hill Meadowbank Hill Meadowbank Hill</p>
	   <form action= "http://localhost:8080/dronet/restful-services/sampleservice/changeLocation" method="GET">
	<div class="d-grid gap-2 col-2 mx-auto">
	<input class="w-25 btn btn-dark btn-lg" type="submit" value="Update Address" id="addressbutton"/>
	</div>
		  </form>
		  
		
	  
	  <form action= "http://localhost:8080/dronet/restful-services/sampleservice/changeName" method="GET" id="nameform"  >	 
    <h3>Change Name</h3>
    <label for="inputPassword" class="visually-hidden">Name</label>
    <input type="text" id="name" class="updatebutton" placeholder="Name" name="name" required>
    <button class="w-20 btn btn-dark btn-primary button mb-1" type="submit">Update Name</button>
	  </form>
	  
	  
	  
	  
	  
	  
	  <form action= "http://localhost:8080/dronet/restful-services/sampleservice/changeEmail" method="GET" id="emailform">
	      <h3>Change Email</h3>
    <label for="inputPassword" class="visually-hidden">Email</label>
    <input type="text" id="email" class="updatebutton" placeholder="Email" name="email" required>
    <button class="w-20 btn btn-dark btn-primary button mb-1" type="submit">Update Email</button>
	  </form>
	  
	  <form action= "http://localhost:8080/dronet/restful-services/sampleservice/changePassword" method="GET">
	  	      <h3>Change Password</h3>
			  <p>Enter current password followed by a new one to change password</p>
    <label for="inputPassword" class="visually-hidden">Current Password</label>
    <input type="text" id="currentPassword" class="updatebutton" placeholder="Current Password" name="currentPassword" required>
	<label for="inputPassword" class="visually-hidden">New Password</label>
    <input type="text" id="newPassword" class="updatebutton" placeholder="New Password" name="newPassword" required>
    <button class="w-50 btn btn-dark btn-primary button mb-1" type="submit">Update Password</button>
	  </form>
	  
	  
	<h3>Order History</h3>
	<div class="card-body col-11" id="ordertable">
	<!--	<table class="my-table table table-dark table-striped">-->
	<table  class="my-table table-striped table table-hover " >
	<thead class="table-dark">
		<tr>
			<th >Total Orders Placed</th>
			<th>Recieved</th>
			<th>Pending</th>
		</tr>
		</thead>
		<tr>
			<th id="myText1" name="myText1" type="text" scope="row">18</th>
			<td>5</td>
			<td>Welonox Melatonin</td>			
</td>
		</tr>
		
	</table>
		  <form action= "http://localhost:8080/dronet/restful-services/sampleservice/orders" method="GET">
	<div class="d-grid gap-2 col-12 mx-auto">
	<input class="btn btn-dark btn-lg" type="submit" value="View Orders" id="viewOrders"/>
	</div>
		  </form>


	</div>
		
</div>

</main>
</div>
</div>


	
	</div>
</body>
</html>