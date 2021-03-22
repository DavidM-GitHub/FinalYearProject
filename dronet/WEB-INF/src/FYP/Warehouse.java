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
public class Warehouse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private float longitude_location;
	private float latitude_location;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Package> load=new ArrayList<Package>();
	
	public Warehouse() {
	
	}

	public Warehouse(float longitude_location, float latitude_location, List<Package> load) {
		super();
		this.longitude_location = longitude_location;
		this.latitude_location = latitude_location;
		this.load = load;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Package> getLoad() {
		return load;
	}

	public void setLoad(List<Package> load) {
		this.load = load;
	}

	
	
	
}
