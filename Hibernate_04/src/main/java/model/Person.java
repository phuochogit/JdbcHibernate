package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_person")
public class Person {
	
	 @Id
	 @GeneratedValue
	 private long id;
	 
	 private String name;
	 
	 private Date dob;
	 
	 @OneToOne(cascade = CascadeType.ALL)//?
	 @JoinColumn(name = "spouse_id")//Foreign key.
	 private Person spouse;
	 
	 public Person() {
		super();
	 }

	public Person(String name, Date dob, Person spouse) {
		super();
		this.name = name;
		this.dob = dob;
		this.spouse = spouse;
	}

	public Person(long id, String name, Date dob, Person spouse) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.spouse = spouse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", spouse=" + spouse + "]";
	}
	 
	
	 
}
