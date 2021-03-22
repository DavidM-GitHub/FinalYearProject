package FYP; 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@NamedQueries({
	@NamedQuery(name="DroneFlight.findAll", query="select o from DroneFlight o"), 
	@NamedQuery(name = "DroneFlight.findById", query = "select o from DroneFlight o where o.id=:id"),
})

@Entity
@XmlRootElement(name = "droneflight")
public class DroneFlight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double currentLongitude;
	private double currentLatitude;
	private String altitude;
	private int batteryPercentage;
	private String duration;
	private int numWaypoints;


	public DroneFlight() {
		
	}


	

	public DroneFlight(double currentLongitude, double currentLatitude, String altitude, int batteryPercentage,
			String duration, int numWaypoints) {
		super();
		this.currentLongitude = currentLongitude;
		this.currentLatitude = currentLatitude;
		this.altitude = altitude;
		this.batteryPercentage = batteryPercentage;
		this.duration = duration;
		this.numWaypoints = numWaypoints;
	}



	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@XmlElement
	public double getCurrentLongitude() {
		return currentLongitude;
	}




	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}



	@XmlElement
	public double getCurrentLatitude() {
		return currentLatitude;
	}




	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}



	@XmlElement
	public String getAltitude() {
		return altitude;
	}




	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}



	@XmlElement
	public int getBatteryPercentage() {
		return batteryPercentage;
	}




	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}



	@XmlElement
	public String getDuration() {
		return duration;
	}




	public void setDuration(String duration) {
		this.duration = duration;
	}



	@XmlElement
	public int getNumWaypoints() {
		return numWaypoints;
	}




	public void setNumWaypoints(int numWaypoints) {
		this.numWaypoints = numWaypoints;
	}

	

	
	
	
}