package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;
import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat>{

	public static CatDAO getInstance()
	{
		return new CatDAO();
	}
	@Override
	public List<Cat> selectAll() {
		List<Cat> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from Cat";
				
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
	public Cat selectById(Cat t) {
		List<Cat> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from Cat where id = :id";//:id to name parameter. Instead of relying on position parameter(?1) named paremeter (:id) for belowwing command setParameter("id") following the name of id (:id) that i have already defined.
				
				Query query = session.createQuery(hql);
				
				query.setParameter("id", t.getId());//"id" to get name for parameter.Instead of using position, using name because when change the order of column if use position, they will catch an error. If use name, they will based on the name and set paratemeter for that name, for example query.set parameter("id",t.getId()).Bind an argument value to a named parameter.Parameters:name parameter namevalue parameter valueReturns:the same query instanceThrows:IllegalArgumentException - if the parameter name doesnot correspond to a parameter of the query or ifthe argument is of incorrect type.
				
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
		
		if(list.size()>0)//If found id.
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public boolean insert(Cat t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				session.save(t);//If id 1 name Tom, add id 1 name Jerry. Return error.
				
//				session.saveOrUpdate(t);//If id 1 name Tom, add id 1 name Jerry. Return id 1 name Jerry.
				
				//Conclusion: Now should use session.save() to avoid fix the records, turn out wrong data.
				
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
	public boolean update(Cat t) {
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
	public boolean delete(Cat t) {
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

}
