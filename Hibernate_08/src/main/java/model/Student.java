package model;

import javax.persistence.Entity;

@Entity
public class Student extends Person{

	private double score;

	public Student() {
		super();
	}

	public Student(String id, String name, double score) {
		super(id,name);
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [score=" + score + "]";
	}
	
}
