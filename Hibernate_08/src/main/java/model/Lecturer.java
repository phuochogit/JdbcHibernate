package model;

import javax.persistence.Entity;

@Entity
public class Lecturer extends Person{

	private String subject;

	public Lecturer() {
		super();
	}

	public Lecturer(String id, String name, String subject) {
		super(id,name);//id, name belong to parent class(Person).
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Lecturer [subject=" + subject + "]";
	}
	
	
}
