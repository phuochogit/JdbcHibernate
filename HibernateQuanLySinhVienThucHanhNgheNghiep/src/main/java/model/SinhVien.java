package model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentifierGenerator;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Entity here mark as table in MySQL.
public class SinhVien {
	@Id
	@GeneratedValue(generator = "prefix-id-generator-sinhvien")// generator: The name of the primary key generator to use as specified in the SequenceGenerator or TableGenerator annotation. 
	@GenericGenerator(name = "prefix-id-generator-sinhvien", strategy = "util.PrefixIdGeneratorSinhVien")// Name: The name of the identifier generator. This is the name that may be specified by the generator member of the @GeneratedValue annotation, for example:generator = "prefix-id-generator". Strategy: specifies the strategy or class name for generating identifiers, for example class PrefixIdGenerator implements IdentifierGenerator.
	private Long id;
	private String name;
	
	public SinhVien() {
		super();
	}
	
	public SinhVien(Long id) {
		super();
		this.id = id;
	}

	public SinhVien(String name) {
		super();
		this.name = name;
	}

	public SinhVien(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
