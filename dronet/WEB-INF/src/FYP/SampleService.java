package FYP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;



@Path("/sampleservice")
public class SampleService {
	
	@Context
    private HttpServletRequest request;
	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	public Map<String,Object> session=new HashMap<String,Object>();
	private static Gson gson = new Gson();
private String indexPage="<!doctype html>\r\n" + 
		"<html lang=\"en\">\r\n" + 
		"  <head>\r\n" + 
		"  <script>\r\n" + 
		"	window.onload = function getEmail() {	\r\n" + 
		"	alert(\"Enter Your Login Details To Sign In Again...\");\r\n" + 
		"}\r\n" + 
		"  </script>\r\n" + 
		"    <meta charset=\"utf-8\">\r\n" + 
		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
		"    <meta name=\"description\" content=\"\">\r\n" + 
		"    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n" + 
		"    <meta name=\"generator\" content=\"Hugo 0.80.0\">\r\n" + 
		"    <title>Signin Template · Bootstrap v5.0</title>\r\n" + 
		"		<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\r\n" + 
		"\r\n" + 
		"    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.0/examples/sign-in/\">\r\n" + 
		"\r\n" + 
		"    \r\n" + 
		"\r\n" + 
		"    <!-- Bootstrap core CSS -->\r\n" + 
		"\r\n" + 
		"    <style>\r\n" + 
		"      .bd-placeholder-img {\r\n" + 
		"        font-size: 1.125rem;\r\n" + 
		"        text-anchor: middle;\r\n" + 
		"        -webkit-user-select: none;\r\n" + 
		"        -moz-user-select: none;\r\n" + 
		"        user-select: none;\r\n" + 
		"      }\r\n" + 
		"\r\n" + 
		"      @media (min-width: 768px) {\r\n" + 
		"        .bd-placeholder-img-lg {\r\n" + 
		"          font-size: 3.5rem;\r\n" + 
		"        }\r\n" + 
		"      }\r\n" + 
		"    </style>\r\n" + 
		"\r\n" + 
		"    \r\n" + 
		"    <!-- Custom styles for this template -->\r\n" + 
		"    <link href=\"http://localhost:8080/dronet/signin.css\" rel=\"stylesheet\">\r\n" + 
		"  </head>\r\n" + 
		"  <body class=\"text-center\">\r\n" + 
		"  \r\n" + 
		"    \r\n" + 
		"<main class=\"form-signin\">\r\n" + 
		"  <form action= \"http://localhost:8080/dronet/restful-services/sampleservice/logincustomer\" method=\"GET\">\r\n" + 
		"    <img class=\"mb-4 image\" src=\"../../fyplogo.PNG\" alt=\"\" width=\"300\" height=\"160\">\r\n" + 
		"    <h1 class=\"h3 mb-3 fw-normal\">Please sign in</h1>\r\n" + 
		"    <label for=\"inputEmail\" class=\"visually-hidden\">Email address</label>\r\n" + 
		"    <input type=\"email\" id=\"email\" class=\"form-control\" placeholder=\"Email address\" name=\"email\" required autofocus>\r\n" + 
		"    <label for=\"inputPassword\" class=\"visually-hidden\">Password</label>\r\n" + 
		"    <input type=\"password\" id=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\" required>\r\n" + 
		"    <div class=\"checkbox mb-3\">\r\n" + 
		"      <label>\r\n" + 
		"        <input type=\"checkbox\" value=\"remember-me\"> Remember me\r\n" + 
		"      </label>\r\n" + 
		"    </div>\r\n" + 
		"    <button class=\"w-100 btn btn-lg btn-primary button\" type=\"submit\">Sign in</button>\r\n" + 
		"	  </form>\r\n" + 
		"			<form action= \"http://localhost:8080/dronet/restful-services/sampleservice/registration\" method=\"GET\"> \r\n" + 
		"	<button class=\"w-100 btn btn-lg btn-primary\" type=\"submit\">Register</button>\r\n" + 
		"	</form>\r\n" + 
		"    <p class=\"mt-5 mb-3 text-muted\">&copy; 2017–2021</p>\r\n" + 
		"</main>\r\n" + 
		"\r\n" + 
		"\r\n" + 
		"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>\r\n" + 
		"\r\n" + 
		"  </body>\r\n" + 
		"</html>";

private String noBackPageScript="<script type = \"text/javascript\" >\r\n" + 
		"   function preventBack(){window.history.forward();}\r\n" + 
		"    setTimeout(\"preventBack()\", 0);\r\n" + 
		"    window.onunload=function(){null};\r\n" + 
		"</script>";
	
	static {
		Customer c1=new Customer("Dave","dave@g.c","p123");
	
		customers.put(Integer.toString(c1.getId()), c1);
        
		Customer c2=new Customer("Mark","mark@d.c","p444");
        customers.put(Integer.toString(c2.getId()), c2);
        
    }

	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World";    
    }
	
	
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }

	
	@GET
    @Path("/customers")
    @Produces("application/xml")
    public List<Customer> listCustomers(){
//        return new ArrayList<Employee>(employees.values());
		DeliveryDAO deldao=new DeliveryDAO();
		return deldao.getAllCustomers();
    }
	
	@GET
    @Path("/customers/json")
    @Produces("application/json")
    public List<Customer> listCustomersJSON(){
//        return new ArrayList<Employee>(employees.values());
		DeliveryDAO deldao=new DeliveryDAO();
		return deldao.getAllCustomers();
    }
	
	@GET
    @Path("/customer/{customerid}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("customerid")String customerid){
		DeliveryDAO deldao=new DeliveryDAO();
		return deldao.getCustomerById(Integer.parseInt(customerid));			
    }
	
	@GET
	@Path("/registercustomer")
	public InputStream registerCustomer(@QueryParam("name") String name,
			@QueryParam("email") String email,
			@QueryParam("password") String password) {
		DeliveryDAO deldao=new DeliveryDAO();
		File f;
		Customer customer=deldao.getCustomerByEmail(email);
		System.out.println("customer email "+customer.getName());
		System.out.println("Email entrered"+name);
		if(customer.getName()!=null) {	
			System.out.println("error");
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\error1.jsp");
			
		}else {
			System.out.println("gps");
			Customer customer1=new Customer(name,email,password);
			deldao.persistCustomer(customer1);
			request.getSession(true);
			HttpSession session = request.getSession();
			session.setAttribute("user",customer1.getEmail());
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\gps.jsp");
		}
		
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		else {
//			return "Login details incorrect... Customer not found";
//		}
		return null;
	}
	
	@GET
	@Path("/changeLocation")
	public InputStream changeLocation() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\gps.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/maps")
	public InputStream maps() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\maps.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/ordermaps")
	public String ordermaps() {
		DeliveryDAO deldao=new DeliveryDAO();
		ArrayList<ProductOrder> orders=(ArrayList<ProductOrder>) deldao.getAllProductOrders();

		String locations="";
		
		for(ProductOrder order:orders) {
			locations+=",[\""+order.getCustomer().getId()+"\","+order.getLongitude()+", "+order.getLatitude()+"]\r\n";
		}
		
		String mapsJsp="<html lang=\"en\">\r\n" + 
				"  <head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"    <meta name=\"description\" content=\"\">\r\n" + 
				"    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n" + 
				"    <meta name=\"generator\" content=\"Hugo 0.80.0\">\r\n" + 
				"    <title>Update GPS Co-Ordinates</title>\r\n" + 
				"		<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.0/examples/sign-in/\">\r\n" + 
				"\r\n" + 
				"    <script type = \"text/javascript\" >\r\n" + 
				"   function preventBack(){window.history.forward();}\r\n" + 
				"    setTimeout(\"preventBack()\", 0);\r\n" + 
				"    window.onunload=function(){null};\r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"	<script>\r\n" + 
				"      // Initialize and add the map\r\n" + 
				"      function initMap() {\r\n" + 
				"		  var locations = [   \r\n" + 
				"		   		[\"hq\",53.502956, -6.450588]\r\n" + 
					locations +
				"    ]; \r\n" + 
				"        // The location of Uluru\r\n" + 
				"        const uluru = { lat: 53.5032596, lng: -6.4508143 };\r\n" + 
				"        // The map, centered at Uluru\r\n" + 
				"        const map = new google.maps.Map(document.getElementById(\"map\"), {\r\n" + 
				"          zoom: 15,\r\n" + 
				"          center: new google.maps.LatLng(locations[0][1], locations[0][2]),\r\n" + 
				"        });\r\n" + 
				"		var infowindow = new google.maps.InfoWindow();\r\n" + 
				"		var marker,i;\r\n" + 
				"        for (i = 0; i < locations.length; i++) {  \r\n" + 
				"      marker = new google.maps.Marker({\r\n" + 
				"        position: new google.maps.LatLng(locations[i][1], locations[i][2]),\r\n" + 
				"        map: map\r\n" + 
				"      });\r\n" + 
				"	  google.maps.event.addListener(marker, 'click', (function(marker, i) {\r\n" + 
				"        return function() {\r\n" + 
				"          infowindow.setContent(\"Customer ID: \"+locations[i][0]);\r\n" + 
				"          infowindow.open(map, marker);\r\n" + 
				"        }\r\n" + 
				"      })(marker, i));\r\n" + 
				"		}\r\n" + 
				"      }\r\n" + 
				"    </script>\r\n" + 
				"    <!-- Custom styles for this template -->\r\n" + 
				"    <link href=\"http://localhost:8080/dronet/maps.css\" rel=\"stylesheet\">\r\n" + 
				"  </head>\r\n" + 
				"  <body >\r\n" + 
				"    <header >\r\n" + 
				"  <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\r\n" + 
				"    <div class=\"container-fluid\">\r\n" + 
				"      <a class=\"navbar-brand col-md-3 col-lg-2 me-0 px-3 \" href=\"#\">Dronet</a>\r\n" + 
				"      <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"      </button>\r\n" + 
				"      <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n" + 
				"        <ul class=\"navbar-nav me-auto mb-2 mb-md-0\">\r\n" + 
				"          <li class=\"nav-item\">\r\n" + 
				"            <a class=\"nav-link active\" aria-current=\"page\" href=\"carousel\">Home</a>\r\n" + 
				"          </li>\r\n" + 
				"          <li class=\"nav-item\">\r\n" + 
				"            <a class=\"nav-link\" href=\"#\">My Profile</a>\r\n" + 
				"          </li>\r\n" + 
				"          <li class=\"nav-item\">\r\n" + 
				"            <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\r\n" + 
				"          </li>\r\n" + 
				"        </ul>\r\n" + 
				"        <ul class=\"navbar-nav px-3\">\r\n" + 
				"    <li class=\"nav-item text-nowrap\">\r\n" + 
				"      <a class=\"nav-link\" href=\"index\">Sign out</a>\r\n" + 
				"    </li>\r\n" + 
				"  </ul>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </nav>\r\n" + 
				"</header>\r\n" + 
				"    <div id=\"map\"></div>\r\n" + 
				"        <h1 id=\"heading\" class=\"h2\">Delivery Locations</h1>\r\n" + 
				"\r\n" + 
				"<script\r\n" + 
				"      src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDvJUTAXrBzuslRyJGhkUCNggCK5hM7nBI&callback=initMap&libraries=&v=weekly\"\r\n" + 
				"      async\r\n" + 
				"    ></script>\r\n" + 
				"\r\n" + 
				"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>\r\n" + 
				"\r\n" + 
				"  </body>\r\n" + 
				"</html>\r\n" + 
				"";
		
		
		return mapsJsp;
	}
	
	@GET
	@Path("/error2")
    @Produces("application/json")
	public InputStream error() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\error2.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GET
	@Path("/home")
	public InputStream home() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\home.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@GET
	@Path("/dashboard")
	public String dataDashboard() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		ArrayList<DroneFlight> flights=(ArrayList<DroneFlight>) deldao.getAllDroneFlights();
		ArrayList<ProductOrder> orders=(ArrayList<ProductOrder>) deldao.getAllProductOrders();
		int duration=0,duration1=0,duration2=0,duration3=0;
		int count=0,count1=0,count2=0,count3=0;
		int max = 0,max1=0,max2=0,max3=0;
		int min=1000,min1=1000,min2=1000,min3=1000;
		
		int over=0;int under=0;int between=0;
		int mel=0;int asp=0;int vent=0;int solp=0;
		for (ProductOrder order:orders) {
			int id=order.getProduct().getId();
			if(id==18) {
				mel++;
			}else if(id==19) {
				asp++;
			}else if(id==20) {
				vent++;
			}else if(id==21) {
				solp++;
			}
		}
		
		
		for(DroneFlight flight:flights) {
			count++;
			int current=0;
			String[] time=flight.getDuration().split(":|\\.");;
			//minutes
			current+=Integer.parseInt(time[1])*60;
			//seconds
			current+=Integer.parseInt(time[2]);
			duration+=current;
			if(current<180) {
				under++;
			}else if(current>=240) {
				over++;
			}else {
				between++;
			}
			if (current>max){
				max=current;
			}
			if (current<min){
				min=current;
			}
			
			if(flight.getNumWaypoints()==1) {
				duration1+=current;
				count1++;
				if (current>max1){
					max1=current;
				}
				if (current<min1){
					min1=current;
				}
			}else if(flight.getNumWaypoints()==2) {
				duration2+=current;
				count2++;
				if (current>max2){
					max2=current;
				}
				if (current<min2){
					min2=current;
				}
			}else if(flight.getNumWaypoints()==3) {
				duration3+=current;
				count3++;
				if (current>max3){
					max3=current;
				}
				if (current<min3){
					min3=current;
				}
			}
			
		}
		
		
		duration=duration/count;
		duration1=duration1/count1;
		duration2=duration2/count2;
		duration3=duration3/count3;
		
		//split into different charts
		
		String jsp="<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>REST Example</title>\r\n" + noBackPageScript+
				"<div >\r\n" + 
				"    	 <ul>\r\n" + 
				"  <li><a href=\"home\" >Home</a></li>\r\n" + 
				"  <li><a href=\"browseProducts\">Browse Products</a></li>\r\n" + 
				"  <li><a href=\"changeLocation\">Change Location</a></li>\r\n" + 
				"  <li><a href=\"data\">About</a></li>\r\n" + 
				"    <li><a href=\"index\">Log Out</a></li>\r\n" + 
				"<li style=\"float:right;\"><a style=\"color:#FF4D00;\" id=\"username\">Dronet</a></li>\r\n" + 
				"</ul>\r\n" + 
				"    </br></br>\r\n" + 
				"<div class=\"barchart\">\r\n" + 
				"	 <canvas id=\"myChart\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 </br></br>\r\n" + 
				"<div class=\"chart\">\r\n" + 
				"	 <canvas id=\"chart\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 \r\n" + 
				"	 <div class=\"piechart\">\r\n" + 
				"	 <canvas id=\"pie\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 \r\n" + 
				"	 <div class=\"doughnut\">\r\n" + 
				"	 <canvas id=\"doughnut\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 </br></br>\r\n" +
				"	 \r\n" + 
				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js\"></script>\r\n" + 
				"<script>\r\n" + 
				"var ctx = document.getElementById('myChart');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'bar',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Flight Time (1 Waypoint)',\r\n" + 
				"            data: ["+duration1+","+max1+","+min1+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        },{label: 'Flight Time (2 Waypoints)',\r\n" + 
				"            data: ["+duration2+","+max2+","+min2+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(54, 162, 235, 1)',\r\n" + 
				"                'rgba(54, 162, 235, 1)',\r\n" + 
				"                'rgba(54, 162, 235, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        },{label: 'Flight Time (3 Waypoints)',\r\n" + 
				"            data: ["+duration3+","+max3+","+min3+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"                'rgba(255, 99, 132, 0.95)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"    options: {\r\n" + 
				"        scales: {\r\n" + 
				"            yAxes: [{\r\n" + 
				"                ticks: {\r\n" + 
				"                    beginAtZero: true\r\n" + 
				"                }\r\n" + 
				"            }]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('chart');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'bar',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Overall Flight Time ',\r\n" + 
				"            data: ["+duration+","+max+","+min+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"    options: {\r\n" + 
				"        scales: {\r\n" + 
				"            yAxes: [{\r\n" + 
				"                ticks: {\r\n" + 
				"                    beginAtZero: true\r\n" + 
				"                }\r\n" + 
				"            }]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('pie');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'pie',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['FT Under 3 mins', 'FT Between 3 & 4 mins', 'FT Over 4 mins'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Products Bought ',\r\n" + 
				"            data: ["+under+","+between+","+over+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"                'rgba(255, 0, 0, 1)',\r\n" + 
				"                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',      \r\n" + 
				"				'rgba(0, 0, 0, 1)',\r\n" + 
				"			],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('doughnut');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'doughnut',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Melatonin Capsules', 'Aspirin', 'Ventolin Inhalor', 'Solpadeine Capsules'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Products Bought ',\r\n" + 
				"            data: ["+mel+","+asp+","+vent+","+solp+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"                'rgba(255, 0, 255, 1)',\r\n" + 
				"                'rgba(255, 0, 0, 1)',\r\n" + 
				"                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',      \r\n" + 
				"				'rgba(0, 0, 0, 1)',\r\n" + 
				"			],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"});\r\n" + 
				"</script>\r\n" + 
				"	<link href=\"http://localhost:8080/dronet/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
				"</head>\r\n" + 
				"<body >	\r\n" + 
				"</body>\r\n" + 
				"</html>";		
		
		String datajsp="<!doctype html>\r\n" + 
				"	<html lang=\"en\">\r\n" + 
				"	  <head>\r\n" + 
				"	    <meta charset=\"utf-8\">\r\n" + 
				"	    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"	    <meta name=\"description\" content=\"\">\r\n" + 
				"	    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\r\n" + 
				"	    <meta name=\"generator\" content=\"Hugo 0.80.0\">\r\n" + 
				"	    <title>Flight Data Dashboard</title>\r\n" + 
				"			<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"	    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/5.0/examples/dashboard/\">\r\n" + 
				"	  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js\"></script>\r\n" + 
				"\r\n" + 
				"	    \r\n" + 
				"\r\n" + 
				"	    <!-- Bootstrap core CSS -->\r\n" + 
				"	<link href=\"../assets/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"	    <style>\r\n" + 
				"	      .bd-placeholder-img {\r\n" + 
				"	        font-size: 1.125rem;\r\n" + 
				"	        text-anchor: middle;\r\n" + 
				"	        -webkit-user-select: none;\r\n" + 
				"	        -moz-user-select: none;\r\n" + 
				"	        user-select: none;\r\n" + 
				"	      }\r\n" + 
				"\r\n" + 
				"	      @media (min-width: 768px) {\r\n" + 
				"	        .bd-placeholder-img-lg {\r\n" + 
				"	          font-size: 3.5rem;\r\n" + 
				"	        }\r\n" + 
				"	      }\r\n" + 
				"	    </style>\r\n" + 
				"\r\n" + 
				"	    \r\n" + 
				"	    <!-- Custom styles for this template -->\r\n" + 
				"	    <link href=\"http://localhost:8080/dronet/dashboard.css\" rel=\"stylesheet\">\r\n" + 
				"	  </head>\r\n" + 
				"	  <body>\r\n" + 
				"\r\n" + 
				"	    \r\n" + 
				"	<header class=\"navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow\">\r\n" + 
				"	  <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\r\n" + 
				"	    <div class=\"container-fluid\">\r\n" + 
				"	      <a class=\"navbar-brand col-md-3 col-lg-2 me-0 px-3\" href=\"#\">Dronet</a>\r\n" + 
				"	      <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"	        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"	      </button>\r\n" + 
				"	      <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n" + 
				"	        <ul class=\"navbar-nav me-auto mb-2 mb-md-0\">\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" aria-current=\"page\" href=\"carousel\">Home</a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">My Profile</a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\r\n" + 
				"	          </li>\r\n" + 
				"	        </ul>\r\n" + 
				"	        <ul class=\"navbar-nav px-3\">\r\n" + 
				"	    <li class=\"nav-item text-nowrap\">\r\n" + 
				"	      <a class=\"nav-link\" href=\"index\">Sign out</a>\r\n" + 
				"	    </li>\r\n" + 
				"	  </ul>\r\n" + 
				"	      </div>\r\n" + 
				"	    </div>\r\n" + 
				"	  </nav>\r\n" + 
				"	</header>\r\n" + 
				"	<div class=\"container-fluid\">\r\n" + 
				"	  <div class=\"row\">\r\n" + 
				"	<nav id=\"sidebarMenu\" class=\"col-md-3 col-lg-2 d-md-block bg-light sidebar collapse\">\r\n" + 
				"	      <div class=\"position-sticky pt-3\">\r\n" + 
				"	        <ul class=\"nav flex-column\">\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link active\" aria-current=\"page\" href=\"dashboard\">\r\n" + 
				"	              <span data-feather=\"home\"></span>\r\n" + 
				"	              Data Dashboard\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"file\"></span>\r\n" + 
				"	              Orders\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"browseProducts\">\r\n" + 
				"	              <span data-feather=\"shopping-cart\"></span>\r\n" + 
				"	              Products\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"changeLocation\">\r\n" + 
				"	              <span data-feather=\"users\"></span>\r\n" + 
				"	              My Details\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"ordermaps\">\r\n" + 
				"	              <span data-feather=\"bar-chart-2\"></span>\r\n" + 
				"	              Waypoint Map\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"layers\"></span>\r\n" + 
				"	              Integrations\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	        </ul>\r\n" + 
				"\r\n" + 
				"	        <h6 class=\"sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted\">\r\n" + 
				"	          <span>Quick Navigation</span>\r\n" + 
				"	          <a class=\"link-secondary\" href=\"#\" aria-label=\"Add a new report\">\r\n" + 
				"	            <span data-feather=\"plus-circle\"></span>\r\n" + 
				"	          </a>\r\n" + 
				"	        </h6>\r\n" + 
				"	        <ul class=\"nav flex-column mb-2\">\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"file-text\"></span>\r\n" + 
				"	              Current month\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"file-text\"></span>\r\n" + 
				"	              Last quarter\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"file-text\"></span>\r\n" + 
				"	              Social engagement\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	          <li class=\"nav-item\">\r\n" + 
				"	            <a class=\"nav-link\" href=\"#\">\r\n" + 
				"	              <span data-feather=\"file-text\"></span>\r\n" + 
				"	              Year-end sale\r\n" + 
				"	            </a>\r\n" + 
				"	          </li>\r\n" + 
				"	        </ul>\r\n" + 
				"	      </div>\r\n" + 
				"	    </nav>\r\n" + 
				"\r\n" + 
				"	    <main class=\"col-md-9 ms-sm-auto col-lg-10 px-md-4\">\r\n" + 
				"	      <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\r\n" + 
				"	        <h1 id=\"heading\"class=\"h2\">Dashboard</h1>\r\n" + 
				"	      </div>\r\n" + 
				"		  <h2 class=\"h3\">Drone Mission Flight Time</h1>\r\n" + 
				"		  <div class=\"chart\">\r\n" + 
				"		 <canvas id=\"chart\"></canvas>\r\n" + 
				"		 </div>\r\n" + 
				"		 </br></br>\r\n" + 
				"		 	 <h2 class=\"h3\">Flight Time For Missions With Different Waypoints</h1>\r\n" + 
				"	<div class=\"barchart\">\r\n" + 
				"		 <canvas id=\"myChart\"></canvas>\r\n" + 
				"		 </div>\r\n" + 
				"		 </br></br>\r\n" + 
				"		 	 	 <h2 class=\"h3\">Flight Time Under/Over/Between 3 and 4 minutes</h1>\r\n" + 
				"		 <div class=\"piechart\">\r\n" + 
				"		 <canvas id=\"pie\"></canvas>\r\n" + 
				"		 </div>\r\n" + 
				"		 </br></br>\r\n" + 
				"		 	 	 <h2 class=\"h3\">Number of Products Bought</h1>\r\n" + 
				"		 <div class=\"doughnut\">\r\n" + 
				"		 <canvas id=\"doughnut\"></canvas>\r\n" + 
				"		 </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"	      <h2>Flight Time Data</h2>\r\n" + 
				"	      <div class=\"table-responsive\">\r\n" + 
				"	        <table class=\"table table-striped table-sm\">\r\n" + 
				"	          <thead>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <th>Statistic</th>\r\n" + 
				"	              <th>Average</th>\r\n" + 
				"	              <th>Maximum</th>\r\n" + 
				"	              <th>Minimum</th>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </thead>\r\n" + 
				"	          <tbody>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>All Deliveries</td>\r\n" + 
				"	              <td>"+duration+"</td>\r\n" + 
				"	              <td>"+max+"</td>\r\n" + 
				"	              <td>"+min+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>Delivery with 1 Waypoint</td>\r\n" + 
				"	              <td>"+duration1+"</td>\r\n" + 
				"	              <td>"+max1+"</td>\r\n" + 
				"	              <td>"+min1+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>Delivery with 2 Waypoints</td>\r\n" + 
				"	              <td>"+duration2+"</td>\r\n" + 
				"	              <td>"+max2+"</td>\r\n" + 
				"	              <td>"+min2+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>Delivery with 3 Waypoints</td>\r\n" + 
				"	              <td>"+duration3+"</td>\r\n" + 
				"	              <td>"+max3+"</td>\r\n" + 
				"	              <td>"+min3+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </tbody>\r\n" + 
				"	        </table>\r\n" + 
				"	      </div>\r\n" + 
				"		  \r\n" + 
				"		  <h2>Flight Time Data Under/Over/Between 3 and 4 Minutes</h2>\r\n" + 
				"	      <div class=\"table-responsive\">\r\n" + 
				"	        <table class=\"table table-striped table-sm\">\r\n" + 
				"	          <thead>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <th>Statistic</th>\r\n" + 
				"	              <th>< 3 Minutes</th>\r\n" + 
				"	              <th>> 4 Minutes</th>\r\n" + 
				"	              <th>3 < x < 4</th>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </thead>\r\n" + 
				"	          <tbody>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>Number of Flights</td>\r\n" + 
				"	              <td>"+under+"</td>\r\n" + 
				"	              <td>"+over+"</td>\r\n" + 
				"	              <td>"+between+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </tbody>\r\n" + 
				"	        </table>\r\n" + 
				"	      </div>\r\n" + 
				"		  \r\n" + 
				"		  <h2>Product Data</h2>\r\n" + 
				"	      <div class=\"table-responsive\">\r\n" + 
				"	        <table class=\"table table-striped table-sm\">\r\n" + 
				"	          <thead>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <th>Statistic</th>\r\n" + 
				"	              <th>Melatonin Capsules</th>\r\n" + 
				"	              <th>Aspirin</th>\r\n" + 
				"	              <th>Ventolin Inhalor</th>\r\n" + 
				"	              <th>Solpadeine Capsules</th>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </thead>\r\n" + 
				"	          <tbody>\r\n" + 
				"	            <tr>\r\n" + 
				"	              <td>Products Sold</td>\r\n" + 
				"	              <td>"+mel+"</td>\r\n" + 
				"	              <td>"+asp+"</td>\r\n" + 
				"	              <td>"+vent+"</td>\r\n" + 
				"	              <td>"+solp+"</td>\r\n" + 
				"	            </tr>\r\n" + 
				"	          </tbody>\r\n" + 
				"	        </table>\r\n" + 
				"	      </div>\r\n" + 
				"	    </main>\r\n" + 
				"	  </div>\r\n" + 
				"	</div>\r\n" + 
				"\r\n" + 
				"	<script>\r\n" + 
				"	var ctx = document.getElementById('myChart');\r\n" + 
				"	var myChart = new Chart(ctx, {\r\n" + 
				"	    type: 'bar',\r\n" + 
				"	    data: {\r\n" + 
				"	        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"	        datasets: [{\r\n" + 
				"	            label: 'Flight Time (1 Waypoint)',\r\n" + 
				"            data: ["+duration1+","+max1+","+min1+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(255, 77, 0, 1)',\r\n" + 
				"	                'rgba(255, 77, 0, 1)',\r\n" + 
				"	                'rgba(255, 77, 0, 1)'\r\n" + 
				"	                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"					],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"	        },{label: 'Flight Time (2 Waypoints)',\r\n" + 
				"            data: ["+duration2+","+max2+","+min2+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(54, 162, 235, 1)',\r\n" + 
				"	                'rgba(54, 162, 235, 1)',\r\n" + 
				"	                'rgba(54, 162, 235, 1)'\r\n" + 
				"	                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"					],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"	        },{label: 'Flight Time (3 Waypoints)',\r\n" + 
				"            data: ["+duration3+","+max3+","+min3+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"	                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"	                'rgba(255, 99, 132, 0.95)'\r\n" + 
				"	                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"					],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"	        }\r\n" + 
				"			]		\r\n" + 
				"	    },\r\n" + 
				"	    options: {\r\n" + 
				"	        scales: {\r\n" + 
				"	            yAxes: [{\r\n" + 
				"	                ticks: {\r\n" + 
				"	                    beginAtZero: true\r\n" + 
				"	                }\r\n" + 
				"	            }]\r\n" + 
				"	        }\r\n" + 
				"	    }\r\n" + 
				"	});\r\n" + 
				"	var ctx = document.getElementById('chart');\r\n" + 
				"	var myChart = new Chart(ctx, {\r\n" + 
				"	    type: 'bar',\r\n" + 
				"	    data: {\r\n" + 
				"	        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"	        datasets: [{\r\n" + 
				"	            label: 'Overall Flight Time ',\r\n" + 
				"            data: ["+duration+","+max+","+min+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(255, 77, 0, 1)',\r\n" + 
				"	                'rgba(255, 77, 0, 1)',\r\n" + 
				"	                'rgba(255, 77, 0, 1)'\r\n" + 
				"	                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"					],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"	        }\r\n" + 
				"			]		\r\n" + 
				"	    },\r\n" + 
				"	    options: {\r\n" + 
				"	        scales: {\r\n" + 
				"	            yAxes: [{\r\n" + 
				"	                ticks: {\r\n" + 
				"	                    beginAtZero: true\r\n" + 
				"	                }\r\n" + 
				"	            }]\r\n" + 
				"	        }\r\n" + 
				"	    }\r\n" + 
				"	});\r\n" + 
				"	var ctx = document.getElementById('pie');\r\n" + 
				"	var myChart = new Chart(ctx, {\r\n" + 
				"	    type: 'pie',\r\n" + 
				"	    data: {\r\n" + 
				"	        labels: ['Less than 3', '3 < x < 4', 'Greater than 4'],\r\n" + 
				"	        datasets: [{\r\n" + 
				"	            label: 'Products Bought ',\r\n" + 
				"            data: ["+under+","+between+","+over+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"	                'rgba(255, 0, 0, 1)',\r\n" + 
				"	                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',      \r\n" + 
				"					'rgba(0, 0, 0, 1)'\r\n" + 
				"				],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"	        }\r\n" + 
				"			]		\r\n" + 
				"	    },\r\n" + 
				"	});\r\n" + 
				"	var ctx = document.getElementById('doughnut');\r\n" + 
				"	var myChart = new Chart(ctx, {\r\n" + 
				"	    type: 'doughnut',\r\n" + 
				"	    data: {\r\n" + 
				"	        labels: ['Melatonin Capsules', 'Aspirin', 'Ventolin Inhalor', 'Solpadeine Capsules'],\r\n" + 
				"	        datasets: [{\r\n" + 
				"	            label: 'Products Bought ',\r\n" + 
				"            data: ["+mel+","+asp+","+vent+","+solp+"],\r\n" + 
				"	            backgroundColor: [\r\n" + 
				"	                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"	                'rgba(255, 0, 255, 1)',\r\n" + 
				"	                'rgba(255, 0, 0, 1)',\r\n" + 
				"	                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"	            ],\r\n" + 
				"	            borderColor: [\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',\r\n" + 
				"	                'rgba(0, 0, 0, 1)',      \r\n" + 
				"					'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"	            borderWidth: 1\r\n" + 
				"				//      <canvas class=\"my-4 w-100\" id=\"myChart\" width=\"900\" height=\"380\"></canvas>\r\n" + 
				"	        }\r\n" + 
				"			]		\r\n" + 
				"	    },\r\n" + 
				"	});\r\n" + 
				"	</script>\r\n" + 
				"\r\n" + 
				"	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>\r\n" + 
				"\r\n" + 
				"	      <script src=\"https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js\" integrity=\"sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE\" crossorigin=\"anonymous\"></script><script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js\" integrity=\"sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha\" crossorigin=\"anonymous\"></script><script src=\"dashboard.js\"></script>\r\n" + 
				"	  </body>\r\n" + 
				"	</html>";
		
		return datajsp;
	}
	
	
	@GET
	@Path("/products")
	public InputStream products() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\products.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	@GET
	@Path("/registration")
	public InputStream registration() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\register.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GET
	@Path("/datadashboard")
	public InputStream dashboard() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\dashboard.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GET
	@Path("/carousel")
	public InputStream carousel() {
		DeliveryDAO deldao=new DeliveryDAO();
		File f;
		if(!isLoggedIn()) {
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\index.jsp");
		}else {
		f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\carousel.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
		
	}
	
	@GET
	@Path("/charts")
	public InputStream charts() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		ArrayList<DroneFlight> flights=(ArrayList<DroneFlight>) deldao.getAllDroneFlights();
		int duration=0;
		int count=0;
		int max=0;
		int min=1000;
		
		for(DroneFlight flight:flights) {
			count++;
			int current=0;
			String[] time=flight.getDuration().split(":|\\.");;
			//minutes
			current+=Integer.parseInt(time[1])*60;
			//seconds
			current+=Integer.parseInt(time[2]);
			System.out.println("Duration: "+current);
			if (current>max){
				max=current;
			}
			if (current<min){
				min=current;
			}
			duration+=current;
		}
		
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		duration=duration/count;

		
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\charts.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

	@GET
	@Path("/data")
	public String data() {
		DeliveryDAO deldao=new DeliveryDAO();
		if(!isLoggedIn()) {
			return indexPage;
		}else {
		ArrayList<DroneFlight> flights=(ArrayList<DroneFlight>) deldao.getAllDroneFlights();
		ArrayList<ProductOrder> orders=(ArrayList<ProductOrder>) deldao.getAllProductOrders();
		int duration=0,duration1=0,duration2=0,duration3=0;
		int count=0,count1=0,count2=0,count3=0;
		int max = 0,max1=0,max2=0,max3=0;
		int min=1000,min1=1000,min2=1000,min3=1000;
		
		int over=0;int under=0;int between=0;
		int mel=0;int asp=0;int vent=0;int solp=0;
		for (ProductOrder order:orders) {
			int id=order.getProduct().getId();
			if(id==18) {
				mel++;
			}else if(id==19) {
				asp++;
			}else if(id==20) {
				vent++;
			}else if(id==21) {
				solp++;
			}
		}
		
		
		for(DroneFlight flight:flights) {
			count++;
			int current=0;
			String[] time=flight.getDuration().split(":|\\.");;
			//minutes
			current+=Integer.parseInt(time[1])*60;
			//seconds
			current+=Integer.parseInt(time[2]);
			duration+=current;
			if(current<180) {
				under++;
			}else if(current>=240) {
				over++;
			}else {
				between++;
			}
			if (current>max){
				max=current;
			}
			if (current<min){
				min=current;
			}
			
			if(flight.getNumWaypoints()==1) {
				duration1+=current;
				count1++;
				if (current>max1){
					max1=current;
				}
				if (current<min1){
					min1=current;
				}
			}else if(flight.getNumWaypoints()==2) {
				duration2+=current;
				count2++;
				if (current>max2){
					max2=current;
				}
				if (current<min2){
					min2=current;
				}
			}else if(flight.getNumWaypoints()==3) {
				duration3+=current;
				count3++;
				if (current>max3){
					max3=current;
				}
				if (current<min3){
					min3=current;
				}
			}
			
		}
		
		
		duration=duration/count;
		duration1=duration1/count1;
		duration2=duration2/count2;
		duration3=duration3/count3;
		
		//split into different charts
		
		String jsp="<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>REST Example</title>\r\n" + 
				"<div >\r\n" + 
				"    	 <ul>\r\n" + 
				"  <li><a href=\"home\" >Home</a></li>\r\n" + 
				"  <li><a href=\"browseProducts\">Browse Products</a></li>\r\n" + 
				"  <li><a href=\"changeLocation\">Change Location</a></li>\r\n" + 
				"  <li><a href=\"data\">About</a></li>\r\n" + 
				"    <li><a href=\"index\">Log Out</a></li>\r\n" + 
				"<li style=\"float:right;\"><a style=\"color:#FF4D00;\" id=\"username\">Dronet</a></li>\r\n" + 
				"</ul>\r\n" + 
				"    </br></br>\r\n" + 
				"<div class=\"barchart\">\r\n" + 
				"	 <canvas id=\"myChart\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 </br></br>\r\n" + 
				"<div class=\"chart\">\r\n" + 
				"	 <canvas id=\"chart\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 \r\n" + 
				"	 <div class=\"piechart\">\r\n" + 
				"	 <canvas id=\"pie\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 \r\n" + 
				"	 <div class=\"doughnut\">\r\n" + 
				"	 <canvas id=\"doughnut\"></canvas>\r\n" + 
				"	 </div>\r\n" + 
				"	 </br></br>\r\n" +
				"	 \r\n" + 
				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js\"></script>\r\n" + 
				"<script>\r\n" + 
				"var ctx = document.getElementById('myChart');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'bar',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Flight Time (1 Waypoint)',\r\n" + 
				"            data: ["+duration1+","+max1+","+min1+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        },{label: 'Flight Time (2 Waypoints)',\r\n" + 
				"            data: ["+duration2+","+max2+","+min2+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(54, 162, 235, 1)',\r\n" + 
				"                'rgba(54, 162, 235, 1)',\r\n" + 
				"                'rgba(54, 162, 235, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        },{label: 'Flight Time (3 Waypoints)',\r\n" + 
				"            data: ["+duration3+","+max3+","+min3+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"                'rgba(255, 99, 132, 0.95)',\r\n" + 
				"                'rgba(255, 99, 132, 0.95)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"    options: {\r\n" + 
				"        scales: {\r\n" + 
				"            yAxes: [{\r\n" + 
				"                ticks: {\r\n" + 
				"                    beginAtZero: true\r\n" + 
				"                }\r\n" + 
				"            }]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('chart');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'bar',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Average (sec)', 'Maximum (sec)', 'Minimum (sec)'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Overall Flight Time ',\r\n" + 
				"            data: ["+duration+","+max+","+min+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)',\r\n" + 
				"                'rgba(255, 77, 0, 1)'\r\n" + 
				"                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"				],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"    options: {\r\n" + 
				"        scales: {\r\n" + 
				"            yAxes: [{\r\n" + 
				"                ticks: {\r\n" + 
				"                    beginAtZero: true\r\n" + 
				"                }\r\n" + 
				"            }]\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('pie');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'pie',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['FT Under 3 mins', 'FT Between 3 & 4 mins', 'FT Over 4 mins'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Products Bought ',\r\n" + 
				"            data: ["+under+","+between+","+over+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"                'rgba(255, 0, 0, 1)',\r\n" + 
				"                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',      \r\n" + 
				"				'rgba(0, 0, 0, 1)',\r\n" + 
				"			],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"});\r\n" + 
				"var ctx = document.getElementById('doughnut');\r\n" + 
				"var myChart = new Chart(ctx, {\r\n" + 
				"    type: 'doughnut',\r\n" + 
				"    data: {\r\n" + 
				"        labels: ['Melatonin Capsules', 'Aspirin', 'Ventolin Inhalor', 'Solpadeine Capsules'],\r\n" + 
				"        datasets: [{\r\n" + 
				"            label: 'Products Bought ',\r\n" + 
				"            data: ["+mel+","+asp+","+vent+","+solp+"],\r\n" + 
				"            backgroundColor: [\r\n" + 
				"                'rgba(0, 255, 0, 0.95)',\r\n" + 
				"                'rgba(255, 0, 255, 1)',\r\n" + 
				"                'rgba(255, 0, 0, 1)',\r\n" + 
				"                'rgba(255, 255, 0, 0.95)'                \r\n" + 
				"            ],\r\n" + 
				"            borderColor: [\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',\r\n" + 
				"                'rgba(0, 0, 0, 1)',      \r\n" + 
				"				'rgba(0, 0, 0, 1)',\r\n" + 
				"			],\r\n" + 
				"            borderWidth: 2\r\n" + 
				"        }\r\n" + 
				"		]		\r\n" + 
				"    },\r\n" + 
				"});\r\n" + 
				"</script>\r\n" + 
				"	<link href=\"http://localhost:8080/dronet/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
				"</head>\r\n" + 
				"<body >	\r\n" + 
				"</body>\r\n" + 
				"</html>";		
		
		return jsp;
		}
	}
	
	@GET
	@Path("/index")
	public String index() {
		DeliveryDAO deldao=new DeliveryDAO();
	
		request.getSession(true);
		HttpSession session = request.getSession();
		session.setAttribute("user","");
		return indexPage;
	}
	
	public boolean isLoggedIn() {
		request.getSession(true);
		HttpSession session = request.getSession();		
		String email=session.getAttribute("user").toString();
		System.out.println("Loggen in:"+email);
		return !email.equals("");
	}
	
	
	@GET
	@Path("/browseProducts")
	public String browse() throws SQLException {
		DeliveryDAO deldao=new DeliveryDAO();
		
		
		
		ArrayList<Product> products=(ArrayList<Product>) deldao.getAllProducts();
//	
			 
		if(!isLoggedIn()) {
			return indexPage;
		}else {
		
		String table="<table class=\"my-table table-striped table table-hover align-middle\">";
		table+="<thead class=\"table-dark\">";
		table+="<tr>";
		table+="<th>Product Number</th>";
		table+="<th>Image</th>"; 
		table+="<th>Name</th>"; 
		table+="<th>Price</th>"; 
		table+="<th>Purchase Item?</th>"; 
		table+="</tr>";	
		table+="</thead>";	

	

		
				for(int i=0;i<products.size();i++) {
					table+="<tr>";
					table+="<th type=\"text\" scope=\"row\">"+products.get(i).getId()+"</th>";
					table+=	"<td><img src="+products.get(i).getImage()+" height=\"200\" width=\"200\"/></td>";
					table+=	"<td>"+products.get(i).getName()+"</td>";
					table+=	"<td>"+products.get(i).getPrice()+"</td>";
					table+=	" <td><input id=\"myTextBox"+String.valueOf(i+1)+"\" type=\"checkbox\" name=\"checkbox\" value="+products.get(i).getId()+" /></td>";
					table+=	"</tr>"; 

				 }


				table+="</table>";
				
				String productsJsp="<html>\r\n" + 
						"<head>\r\n" + 
						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
						"<title>REST Example</title>\r\n" + 
						"	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\r\n" + 
						"    <script src=\"https://js.stripe.com/v3/\">\r\n" + 
						"	\r\n" + 
						"	</script>\r\n" + noBackPageScript+
						"\r\n" + 
						"    <link href=\"http://localhost:8080/dronet/carousel.css\" rel=\"stylesheet\">\r\n" + 
						"</head>\r\n" + 
						"<body >\r\n" + 
						"<div class=\"body\">\r\n" + 
						"    \r\n" + 
						"	 \r\n" + 
						"<header >\r\n" + 
						"  <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\r\n" + 
						"    <div class=\"container-fluid\">\r\n" + 
						"      <a class=\"navbar-brand col-md-3 col-lg-2 me-0 px-3\" href=\"#\">Dronet</a>\r\n" + 
						"      <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
						"        <span class=\"navbar-toggler-icon\"></span>\r\n" + 
						"      </button>\r\n" + 
						"      <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\r\n" + 
						"        <ul class=\"navbar-nav me-auto mb-2 mb-md-0\">\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link active\" aria-current=\"page\" href=\"carousel\">Home</a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">My Profile</a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\r\n" + 
						"          </li>\r\n" + 
						"        </ul>\r\n" + 
						"        <ul class=\"navbar-nav px-3\">\r\n" + 
						"    <li class=\"nav-item text-nowrap\">\r\n" + 
						"      <a class=\"nav-link\" href=\"index\">Sign out</a>\r\n" + 
						"    </li>\r\n" + 
						"  </ul>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"  </nav>\r\n" + 
						"</header>\r\n" + 
						"<div class=\"container-fluid\">\r\n" + 
						"  <div class=\"row\">\r\n" + 
						"<nav id=\"sidebarMenu\" class=\"col-md-3 col-lg-2 d-md-block bg-light sidebar collapse\">\r\n" + 
						"      <div class=\"position-sticky pt-3\">\r\n" + 
						"        <ul class=\"nav flex-column\">\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" aria-current=\"page\" href=\"dashboard\">\r\n" + 
						"              <span data-feather=\"home\"></span>\r\n" + 
						"              Data Dashboard\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"file\"></span>\r\n" + 
						"              Orders\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"browseProducts\">\r\n" + 
						"              <span data-feather=\"shopping-cart\"></span>\r\n" + 
						"              Products\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"changeLocation\">\r\n" + 
						"              <span data-feather=\"users\"></span>\r\n" + 
						"              My Details\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"ordermaps\">\r\n" + 
						"              <span data-feather=\"bar-chart-2\"></span>\r\n" + 
						"              Waypoint Map\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"layers\"></span>\r\n" + 
						"              Integrations\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"        </ul>\r\n" + 
						"\r\n" + 
						"        <h6 class=\"sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted\">\r\n" + 
						"          <span>Quick Navigation</span>\r\n" + 
						"          <a class=\"link-secondary\" href=\"#\" aria-label=\"Add a new report\">\r\n" + 
						"            <span data-feather=\"plus-circle\"></span>\r\n" + 
						"          </a>\r\n" + 
						"        </h6>\r\n" + 
						"        <ul class=\"nav flex-column mb-2\">\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"file-text\"></span>\r\n" + 
						"              Current month\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"file-text\"></span>\r\n" + 
						"              Last quarter\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"file-text\"></span>\r\n" + 
						"              Social engagement\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"          <li class=\"nav-item\">\r\n" + 
						"            <a class=\"nav-link\" href=\"#\">\r\n" + 
						"              <span data-feather=\"file-text\"></span>\r\n" + 
						"              Year-end sale\r\n" + 
						"            </a>\r\n" + 
						"          </li>\r\n" + 
						"        </ul>\r\n" + 
						"      </div>\r\n" + 
						"    </nav>\r\n" + 
						"	\r\n" + 
						"	<main class=\"col-md-9 ms-sm-auto col-lg-10 px-md-4\">\r\n" + 
						"\r\n" + 
						"	<div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\r\n" + 
						"        <h1 id=\"heading\" class=\"h2\">Products</h1>\r\n" + 
						"        \r\n" + 
						"      </div>\r\n" + 
						"	\r\n" + 
						"	<div class=\"card-body\">\r\n" + 
						table+
						"	<div class=\"d-grid gap-2 col-12 mx-auto\">\r\n" + 
						"	<input class=\"btn btn-dark btn-lg\" type=\"submit\" value=\"Proceed to Checkout\" id=\"checkout-button\"/>\r\n" + 
						"	</div>\r\n" + 
						"	</div>\r\n" + 
						"	\r\n" + 
						"\r\n" + 
						"</main>\r\n" + 
						"</div>\r\n" + 
						"</div>\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"	<script>\r\n" + 
						"	window.onload = function checkoutActive() {\r\n" + 
						"    // Create an instance of the Stripe object with your publishable API key\r\n" + 
						"    var stripe = Stripe(\"pk_test_51INyTFGtkOOMud5PO6NkF9GW7kibpp8thYn38BSYTo59o9QHzNiD3OTMe7GgUdh3IXjsEFF7cYBDTEYG1RcFBJcy00z4hcmnkB\");\r\n" + 
						"    var checkoutButton = document.getElementById(\"checkout-button\");\r\n" + 
						"	\r\n" + 
						"	console.log(\"Active\");\r\n" + 
						"    checkoutButton.addEventListener(\"click\", function () {\r\n" + 
						"		//CHECK IF ONLY 1 CHECKBOX IS TICKED\r\n" + 
						"		var boxes = document.getElementsByName(\"checkbox\");\r\n" + 
						"		var tb=[];\r\n" + 
						"		var x=0;\r\n" + 
						"		for(let i=0;i<boxes.length;i++){\r\n" + 
						"			if(boxes[i].checked===true){\r\n" + 
						"				tb[x]=boxes[i].value;\r\n" + 
						"				x+=1;\r\n" + 
						"			}\r\n" + 
						"		}\r\n" + 
						"		console.log(tb[0]);\r\n" + 
						"		console.log(tb[1]===null);\r\n" + 
						"	\r\n" + 
						"		//ALERT USER IF INVALID ORDER OTHERWISE PROCEED TO CHECKOUT\r\n" + 
						"		if(tb[1]!=null){\r\n" + 
						"			alert(\"Please Select 1 Product Only...\");\r\n" + 
						"		}\r\n" + 
						"		else{\r\n" + 
						"		\r\n" + 
						"      fetch(\"/dronet/restful-services/sampleservice/create-checkout-session/\"+tb[0], {\r\n" + 
						"        method: \"POST\",\r\n" + 
						"      })\r\n" + 
						"        .then(function (response) {\r\n" + 
						"          return response.json();\r\n" + 
						"        })\r\n" + 
						"        .then(function (session) {\r\n" + 
						"          return stripe.redirectToCheckout({ sessionId: session.id });\r\n" + 
						"        })\r\n" + 
						"        .then(function (result) {\r\n" + 
						"          // If redirectToCheckout fails due to a browser or network\r\n" + 
						"          // error, you should display the localized error message to your\r\n" + 
						"          // customer using error.message.\r\n" + 
						"          if (result.error) {\r\n" + 
						"            alert(result.error.message);\r\n" + 
						"		\r\n" + 
						"		   \r\n" + 
						"          }\r\n" + 
						"        })\r\n" + 
						"        .catch(function (error) {\r\n" + 
						"			alert(\"You can only purchase 1 product at a time\");\r\n" + 
						"			console.error(\"Error:\", error);		  \r\n" + 
						"        });\r\n" + 
						"		}});\r\n" + 
						"	}\r\n" + 
						"  </script>\r\n" + 
						"	</div>\r\n" + 
						"</body>\r\n" + 
						"</html>";
				System.out.println(table);
				
				String stripeScript="<script>\r\n" + 
						"	window.onload = function checkoutActive() {\r\n" + 
						"    // Create an instance of the Stripe object with your publishable API key\r\n" + 
						"    var stripe = Stripe(\"pk_test_51INyTFGtkOOMud5PO6NkF9GW7kibpp8thYn38BSYTo59o9QHzNiD3OTMe7GgUdh3IXjsEFF7cYBDTEYG1RcFBJcy00z4hcmnkB\");\r\n" + 
						"    var checkoutButton = document.getElementById(\"checkout-button\");\r\n" + 
						"	\r\n" + 
						"	console.log(\"Active\");\r\n" + 
						"    checkoutButton.addEventListener(\"click\", function () {\r\n" + 
						"		//CHECK IF ONLY 1 CHECKBOX IS TICKED\r\n" + 
						"		var boxes = document.getElementsByName(\"checkbox\");\r\n" + 
						"		var tb=[];\r\n" + 
						"		var x=0;\r\n" + 
						"		for(let i=0;i<boxes.length;i++){\r\n" + 
						"			if(boxes[i].checked===true){\r\n" + 
						"				tb[x]=boxes[i].value;\r\n" + 
						"				x+=1;\r\n" + 
						"			}\r\n" + 
						"		}\r\n" + 
						"		console.log(tb[0]);\r\n" + 
						"		console.log(tb[1]===null);\r\n" + 
						"	\r\n" + 
						"		//ALERT USER IF INVALID ORDER OTHERWISE PROCEED TO CHECKOUT\r\n" + 
						"		if(tb[1]!=null){\r\n" + 
						"			alert(\"Please Select 1 Product Only...\");\r\n" + 
						"		}\r\n" + 
						"		else{\r\n" + 
						"		\r\n" + 
						"      fetch(\"/dronet/restful-services/sampleservice/create-checkout-session/\"+tb[0], {\r\n" + 
						"        method: \"POST\",\r\n" + 
						"      })\r\n" + 
						"        .then(function (response) {\r\n" + 
						"          return response.json();\r\n" + 
						"        })\r\n" + 
						"        .then(function (session) {\r\n" + 
						"          return stripe.redirectToCheckout({ sessionId: session.id });\r\n" + 
						"        })\r\n" + 
						"        .then(function (result) {\r\n" + 
						"          // If redirectToCheckout fails due to a browser or network\r\n" + 
						"          // error, you should display the localized error message to your\r\n" + 
						"          // customer using error.message.\r\n" + 
						"          if (result.error) {\r\n" + 
						"            alert(result.error.message);\r\n" + 
						"		\r\n" + 
						"		   \r\n" + 
						"          }\r\n" + 
						"        })\r\n" + 
						"        .catch(function (error) {\r\n" + 
						"			alert(\"Please Select 1 Product Only...\");\r\n" + 
						"			console.error(\"Error:\", error);		  \r\n" + 
						"        });\r\n" + 
						"		}});\r\n" + 
						"	}\r\n" + 
						"  </script>";
		
				
				String html = "<html>\r\n" + 
						"<head>\r\n" + 
						"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
						"<title>REST Example</title>\r\n" + 
						"\r\n" + "    <script src=\"https://js.stripe.com/v3/\"></script>\r\n" + 
						stripeScript+
						"		<link href=\"http://localhost:8080/dronet/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
						"</head>\r\n" + 
						"<body >\r\n" + 
						"<div class=\"body\">\r\n" + 
						"    \r\n" + 
						"	 \r\n" + 
						"	<ul>\r\n" + 
						"  <li><a href=\"carousel\">Home</a></li>\r\n" + 
						"  <li><a href=\"browseProducts\">Browse Products</a></li>\r\n" + 
						"  <li><a href=\"changeLocation\" >Change Location</a></li>\r\n" + 
						"  <li><a href=\"home\">About</a></li>\r\n" + 
						"    <li><a href=\"index\">Log Out</a></li>\r\n" + 
						"	<li style=\"float:right;\"><a style=\"color:#FF4D00;\">Dronet</a></li>\r\n" + 
						"</ul></br></br>" + 
						"	\r\n" + 
						"	\r\n" + 
						table+"</br></br>"+
						"\r\n" + 
						"        </br>\r\n" + 
						"<input class=\"button\" type=\"submit\" value=\"Make Purchase\" id=\"checkout-button\"/>\r\n" + 
						"	\r\n" +
						"	</div>\r\n" + 
						"</body>\r\n" + 
						"</html>";
				return  productsJsp;
		}
	}
	
	@POST
	@Path("/create-checkout-session/{productid}")
    @Produces("application/json")
	public String stripe(@PathParam("productid") String productid) throws StripeException {
		DeliveryDAO deldao=new DeliveryDAO();
	//	Stripe.apiKey="pk_test_51INyTFGtkOOMud5PO6NkF9GW7kibpp8thYn38BSYTo59o9QHzNiD3OTMe7GgUdh3IXjsEFF7cYBDTEYG1RcFBJcy00z4hcmnkB";
		Stripe.apiKey="sk_test_51INyTFGtkOOMud5PVHZcqcBaUiKgo9i3LvvmJYuD0dnJiYqQHQHnbZn9ZPVyNksfbOWcIgDNZo7JF0lvZWLjMfAX00GOSzJPOn";
//db checking here
//		
		request.getSession(true);
		HttpSession session = request.getSession();	
		
		if(!isLoggedIn()) {
			return indexPage;
		}else {
		//else login again 
		
		Product product=deldao.getProductById(Integer.valueOf(productid));
		
		session.setAttribute("productid",productid);
		

		System.out.println("ProductID:"+productid);

		//create a checkout session
		SessionCreateParams params =
		        SessionCreateParams.builder()
		          .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
		          .setMode(SessionCreateParams.Mode.PAYMENT)
		          .setSuccessUrl("http://localhost:8080/dronet/restful-services/sampleservice/ordersuccess")
		          .setCancelUrl("http://localhost:8080/dronet/error2.jsp")
		          .addLineItem(
		          SessionCreateParams.LineItem.builder()
		            .setQuantity(1L)
		            .setPriceData(
		              SessionCreateParams.LineItem.PriceData.builder()
		                .setCurrency("eur")
		                .setUnitAmount(product.getPrice()*100L)
		                .setProductData(
		                  SessionCreateParams.LineItem.PriceData.ProductData.builder()
		                    .setName(product.getName())
		                    .build())
		                .build())
		            .build())
		          .build();

		      Session stripesession=null;
		      stripesession = Session.create(params);
				

		      Map<String, String> responseData = new HashMap();
		      responseData.put("id", stripesession.getId());
		      //responseData.put("id", "dave");

		      System.out.println(responseData.toString());
		      return gson.toJson(responseData);
		}
		
//		
//		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\products.jsp");
//		try {
//			return new FileInputStream(f);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
	}
	
	@GET
	@Path("/ordersuccess")
	public InputStream success() {
		DeliveryDAO deldao=new DeliveryDAO();
		File f;
		request.getSession(true);
		HttpSession session = request.getSession();
		String email=session.getAttribute("user").toString();
		String productid=session.getAttribute("productid").toString();
		Customer customer=deldao.getCustomerByEmail(email);
		Product product=deldao.getProductById(Integer.parseInt(productid));

		ProductOrder order=new ProductOrder(customer,product,customer.getLongitude(),customer.getLatitude(),product.getPrice(),"ordered");
		deldao.persistProductOrder(order);

			
		f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\ordersuccess.jsp");
		
		
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	 
	@GET
	@Path("/buyProducts")
	public InputStream buy(
			@QueryParam("myTextBox1") String myTextBox1,
			@QueryParam("myTextBox2") String myTextBox2,
			@QueryParam("myTextBox3") String myTextBox3,
			@QueryParam("myTextBox4") String myTextBox4) {
		DeliveryDAO deldao=new DeliveryDAO();
		String productid=null;
		File f;
		request.getSession(true);
		HttpSession session = request.getSession();		
		String email=session.getAttribute("user").toString();
		
		String[] products= {myTextBox1,myTextBox2,myTextBox3,myTextBox4};
		for (int i=0;i<products.length;i++) {
			if(products[i]!=null) {
				productid=products[i];
			}
		}
		
		
		
		Customer customer=deldao.getCustomerByEmail(email);
		if(customer.getName()!=null &&productid!=null) {	
			Product product=deldao.getProductById(Integer.parseInt(productid));
			customer.getLongitude();
			customer.getLatitude();
			ProductOrder order=new ProductOrder(customer,product,customer.getLongitude(),customer.getLatitude(),product.getPrice(),"ordered");
			deldao.persistProductOrder(order);
			
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\ordersuccess.jsp");
			}else {
				f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\error2.jsp");
			}

		
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/changeGps")
	@Produces("text/html")
	public InputStream changeGps(@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude)  {
		DeliveryDAO deldao=new DeliveryDAO();	
		File f;
		
		request.getSession(true);
		HttpSession session = request.getSession();		
		String email=session.getAttribute("user").toString();
		
		Customer customer=deldao.getCustomerByEmail(email);
		
		if(customer.getName()!=null) {	
		customer.setLongitude(longitude);
		customer.setLatitude(latitude);
		deldao.mergeCustomer(customer);
		
		f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\carousel.jsp");
		}else {
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\error2.jsp");
		}
		
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		else {
//			return "Login details incorrect... Customer not found";
//		}
		return null;
	}
	
	@GET
	@Path("/logincustomer")
	@Produces("text/html")
	public InputStream loginCustomer(@QueryParam("email") String email,
			@QueryParam("password") String password)  {
		DeliveryDAO deldao=new DeliveryDAO();
		File f;
		Customer customer=deldao.getCustomerByEmail(email);
		if (customer.getEmail()!=null && customer.getPassword().equals(password)) {
			request.getSession(true);
			HttpSession session = request.getSession();
			session.setAttribute("user",customer.getEmail());
			System.out.println("User: "+session.getAttribute("user"));
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\carousel.jsp");
		}else {
			f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\error.jsp");
		}
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		else {
//			return "Login details incorrect... Customer not found";
//		}
		return null;
	}
	
	@GET
	@Path("/enterGps")
	@Produces("text/html")
	public InputStream addGpsCoordinates(@QueryParam("longitude") String longitude,
			@QueryParam("latitude") String latitude)  {
		DeliveryDAO deldao=new DeliveryDAO();
		
		
		File f=new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\dronet\\carousel.jsp");
		try {
			return new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		else {
//			return "Login details incorrect... Customer not found";
//		}
		return null;
	}
	
	@POST
	@Path("/register")
	@Consumes("application/xml")
	public String addCustomer(Customer customer) {
		DeliveryDAO deldao=new DeliveryDAO();
		Customer customer1=new Customer(customer.getName(),customer.getEmail(),customer.getPassword());
		deldao.persistCustomer(customer1);
		
		return "Customer added to db "+customer1.getName();
	}
	
//	@POST
//	@Path("/register/json")
//	@Consumes("application/json")
//	public String addCustomerJSON(@QueryParam("name") String name) {
//		DeliveryDAO deldao=new DeliveryDAO();
//		Customer customer1=new Customer(name,"sdsd","fgfg","dfsafa");
//		deldao.persistCustomer(customer1);
//		
//		return "Customer added to db "+customer1.getName();
//	}
	
	@POST
	@Path("/register/json")
	@Consumes("application/json")
	public String addCustomerJSON(Customer customer) {
		DeliveryDAO deldao=new DeliveryDAO();
		Customer customer1=new Customer(customer.getName(),customer.getEmail(),customer.getPassword());
		deldao.persistCustomer(customer1);
		
		return "Customer added to db "+customer1.getName();
	}
	
	//WEBSERVICE get method
		//create dao
		//create emp
		//persist
	
	@PUT
	@Path("/updatecustomer/xml")
	@Consumes("application/xml")
	public String updateEmployee(Customer customer) {
		DeliveryDAO deldao=new DeliveryDAO();
		//Employee emp=getEmployeeById(employee.getemployeeid()
		//		empdao.merge(employee);
		deldao.mergeCustomer(customer);
		return "Customer name changed to "+customer.getName();
	}
	//functions strangely
	@DELETE
	@Path("deletecustomer/xml")
	@Consumes("application/xml")
	public String deleteCustomer(Customer customer) {
		DeliveryDAO deldao=new DeliveryDAO();
		deldao.removeCustomer(customer);
		return "Customer "+customer.getName()+" has been deleted";
	}
	
	
//	@GET
//    @Path("/employees/json")
//    @Produces("application/json")
//    public List<Customer> listEmployeesJSON(){
//		return new ArrayList<Customer>(employees.values());
//    }
//	
//	@POST
//	@Path("/createjson")
//	@Consumes("application/json")
//	public String addEmployeeJSON(Customer employee) {
//		return "Employee added "+employee.getEmployeeName();
//	}
//	
//	@PUT
//	@Path("/updateemployee/json")
//	@Consumes("application/json")
//	public String updateEmployeeJSON(Customer employee) {
//		employee.setEmployeeName("David");
//		return "Employee name changed to "+employee.getEmployeeName();
//	}
//	
//	@DELETE
//	@Path("deleteemployee/json")
//	@Consumes("application/json")
//	public String deleteEmployeeJSON(Customer employee) {
//		employees.remove(employee.getEmployeeId());
//		return "Employee "+employee.getEmployeeName()+" has been deleted";
//	}
//	
//	
//	@GET
//    @Path("/employee/{employeeid}")
//    @Produces("application/xml")
//    public Customer getEmployee(@PathParam("employeeid")String employeeId){
//		DeliveryDAO deldao=new DeliveryDAO();
//		return empdao.getEmployeeById(Integer.parseInt(employeeId));			
//    }
//	
//
//	@GET
//    @Path("/json/employee/{employeeid}")
//    @Produces("application/json")
//    public Customer getEmployeeJSON(@PathParam("employeeid")String employeeId){
//		DeliveryDAO deldao=new DeliveryDAO();
//		return empdao.getEmployeeById(Integer.parseInt(employeeId));		
//    }
//	
}




