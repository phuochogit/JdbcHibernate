package test;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat {
public static void main(String[] args) {
	Cat cat = new Cat("Meo Long Xu",new Date(System.currentTimeMillis()),true);//Transient.
	try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory!=null)
		{
			Session session = sessionFactory.openSession(); 
			
			Transaction tr = session.beginTransaction();
			
			session.save(cat);//Persistent.
					
			tr.commit();//Detached.
			
			session.refresh(cat);//Detached to Persistent.
			
			session.close();
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
