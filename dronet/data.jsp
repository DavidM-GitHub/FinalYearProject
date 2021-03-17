<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
	<link href="http://localhost:8080/dronet/styles.css" rel="stylesheet" type="text/css"/>
	
<script>
function makeGraph(container)
{
    container = document.getElementById(container);
    //labels = document.getElementById(labels)
    var dnl = container.getElementsByTagName("li");
	//var stats=["mean","median","min","max"]
    for(var i = 0; i < dnl.length; i++)
    {
        var item = dnl.item(i);
		//var label=document.getElementById(stats[i]);
        var value = item.innerHTML;
        var color = item.style.background=color;
        var content = value.split(":");
        value = content[0];
        item.style.height=value + "px";
        item.style.top=(199 - value) + "px";
        item.style.left = (i * 120 + 20) + "px";
		console.log((i * 120 + 20) + "px")
		//label.style.left=(i * 120 + 20) + "px";
        item.style.height = value + "px";
        item.innerHTML = value;
        item.style.visibility="visible";	
        item.style.background="#FF4D00";
        //labels.innerHTML = labels.innerHTML +
          //   "<span style='margin:10px;background:"+ color+"'>" + 
            // content[1] + "</span>";
		//document.getElementById("mean").innerHTML ="Mean" 
    }	
}

window.onload=function () { makeGraph("graph", "labels") }
  //	<link href="style.css" rel="stylesheet" type="text/css"> below script
</script>
</head>
<body >
<ul>
  <li><a href="home" >Home</a></li>
  <li><a href="browseProducts">Browse Products</a></li>
  <li><a href="changeLocation">Change Location</a></li>
  <li><a href="data">About</a></li>
    <li><a href="index">Log Out</a></li>
<li style="float:right;"><a style="color:#FF4D00;" id="username">Dronet</a></li>
</ul>

<div class="body">
    <div id="graph">
	<div style="color:#BEBEBE">
  200<br /> <br /> <br /> 150 <br /> <br /> <br /> 100 <br /> <br /> <br /> 50</div>
  
	 <ul>  
  <li>50:2007</li>
  <li>100:2008</li>
  <li>150:2009</li>
  <li>190:2010</li>
</ul>
</div>
<div class="stats">
<label style="position:fixed;left:412px;color:#BEBEBE">Mean</label>
<label style="position:absolute;left:532px;color:#BEBEBE">Median</label>
<label style="position:absolute;left:650px;color:#BEBEBE">Max</label>
<label style="position:absolute;left:770px;color:#BEBEBE">Min</label>
</div></br></br>


		
		<h2>Please Try Again</h2>
		<form action= "http://localhost:8080/dronet/restful-services/sampleservice/registration" method="GET"> 
	<input class="button" type="submit" value="Sign Up" >
	    </form></br>
	
			

	
	</div>
</body>
</html>