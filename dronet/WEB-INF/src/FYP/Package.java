package FYP;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int number_of_items;
	private float weight;
	
	@OneToMany
	private List<Product> products=new ArrayList<Product>();
	//note
	@OneToOne
	private Drone drone;
	

	public Package() {
		
	}


	public Package( int number_of_items, float weight, List<Product> products, Drone drone) {
		super();
		this.number_of_items = number_of_items;
		this.weight = weight;
		this.products = products;
		this.drone = drone;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumber_of_items() {
		return number_of_items;
	}


	public void setNumber_of_items(int number_of_items) {
		this.number_of_items = number_of_items;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Drone getDrone() {
		return drone;
	}


	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	
	
	
}
