package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.EnterpriseDetails;
import model.Enterprises;
import model.LecturerDetails;
import model.Lecturers;
import model.Enterprises;
import model.Students;
import util.HibernateUtil;

public class EnterprisesDAO implements DAOInterface<Enterprises> {

	public static EnterprisesDAO getInstance() {
		return new EnterprisesDAO();
	}
	
	@Override
	public boolean insert (Enterprises t) {
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
	public boolean update(Enterprises t) {
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
	public boolean delete(Enterprises t) {
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
	public List<Enterprises> selectAll() {
		List<Enterprises> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from Enterprises";
				
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
	public Enterprises selectById(Enterprises t) {
		List<Enterprises> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from Enterprises where id = :id";
				
				
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
	
	
	public void setEnterpriseDetails(Enterprises enterprises, EnterpriseDetails enterpriseDetails) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				enterprises.setEnterpriseDetails(enterpriseDetails);
				
				session.saveOrUpdate(enterprises);//If record exist, update record.
				
				tr.commit();
				
				session.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
