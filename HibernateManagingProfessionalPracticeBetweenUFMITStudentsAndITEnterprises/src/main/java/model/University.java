package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	public University() {
		super();
	}
	
	public University(String name) {
		super();
		this.name = name;
	}



	public University(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UFM [id=" + id + ", name=" + name + "]";
	}
	
	
}
