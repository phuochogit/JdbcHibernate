package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Meeting;
import model.Staff;
import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	if(sessionFactory!=null)
	{
		Session session = sessionFactory.openSession(); 
		
		Transaction tr = session.beginTransaction();
		
		Staff staff = new Staff("1", "Ho Thanh Phuoc", Date.valueOf("2002-08-30"));
		
		session.save(staff);
		
		Meeting meeting = new Meeting("Scientific Research ", "MSTeams", new Date(2024, 8, 23));
		
		meeting.addStaff(staff);
		
		session.save(meeting);
				
		tr.commit();//Detached. Linked to hibernate session and save to database.
		
		session.close();
	}
}
}


