package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EnterpriseDetails {
	
	@Id
	@GeneratedValue(generator = "prefix-id-generator-enterprisedetails")
	@GenericGenerator(name = "prefix-id-generator-enterprisedetails", strategy = "util.PrefixIdGeneratorEnterpriseDetails") 
	@Column(length = 10)
	private String id;
	
	private String mobile;
	
	private String email;
	
	@Column(length = 1000)
	private String jd;
	
	private String address;

	@Column(length = 1000)
	private String description;
	
	private String avatar;

	public EnterpriseDetails() {
		super();
	}
	
	public EnterpriseDetails(String mobile, String email, String jd, String address, String description,
			String avatar) {
		super();
		this.mobile = mobile;
		this.email = email;
		this.jd = jd;
		this.address = address;
		this.description = description;
		this.avatar = avatar;
	}



	public EnterpriseDetails(String id, String mobile, String email, String jd, String address, String description,
			String avatar) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.email = email;
		this.jd = jd;
		this.address = address;
		this.description = description;
		this.avatar = avatar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJd() {
		return jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "EnterpriseDetails [id=" + id + ", mobile=" + mobile + ", email=" + email + ", jd=" + jd + ", address="
				+ address + ", description=" + description + ", avatar=" + avatar + "]";
	}
	
	
	
	
}

