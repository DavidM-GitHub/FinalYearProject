package FYP;

import javax.persistence.Entity; 

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name="Product.findAll", query="select o from Product o"), 
	@NamedQuery(name = "Product.findById", query = "select o from Product o where o.id=:id"),
})

@Entity
@XmlRootElement(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String image;
	private int price;
	private int stock;
	
	public Product() {
		
	}

	public Product( String name, String image, int price,int stock) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.stock=stock;
	}

 

	@XmlElement
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@XmlElement
	public int getId() {
		return id;
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
	@XmlElement
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	@XmlElement
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
}
