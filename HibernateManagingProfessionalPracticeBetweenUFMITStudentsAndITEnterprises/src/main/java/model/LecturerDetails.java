package model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LecturerDetails {
	
	@Id
	@GeneratedValue(generator = "prefix-id-generator-lecturerdetails")
	@GenericGenerator(name = "prefix-id-generator-lecturerdetails", strategy = "util.PrefixIdGeneratorLecturerDetails") //custom auto-increment.
	@Column(length = 10)
	private String id;
	
	private String ethnicity;
	
	private String religion;
	
	private String country;
	
	private String province;
	
	private String districts;
	
	private String mobile;
	
	private String personalEmail;
	
	private String schoolEmail;
	
	private boolean sex;

	public LecturerDetails() {
		super();
	}

	public LecturerDetails(String ethnicity, String religion, String country, String province, String districts,
			String mobile, String personalEmail, String schoolEmail, boolean sex) {
		super();
		this.ethnicity = ethnicity;
		this.religion = religion;
		this.country = country;
		this.province = province;
		this.districts = districts;
		this.mobile = mobile;
		this.personalEmail = personalEmail;
		this.schoolEmail = schoolEmail;
		this.sex = sex;
	}



	public LecturerDetails(String id, String ethnicity, String religion, String country, String province,
			String districts, String mobile, String personalEmail, String schoolEmail, boolean sex) {
		super();
		this.id = id;
		this.ethnicity = ethnicity;
		this.religion = religion;
		this.country = country;
		this.province = province;
		this.districts = districts;
		this.mobile = mobile;
		this.personalEmail = personalEmail;
		this.schoolEmail = schoolEmail;
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistricts() {
		return districts;
	}

	public void setDistricts(String districts) {
		this.districts = districts;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "LecturerDetails [id=" + id + ", ethnicity=" + ethnicity + ", religion=" + religion + ", country="
				+ country + ", province=" + province + ", districts=" + districts + ", mobile=" + mobile
				+ ", personalEmail=" + personalEmail + ", schoolEmail=" + schoolEmail + ", sex=" + sex + "]";
	}
	
	
	
}
