package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Staff {
	
	@Id
	private String id;
	
	private String name;
	
	private Date dob;
	
	@ManyToMany(mappedBy = "listStaff")//Reference from Meeting.java have Meeting_Staff(meeting_id,staff_id).
	private Set<Meeting> listStaff= new HashSet<Meeting>();

	public Staff() {//Staff.java into table staff through hibernate, need this.
		super();
	}

	public Staff(String id, String name, Date dob) {
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
		return "Staff [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	
}
