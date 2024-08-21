package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Cat {
	private Integer id;
	private String name;
	private Date dob;
	private Boolean sex;

	public Cat() {
		super();
	}
	
	public Cat(Integer id) {
		super();
		this.id = id;
	}

	public Cat(String name, Date dob, Boolean sex) {
		super();
		this.name = name;
		this.dob = dob;
		this.sex = sex;
	}

	public Cat(Integer id, String name, Date dob, Boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
	}

	@Id//Use id in getter method because get the id in Java and put into table in database.
	
	@GeneratedValue
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", dob=" + dob + ", sex=" + sex + "]";
	}
	
}
