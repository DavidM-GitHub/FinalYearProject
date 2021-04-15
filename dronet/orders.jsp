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
	
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 id="heading" class="h2">Products</h1>
        
      </div>
	
	<div class="card-body">
	<!--	<table class="my-table table table-dark table-striped">-->
	<table class="my-table table-striped table table-hover align-middle">
	<thead class="table-dark">
		<tr>
			<th >Order Number</th>
			<th>Product</th>
			<th>Total</th>
			<th>Delivery Address</th>
			<th>Order Status</th>
		</tr>
		</thead>
		<tr>
			<th id="myText1" name="myText1" type="text" scope="row">18</th>
			<td><img src="https://m.media-amazon.com/images/I/315ZRpnHLtL.jpg" height="200" width="200"/></td>
			<td>Welonox Melatonin</td>
			<td>25</td>
			
</td>
		</tr>
		<tr>
			<th id="myText2" scope="row">19</th>
			<td><img src="https://www.jeancoutu.com/catalog-images/180166/en/viewer/0/aspirin-aspirin-daily-low-dose-tablets-81-mg-120-units.png" height="200" width="200"/></td>
			<td>Aspirin</td>
			<td>45</td>
			
		</tr>
		<tr>
			<th id="myText3" scope="row">20</th>
			<td><img src="https://onlinedoctor.lloydspharmacy.com/image/107782/16x9/400/225/51cab9c66cf898faa3bed10488646683/mC/ventolin---picture.jpg" height="200" width="200"/></td>
			<td>Ventolin Inhalor</td>
			<td>25</td>
			
		</tr>
		<tr>
			<th id="myText4" scope="row">21</th>
			<td><img src="https://www.medicine-online.org/4462-large_default/solpadeine-24-tablets-.jpg" height="200" width="200"/></td>
			<td>Solpadeine</td>
			<td>15</td>
		
		</tr>
	</table>
	
	</div>
	

</main>
</div>
</div>


	
	</div>
</body>
</html>