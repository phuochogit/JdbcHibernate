package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.StudentDetails;
import model.Students;
import util.HibernateUtil;
import jakarta.persistence.Query;

public class StudentsDAO implements DAOInterface<Students> {

	public static StudentsDAO getInstance()//SinhVienDAO.getInstance() instead of SinhVienDAO s = new SinhVienDAO(); s.getInstance();.
	{
		return new StudentsDAO();
	}
	
	@Override
	public boolean insert(Students t) {
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
	public boolean update(Students t) {
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
	public boolean delete(Students t) {
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
	public List<Students> selectAll() {
		List<Students> list = new ArrayList();
		try {//If catch the error, avoid stopping the program, if program stop, will lose data. The program still run for bellow command. Not losing data.
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();//Run the Factory.
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession();//Open session from factory. 
				
				Transaction tr = session.beginTransaction();//Prepare to run for session.
				
				String hql = "from Students";
				
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
	public Students selectById(Students t) {
		List<Students> list = new ArrayList();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
				
				String hql = "from Students where id = :id";
				
				
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

	public void setStudentDetails(Students students, StudentDetails studentDetails) {
		/*Goal: Set student_details_id for Students.

		 *Required: Transient, Persistent, Detached.
		 
		 *Transient: new object() not linked to hibernate session.
		 
		 *Persistent: new object() linked to hibernate session.
		 
		 *Detached: new object() linked to hibernate session and linked to database.
		 
		 *Parameters: Students, Students Details.
		 
		 *Return: void.
		 */
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null)
			{
				Session session = sessionFactory.openSession(); 
				
				Transaction tr = session.beginTransaction();
			
				students.setStudentDetails(studentDetails);
				
				session.saveOrUpdate(students);//If record exist, update record.
				
				tr.commit();
				
				session.close();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
