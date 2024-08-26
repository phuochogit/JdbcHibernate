package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Lecturers {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-lecturers")//Set name for String id;.
	@GenericGenerator(name = "prefix-id-generator-lecturers", strategy = "util.PrefixIdGeneratorLecturers") //Use name of String id and create prefixIdGenerator.
	@Column(length = 10)
	private String id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lecturer_details_id")
	private LecturerDetails lecturerDetails;
	
	public Lecturers() {
		super();
	}
	
	
	public Lecturers(String name) {
		super();
		this.name = name;
	}

	
	public Lecturers(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LecturerDetails getLecturerDetails() {
		return lecturerDetails;
	}


	public void setLecturerDetails(LecturerDetails lecturerDetails) {
		this.lecturerDetails = lecturerDetails;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Lecturers [id=" + id + ", name=" + name + ", lecturerDetails=" + lecturerDetails + "]";
	}
	
	

}
