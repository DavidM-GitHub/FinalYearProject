package FYP; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import FYP.GeocodeResponse.Result;

public class dbTest {

	public dbTest() throws JsonSyntaxException, JsonIOException, MalformedURLException, IOException {
		
//		DecimalFormat df = new DecimalFormat("#.##"); // Set your desired format here.
////
//		double distanceInMetres=distFrom(53.502956,-6.450588,53.5032596,-6.4508143);
//		System.out.println(distanceInMetres);
//		double sleepTime=35;//sleep+landing+takeoff time
//		int speed=5;//5 m/s
//		double flightDuration=((distanceInMetres/speed)+sleepTime)/60;
//		System.out.println(flightDuration);
//		String flightDuratio="1.6154461669921873";
//		String time=df.format(flightDuratio);
//		System.out.println(time);
////		
//String[] duration=time.split("\\.");
//System.out.println(duration[1]);
//int sec=Integer.parseInt(duration[1]);
//System.out.println(sec);
//sec=sec*60;
//		System.out.println("Estimated Delivery Duration: "+flightDuratio);
//		String flightDuration=duration[0]+"."+sec;
//		String formattedTime=df.format(Double.parseDouble(flightDuration));
//		System.out.println(formattedTime);
//		
		
	//	DeliveryDAO deliveryDAO=new DeliveryDAO();
////		
////		Customer customer=deliveryDAO.getCustomerById(78);
////		//Product p4=new Product("Solpadeine","https://www.medicine-online.org/4462-large_default/solpadeine-24-tablets-.jpg",12);
////		Product product=deliveryDAO.getProductById(21);
////		ProductOrder order=new ProductOrder(customer, product, customer.getLatitude(),customer.getLongitude(), product.getPrice(),"ordered");
//////		//String orderstatus)
//////		Customer c3=new Customer("Dave","dave@g.c","p123");
//////
//////		ProductOrder po=new ProductOrder(c3,p4,"53.5032596","-6.4508143",p4.getPrice(),"Ordered");
////		deliveryDAO.persistProductOrder(order);
////		
//		ProductOrder order1=deliveryDAO.getProductOrderById(124);
//		order1.setLatitude("53.4997761");
//		order1.setLongitude("-6.4512793");
//		order1.setOrderstatus("ordered");
//		deliveryDAO.mergeProductOrder(order1);
//		
//		ProductOrder order2=deliveryDAO.getProductOrderById(125);
//		order2.setLatitude("53.4997125");
//		order2.setLongitude("-6.4513132");
//		order2.setOrderstatus("ordered");
//		deliveryDAO.mergeProductOrder(order2);

//		Customer cust=deliveryDAO.getCustomerById(42);
//		cust.setAdmin("Yes");
//		deliveryDAO.mergeCustomer(cust);

		
//		DroneFlight p=new DroneFlight(1.58229,5.9779,"0.04",80,"00:04:30.459000",3);
//		deliveryDAO.persistDroneFlight(p);
//		DroneFlight q=new DroneFlight(1.49898,5.98769,"0.012",90,"00:04:20.459000",3);
//		deliveryDAO.persistDroneFlight(q);
		//String latitude="1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA";
//		String latitude="37.4222585,-122.0840265";
//		Gson gson = new Gson();
//		long lastRequest = 0L;
//		String key="&key=AIzaSyCaRGxXQ8eIkhPlnUojB42dQbgEQSprSBA";
//		String hq="53.502956, -6.450588";
////		
//		String[] words=latitude.split(" ");
//		StringBuilder sb = new StringBuilder();
//        for (String string : words) {
//           if (sb.length() > 0) {
//                sb.append('+');
//            }
//            sb.append(URLEncoder.encode(latitude.replace(' ', '+'), "UTF-8"));
//        }
//        String url = "https://maps.googleapis.com/maps/api/geocode/json?&latlng=" + sb.toString()+key;
//        // Google limits this web service to 2500/day and 10 requests/s
//        synchronized (this) {
//            try {
//                long elapsed = System.currentTimeMillis() - lastRequest;
//                if (elapsed < 100) {
//                    try {
//                        Thread.sleep(100 - elapsed);
//                    } catch (InterruptedException e) {
//                    }
//                }
//                GeocodeResponse response=gson.fromJson(new BufferedReader(new InputStreamReader(new URL(url).openStream())), GeocodeResponse.class);
//                List<Result> results= response.getResults();
//               // System.out.println(results.toString()+response.getStatus().toString());
//                
//                System.out.println(results.get(0).getFormatted_address());
//                
//            } finally {
//                lastRequest = System.currentTimeMillis();
//            }
//        }		//double currentLongitude, double currentLatitude, String altitude, int batteryPercentage,
		//String duration, int numWaypoint
		//DroneFlight df=new DroneFlight(1.5,5.5,"2 metres",98,"00:02:59.459000",2);
		//deliveryDAO.persistDroneFlight(df);
//		Product p1=new Product("penisulin",1);
//		Product p2=new Product("solpadine",2);
//		Product p1=new Product("Welonox Melatonin","https://m.media-amazon.com/images/I/315ZRpnHLtL.jpg",25);
//		Product p2=new Product("Zinc Tablets","https://cdn.shopify.com/s/files/1/0341/8718/2139/products/Zinc50mg0001_grande.png?2534",21,100);
//		Product p3=new Product("Vitamin D3 Capsules","https://www.phd.com/media/catalog/product/v/i/vitmain-d3-180-capsules.png?quality=80&fit=bounds&height=700&width=700&canvas=700:700",29,100);
//		
//		deliveryDAO.persistProduct(p2);
//		deliveryDAO.persistProduct(p3);
////		deliveryDAO.persistProduct(p3);
////		deliveryDAO.persistProduct(p4);
//
//		Product product=deliveryDAO.getProductById(21);
//		product.setStock(100);
////		Product product1=deliveryDAO.getProductById(18);
////		product1.setStock(100);
////		Product product2=deliveryDAO.getProductById(19);
////		product2.setStock(100);
////		Product product3=deliveryDAO.getProductById(20);
////		product3.setStock(100);
//		deliveryDAO.mergeProduct(product);
//		deliveryDAO.mergeProduct(product1);
//		deliveryDAO.mergeProduct(product2);
//		deliveryDAO.mergeProduct(product3);

//		
//		List<Product> products=new ArrayList<Product>();
////		List<Product> products2=new ArrayList<Product>();
////		products2.add(p1);
////		products2.add(p2);
//		products.add(p1);
//		products.add(p2);
//		
//		Customer c1=new Customer("Dave","dave@g.c","p123");
//		c1.setLongitude("1");
//		c1.setLatitude("2");

//		Customer c2=new Customer("Dave","dave@g.c","p123","53.502956", "-6.450588");
//		Customer c3=new Customer("Dave","dave@g.c","p123","53.503247", "-6.451038");
//		Customer c4=new Customer("Dave","dave@g.c","p123","4565", "678778");
//		Customer c5=new Customer("Dave","dave@g.c","p123","879788", "7678773");
	//	Customer c2=new Customer("Mark","mark@d.c","p444","ashbourne");
		//deliveryDAO.persistCustomer(c1);
//		deliveryDAO.persistCustomer(c2);
//
//		deliveryDAO.persistCustomer(c3);
//
//		deliveryDAO.persistCustomer(c4);
//
//		deliveryDAO.persistCustomer(c5);

	//	deliveryDAO.persistCustomer(c2);
		
//		deliveryDAO.removeCustomer(c1);
		
//		c2.setName("Frank");
//		deliveryDAO.mergeCustomer(c2);
		
//		List<Customer> customers= (ArrayList<Customer>)deliveryDAO.getAllCustomers();
//		for (Customer customer:customers) {
//			System.out.println(customer.toString());
//		}

		
		
//		List<Customer> customers=new ArrayList<Customer>();
//		customers.add(c1);
//		customers.add(c2);
//		
//		
//		Route r1=new Route(3,customers);
//		Route r2=new Route(4,customers);
//		
//		deliveryDAO.persistRoute(r1);
//		deliveryDAO.persistRoute(r2);
//		
//		List<Route> routes=new ArrayList<Route>();
//		routes.add(r1);
//		routes.add(r2);
//
//		
//		Drone d1=new Drone(true,2,4,"DJI",6,98,routes);
//		deliveryDAO.persistDrone(d1);
//		
//		Package package1=new Package(4,66,products,d1);
//		Package package2=new Package(4,66,products,d1);
//
//		deliveryDAO.persistPackage(package1);
//		deliveryDAO.persistPackage(package2);
//
//		List<Package> load=new ArrayList<Package>();
//		load.add(package1);
//		load.add(package2);
//
//		
//		Warehouse w1=new Warehouse(99,33,load);
		//System.out.println(getFormattedDuration(238.0));
	}
	
	public String getFormattedDuration(Double dfDuration) {
		dfDuration=dfDuration/60;
		DecimalFormat df = new DecimalFormat("#.##"); // Set your desired format here.
		String time=df.format(dfDuration);		
		String[] duration=time.split("\\.");
		int sec=Integer.parseInt(duration[1]);
		sec=sec*6;
		System.out.println();
		if(duration[1].charAt(0)=='0') {
			sec=sec/10;
		}
		String flightDuration=duration[0]+"."+sec;
		String formattedTime=df.format(Double.parseDouble(flightDuration));
		System.out.println("formatted time "+formattedTime);
		String[] formattedDuration=formattedTime.split("\\.");
		String total=formattedDuration[0]+" minutes "+formattedDuration[1]+" seconds";
		System.out.println("total: "+total);
		return total;
	}
	
	public static float distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 6371000; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;
	    }
	

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, MalformedURLException, IOException {
		new dbTest();
	}
}
