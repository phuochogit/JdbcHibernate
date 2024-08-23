package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Meeting {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String address;
	
	private Date date;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "meeting_staff",
				joinColumns = {@JoinColumn (name = "meeting_id")},//The foreign key columnsof the join table which reference theprimary table of the entity owning the association.
				inverseJoinColumns = {@JoinColumn(name="staff_id")}// The foreign key columnsof the join table which reference theprimary table of the entity that doesnot own the association.
			)
	private Set<Staff> listStaff= new HashSet<Staff>();//Set unique. HashSet random.
	
	
	public Meeting() {
		super();
	}

	public Meeting(String name, String address, Date date) {
		super();
		this.name = name;
		this.address = address;
		this.date = date;
	}

	public Meeting(Integer id, String name, String address, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.date = date;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + "]";
	}

	public void addStaff(Staff staff) {
		this.listStaff.add(staff);

	}
	
}
	
	
