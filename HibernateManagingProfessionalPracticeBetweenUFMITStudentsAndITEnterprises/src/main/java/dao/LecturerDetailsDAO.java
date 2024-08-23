package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.LecturerDetails;
import model.LecturerDetails;
import util.HibernateUtil;
import jakarta.persistence.Query;

public class LecturerDetailsDAO implements DAOInterface<LecturerDetails> {

	public static LecturerDetailsDAO getInstance()//SinhVienDAO.getInstance() instead of SinhVienDAO s = new SinhVienDAO(); s.getInstance();.
	{
		return new LecturerDetailsDAO();
	}
	
	@Override
	public boolean insert(LecturerDetails t) {
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
	public boolean update(LecturerDetails t) {
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
	public boolean delete(LecturerDetails t) {
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
	public List<LecturerDetails> selectAll() {
		List<LecturerDetails> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from LecturerDetails";
				
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
	public LecturerDetails selectById(LecturerDetails t) {
		List<LecturerDetails> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from LecturerDetails where id = :id";
				
				
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
			e.printStackTrace();
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

}
