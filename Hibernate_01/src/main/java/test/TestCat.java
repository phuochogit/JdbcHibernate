package test;



import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
public static void main(String[] args) {
	try {
		SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
		if(sessionFactory!=null)
		{
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();//Transaction is push the data from Java to MySQL.For example: Java Cat.class {id = 1, name = Tom} -> MySQL Cat table id = 1, name = "Tom". 
				Cat cat2 = new Cat();
				cat2.setName("Jerry");
				cat2.setSex(true);
				cat2.setDob(Date.valueOf("2024-08-16"));
				session.save(cat2);//Not save in to database.
				tr.commit();//Save into database.
			} finally {
				session.close();
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
