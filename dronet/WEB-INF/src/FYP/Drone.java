package FYP; 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private boolean status;
	private float longitude_location;
	private float latitude_location;
	private String type;
	private float altitude;
	private int batteryPercentage;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Route> routes=new ArrayList<Route>();
	
	public Drone() {
		
	}


	public Drone( boolean status, float longitude_location, float latitude_location, String type, float altitude,
			int batteryPercentage, List<Route> routes) {
		super();
		this.status = status;
		this.longitude_location = longitude_location;
		this.latitude_location = latitude_location;
		this.type = type;
		this.altitude = altitude;
		this.batteryPercentage = batteryPercentage;
		this.routes = routes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getLongitude_location() {
		return longitude_location;
	}

	public void setLongitude_location(float longitude_location) {
		this.longitude_location = longitude_location;
	}

	public float getLatitude_location() {
		return latitude_location;
	}

	public void setLatitude_location(float latitude_location) {
		this.latitude_location = latitude_location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}


	public List<Route> getRoutes() {
		return routes;
	}


	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	
	
	
}
