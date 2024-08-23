package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	private String id;
	
	private String name;
	
	private Date dob;

	public Author() {
		super();
	}

	public Author(String id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
	
}
