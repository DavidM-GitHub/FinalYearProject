<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Dashboard Template · Bootstrap v5.0</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>

    

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
    <link href="http://localhost:8080/dronet/dashboard.css" rel="stylesheet">
  </head>
  <body>

    

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Dronet</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="carousel">Home</a>
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
            <a class="nav-link active" aria-current="page" href="dashboard">
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
            <a class="nav-link" href="ordermaps">
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
        <h1 id="heading" class="h2">Dashboard</h1>
       
      </div>
	  <h2 class="h3" id="flighttime">DroneMission Flight Time</h1>
	  <div class="chart">
	 <canvas id="chart"></canvas>
	 </div>
	 <h2>Flight Time Data</h2>
	 <h5>Average Flight Time: 2 minutes 46 seconds</h5>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Statistic</th>
              <th>Average</th>
              <th>Maximum</th>
              <th>Minimum</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>All Deliveries</td>
              <td>random</td>
              <td>data</td>
              <td>placeholder</td>
            </tr>
			 </tbody>
        </table>
      </div>
	 </br></br>
	 	 <h2 class="h3" id="wflighttime">Flight Time For Missions With Different Waypoints</h1>
<div class="barchart">
	 <canvas id="myChart"></canvas>
	 </div>
	 <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Statistic</th>
              <th>Average</th>
              <th>Maximum</th>
              <th>Minimum</th>
            </tr>
          </thead>
	 </br></br>
	 	 	 <h2 class="h3" id="underover">Flight Time Under/Over/Between 3 and 4 minutes</h1>
	 <div class="piechart">
	 <canvas id="pie"></canvas>
	 </div>
	 </br></br>
	 	 	 <h2 class="h3" id="productsbought">Number of Products Bought</h1>
	 <div class="doughnut">
	 <canvas id="doughnut"></canvas>
	 </div>


      <h2>Flight Time Data</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Statistic</th>
              <th>Average</th>
              <th>Maximum</th>
              <th>Minimum</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>All Deliveries</td>
              <td>random</td>
              <td>data</td>
              <td>placeholder</td>
            </tr>
            <tr>
              <td>Delivery with 1 Waypoint</td>
              <td>placeholder</td>
              <td>irrelevant</td>
              <td>visual</td>
            </tr>
            <tr>
              <td>Delivery with 2 Waypoints</td>
              <td>data</td>
              <td>rich</td>
              <td>dashboard</td>
            </tr>
            <tr>
              <td>Delivery with 3 Waypoints</td>
              <td>information</td>
              <td>placeholder</td>
              <td>illustrative</td>
            </tr>
          </tbody>
        </table>
      </div>
	  
	  <h2>Flight Time Data Under/Over/Between 3 and 4 Minutes</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Statistic</th>
              <th>< 3 Minutes</th>
              <th>> 4 Minutes</th>
              <th>3 > x < 4</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Number of Flights</td>
              <td>random</td>
              <td>data</td>
              <td>placeholder</td>
            </tr>
          </tbody>
        </table>
      </div>
	  
	  <h2>Product Data</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>Statistic</th>
              <th>Melatonin Capsules</th>
              <th>Aspirin</th>
              <th>Ventolin Inhalor</th>
              <th>Solpadeine Capsules</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Products Sold</td>
              <td>3</td>
              <td>3</td>
              <td>3</td>
              <td>6</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<script>
var ctx = document.getElementById('myChart');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],
        datasets: [{
            label: 'Flight Time (1 Waypoint)',
            data: [130, 145, 120],
            backgroundColor: [
                'rgba(255, 77, 0, 1)',
                'rgba(255, 77, 0, 1)',
                'rgba(255, 77, 0, 1)'
                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
				],
            borderWidth: 1
        },{label: 'Flight Time (2 Waypoints)',
            data: [150, 170, 125],
            backgroundColor: [
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(54, 162, 235, 1)'
                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
				],
            borderWidth: 1
        },{label: 'Flight Time (3 Waypoints)',
            data: [200, 220, 175],
            backgroundColor: [
                'rgba(255, 99, 132, 0.95)',
                'rgba(255, 99, 132, 0.95)',
                'rgba(255, 99, 132, 0.95)'
                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
				],
            borderWidth: 1
        }
		]		
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
var ctx = document.getElementById('chart');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],
        datasets: [{
            label: 'Overall Flight Time ',
            data: [2.1, 1.7, 2],
            backgroundColor: [
                'rgba(255, 77, 0, 1)',
                'rgba(255, 77, 0, 1)',
                'rgba(255, 77, 0, 1)'
                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
				],
            borderWidth: 1
        }
		]		
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }],
			x: {
                type: 'time',
                time: {
                    unit: 'minute'
                }
            }
        }
    }
});
var ctx = document.getElementById('pie');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ['Melatonin Capsules', 'Ventolin Inhalor', 'Solpadeine Capsules'],
        datasets: [{
            label: 'Products Bought ',
            data: [130, 120,55],
            backgroundColor: [
                'rgba(0, 255, 0, 0.95)',
                'rgba(255, 0, 0, 1)',
                'rgba(255, 255, 0, 0.95)'                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',      
				'rgba(0, 0, 0, 1)'
			],
            borderWidth: 1
        }
		]		
    },
});
var ctx = document.getElementById('doughnut');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Melatonin Capsules', 'Aspirin', 'Ventolin Inhalor', 'Solpadeine Capsules','zinc','vuaaaa'],
        datasets: [{
            label: 'Products Bought ',
            data: [130, 145, 120,55,55,55],
            backgroundColor: [
                'rgba(0, 255, 0, 0.95)',
                'rgba(255, 0, 255, 1)',
                'rgba(255, 0, 0, 1)',
                'rgba(255, 255, 0, 0.95)',
				'rgba(0, 255, 255, 1)',
                'rgba(122, 122, 255, 0.95)'                    
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',      
				'rgba(0, 0, 0, 1)',
				'rgba(0, 0, 0, 1)',      
				'rgba(0, 0, 0, 1)',
			],
            borderWidth: 1
			//      <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
        }
		]		
    },
});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
  </body>
</html>
