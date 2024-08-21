package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DoanhNghiep {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-doanhnghiep")//auto increment.
	@GenericGenerator(name = "prefix-id-generator-doanhnghiep",strategy = "util.PrefixIdGeneratorDoanhNghiep")//custom auto increment.
	private Long id;
	private String name;
	
	public DoanhNghiep() {
		super();
	}
	
	public DoanhNghiep(Long id) {
		super();
		this.id = id;
	}

	public DoanhNghiep(String name) {
		super();
		this.name = name;
	}
	
	public DoanhNghiep(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DoanhNghiep [id=" + id + ", name=" + name + "]";
	}
	

}
