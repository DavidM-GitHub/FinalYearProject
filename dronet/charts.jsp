<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REST Example</title>
<div >
    	 <ul>
  <li><a href="home" >Home</a></li>
  <li><a href="browseProducts">Browse Products</a></li>
  <li><a href="changeLocation">Change Location</a></li>
  <li><a href="data">About</a></li>
    <li><a href="index">Log Out</a></li>
<li style="float:right;"><a style="color:#FF4D00;" id="username">Dronet</a></li>
</ul>
    </br></br>
<div class="chart">
	 <canvas id="chart"></canvas>
	 </div>
	 </br></br>
<div class="barchart">
	 <canvas id="myChart"></canvas>
	 </div>
	 </br></br>
	 <div class="piechart">
	 <canvas id="pie"></canvas>
	 </div>
	 </br></br>
	 <div class="doughnut">
	 <canvas id="doughnut"></canvas>
	 </div>
	 
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
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
            borderWidth: 2
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
            borderWidth: 2
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
            borderWidth: 2
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
            borderWidth: 2
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
            borderWidth: 2
        }
		]		
    },
});
var ctx = document.getElementById('doughnut');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Melatonin Capsules', 'Aspirin', 'Ventolin Inhalor', 'Solpadeine Capsules'],
        datasets: [{
            label: 'Products Bought ',
            data: [130, 145, 120,55],
            backgroundColor: [
                'rgba(0, 255, 0, 0.95)',
                'rgba(255, 0, 255, 1)',
                'rgba(255, 0, 0, 1)',
                'rgba(255, 255, 0, 0.95)'                
            ],
            borderColor: [
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',
                'rgba(0, 0, 0, 1)',      
				'rgba(0, 0, 0, 1)',
			],
            borderWidth: 2
        }
		]		
    },
});
</script>
	<link href="http://localhost:8080/dronet/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body >	
</body>
</html>