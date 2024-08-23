package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Lecturer;
import model.Student;
import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	if(sessionFactory!=null)
	{
		Session session = sessionFactory.openSession(); 
		
		Transaction tr = session.beginTransaction();
		
		Lecturer lecturer = new Lecturer("gv1", "Ton That Hoa An", "Cloud Computing");
		
		Student student = new Student("sv1", "Ho Thanh Phuoc", 9.7);
		
		session.save(lecturer);
		
		session.save(student);
				
		tr.commit();//Detached. Linked to hibernate session and save to database.
		
		session.close();
	}
}
}


