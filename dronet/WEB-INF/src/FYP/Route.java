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
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int waypoints;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Customer> customers=new ArrayList<Customer>();
	
	public Route() {
		
	}

	public Route(int waypoints, List<Customer> customers) {
		super();
		this.waypoints = waypoints;
		this.customers = customers;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(int num_of_waypoints) {
		this.waypoints = num_of_waypoints;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	
}
