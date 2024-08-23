package test;

import java.sql.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	Person ban = new Person("Ho Van Ban", Date.valueOf("1965-10-20"),null);//Transient.Not linked to Hibernate Session in java.
	
	Person dung = new Person("Nguyen Thi Phu Dung", Date.valueOf("1967-01-13"),null);
	
	if(sessionFactory!=null)
	{
		Session session = sessionFactory.openSession(); 
		
		Transaction tr = session.beginTransaction();
		
		ban.setSpouse(dung);
		
		dung.setSpouse(ban);
		
		session.save(ban);//Persistent.Linked to hibernate session but not save to database.
		
		session.save(dung);
		
		tr.commit();//Detached. Linked to hibernate session and save to database.
		
		session.close();
	}
}
}


