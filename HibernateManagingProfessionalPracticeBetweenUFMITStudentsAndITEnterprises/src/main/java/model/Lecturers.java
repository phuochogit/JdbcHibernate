package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Lecturers {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-lecturers")//Set name for Integer id;.
	@GenericGenerator(name = "prefix-id-generator-lecturers", strategy = "util.PrefixIdGeneratorLecturers") //Use name of Integer id and create prefixIdGenerator.
	private Integer id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lecturer_details_id")
	private LecturerDetails lecturerDetails;
	
	public Lecturers() {
		super();
	}
	
	
	public Lecturers(Integer id) {
		super();
		this.id = id;
	}

	public Lecturers(String name) {
		super();
		this.name = name;
	}
	
	public Lecturers(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "GiangVien [id=" + id + ", name=" + name + "]";
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


	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
