package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import model.GiangVien;
import model.SinhVien;
import util.HibernateUtil;

public class GiangVienDAO implements DAOInterface<GiangVien> {

	public static GiangVienDAO getInstance() {
		return new GiangVienDAO();
	}
	
	@Override
	public boolean insert(GiangVien t) {
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
	public boolean update(GiangVien t) {
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
	public boolean delete(GiangVien t) {
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
	public List<GiangVien> selectAll() {
		List<GiangVien> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from GiangVien";
				
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
	public GiangVien selectById(GiangVien t) {
		List<GiangVien> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from GiangVien where id = :id";
				
				
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

}
