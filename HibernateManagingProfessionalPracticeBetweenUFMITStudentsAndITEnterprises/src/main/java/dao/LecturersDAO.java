package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.LecturerDetails;
import model.Lecturers;
import model.LecturerDetails;
import model.Lecturers;
import util.HibernateUtil;

public class LecturersDAO implements DAOInterface<Lecturers> {

	public static LecturersDAO getInstance() {
		return new LecturersDAO();
	}
	
	@Override
	public boolean insert(Lecturers t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				session.save(t);
				
				tr.commit();
				
				session.close();
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Lecturers t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				session.update(t);
				
				tr.commit();
				
				session.close();
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Lecturers t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				session.delete(t);
				
				tr.commit();
				
				session.close();
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Lecturers> selectAll() {
		List<Lecturers> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from Lecturers";
				
				Query query = session.createQuery(hql);
				
				list = query.getResultList();
				
				tr.commit();//Run session.
				
				session.close();
			}
			else
			{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();//Show detail for the error.
		}
		return list;
	}

	@Override
	public Lecturers selectById(Lecturers t) {
		List<Lecturers> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from Lecturers where id = :id";
				
				
				Query query = session.createQuery(hql);
				
				query.setParameter("id", t.getId());
				
				list = query.getResultList();
				
				tr.commit();
				
				session.close();
			}
			else
			{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();//Show detail for the error.
		}
		if(list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public void setLecturerDetails(Lecturers lecturers, LecturerDetails lecturerDetails) {
		/*Goal: Set Lecturer_details_id for Lecturers.

		 *Required: Transient, Persistent, Detached.
		 
		 *Transient: new object() not linked to hibernate session.
		 
		 *Persistent: new object() linked to hibernate session.
		 
		 *Detached: new object() linked to hibernate session and linked to database.
		 
		 *Parameters: Lecturers, Lecturers Details.
		 
		 *Return: void.
		 */
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				lecturers.setLecturerDetails(lecturerDetails);
				
				session.saveOrUpdate(lecturers);//If record exist, update record.
				
				tr.commit();
				
				session.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
