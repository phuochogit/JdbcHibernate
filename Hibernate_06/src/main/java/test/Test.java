package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.MyOrder;
import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	
	if(sessionFactory!=null)
	{
		Session session = sessionFactory.openSession(); 
		
		Transaction tr = session.beginTransaction();
		
//		Customer customer= new Customer("1","Ho Thanh Phuoc","phuochowork@gmail.com");
//		
//		MyOrder order = new MyOrder("1", "TPHCM", customer);
//		
//		MyOrder order1 = new MyOrder("2", "TPHCM", customer);
//		
//		MyOrder order2 = new MyOrder("3", "TPHCM", customer);
//		
//		List<MyOrder> list = new ArrayList<>();
//		
//		list.add(order);
//		
//		list.add(order1);
//		
//		list.add(order2);
//		
////		customer.setOrders(list);
//		
//		session.save(customer);
//		
//		session.save(order);
//		
//		session.save(order1);
//		
//		session.save(order2);
//		
//		Customer customer1 = new Customer("2","Pham Thi Huyen Mi","phamthihuyenmi@gmail.com");
//		
//		session.save(customer1);
		
//		Select customers have orders.
		
		String hql = "from Customer c where size (c.orders) > 0";
		
		List<Customer> result = session.createQuery(hql).list();
		
		for (Customer rs : result) {
			
			System.out.println(rs);
			
		}
		
		tr.commit();//Detached. Linked to hibernate session and save to database.
		
		session.close();
	}
}
}


