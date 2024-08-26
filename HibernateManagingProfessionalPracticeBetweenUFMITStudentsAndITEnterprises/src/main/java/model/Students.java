package model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentifierGenerator;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity //Entity here mark as table in MySQL.
public class Students {
	@Id
	@GeneratedValue (generator = "prefix-id-generator-students")// generator: The name of the primary key generator to use as specified in the SequenceGenerator or TableGenerator annotation. 
	@GenericGenerator(name = "prefix-id-generator-students",strategy = "util.PrefixIdGeneratorStudents")// Name: The name of the identifier generator. This is the name that may be specified by the generator member of the @GeneratedValue annotation, for example:generator = "prefix-id-generator". Strategy: specifies the strategy or class name for generating identifiers, for example class PrefixIdGenerator implements IdentifierGenerator.
	@Column(length = 10)
	private String id;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_details_id")
	private StudentDetails studentDetails;
	
	public Students() {
		super();
	}

	public Students(String name) {
		super();
		this.name = name;
	}

	public Students(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Students(String name, StudentDetails studentDetails) {
		super();
		this.name = name;
		this.studentDetails = studentDetails;
	}

	public Students(String id, String name, StudentDetails studentDetails) {
		super();
		this.id = id;
		this.name = name;
		this.studentDetails = studentDetails;
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

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public StudentDetails setStudentDetails(StudentDetails studentDetails) {
		return this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", studentDetails=" + studentDetails + "]";
	}

	
	
	
	
	
}
