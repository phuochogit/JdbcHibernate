package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GiangVien {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-giangvien")//Set name for Long id;.
	@GenericGenerator(name = "prefix-id-generator-giangvien", strategy = "util.PrefixIdGeneratorGiangVien") //Use name of Long id and create prefixIdGenerator.
	private Long id;
	private String name;
	
	public GiangVien() {
		super();
	}
	
	public GiangVien(Long id) {
		super();
		this.id = id;
	}

	public GiangVien(String name) {
		super();
		this.name = name;
	}
	
	public GiangVien(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "GiangVien [id=" + id + ", name=" + name + "]";
	}
	
	

}
