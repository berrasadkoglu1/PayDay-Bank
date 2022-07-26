
package net.codejava;

import javax.persistence.*;

@Entity
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	private String Name;

	private Long Price;

	private Boolean Available;

	@Column(nullable = false, length = 500)
	private String Description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getPrice() {
		return Price;
	}

	public void setPrice(Long price) {
		Price = price;
	}

	public Boolean getAvailable() {
		return Available;
	}

	public void setAvailable(Boolean available) {
		Available = available;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}