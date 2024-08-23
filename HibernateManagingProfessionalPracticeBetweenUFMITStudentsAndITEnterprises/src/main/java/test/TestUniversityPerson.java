package test;

import dao.PersonDAO;
import dao.UniversityDAO;
import model.Person;
import model.University;

public class TestUniversityPerson {
	public static void main(String[] args) {
		
		University university= new University("University of Finance and Marketing");
		
		UniversityDAO.getInstance().insert(university);
		
		Person person = new Person(university);
		
		PersonDAO.getInstance().insert(person);
		
	}
}
