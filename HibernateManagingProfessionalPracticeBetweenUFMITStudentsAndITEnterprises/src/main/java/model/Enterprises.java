package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Enterprises {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-enterprises")//auto increment.
	@GenericGenerator(name = "prefix-id-generator-enterprises",strategy = "util.PrefixIdGeneratorEnterprises")//custom auto increment.
	private String id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)//?
	@JoinColumn(name = "enterprise_details_id")
	private EnterpriseDetails enterpriseDetails;
	
	public Enterprises() {
		super();
	}

	public Enterprises(String name) {
		super();
		this.name = name;
	}
	
	public Enterprises(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public EnterpriseDetails getEnterpriseDetails() {
		return enterpriseDetails;
	}

	public void setEnterpriseDetails(EnterpriseDetails enterpriseDetails) {
		this.enterpriseDetails = enterpriseDetails;
	}

	@Override
	public String toString() {
		return "Enterprises [id=" + id + ", name=" + name + ", enterpriseDetails=" + enterpriseDetails + "]";
	}

	
	

}
