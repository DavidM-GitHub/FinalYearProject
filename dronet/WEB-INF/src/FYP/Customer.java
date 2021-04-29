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
	@NamedQuery(name="Customer.findAll", query="select o from Customer o"), 
	@NamedQuery(name = "Customer.findById", query = "select o from Customer o where o.id=:id"),
	@NamedQuery(name = "Customer.findByEmail", query = "select o from Customer o where o.email=:email")
})

@Entity
@XmlRootElement(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;	
	private String longitude;
	private String latitude;
	
	
	String admin;
	
	public Customer() {
		
	}
	
	
 
	public Customer(String name, String email, String password,String admin) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.admin=admin;
	}



	public String getAdmin() {
		return admin;
	}


	@XmlElement
	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	@XmlElement
	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	@XmlElement
	public int getId() {
		return id;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", longitude="
				+ longitude + ", latitude=" + latitude ;
	}



	public void setAdmin(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
