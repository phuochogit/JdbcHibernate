package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;

	public Person() {
		super();
	}

	public Person(University university) {
		super();
		this.university = university;
	}

	public Person(Integer id, String name, University university) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", university=" + university + "]";
	}
	
	
	
}
