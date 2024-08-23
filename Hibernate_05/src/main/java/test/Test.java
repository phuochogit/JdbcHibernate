package test;

import java.sql.Date;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	
	if(sessionFactory!=null)
	{
		Session session = sessionFactory.openSession(); 
		
		Transaction tr = session.beginTransaction();
		
//		Author author = new Author("1","Nguyen Nhat Anh",Date.valueOf("2024-08-23"));
//		
//		Book book = new Book("1", "Mắt Biếc", 100000.0, author);
//		
//		Book book1 = new Book("2", "Tôi thấy hoa vàng trên cỏ xanh", 100000.0, author);
//		
//		Book book2 = new Book("3", "Bảy Bước Tới Mùa Hè ", 100000.0, author);
//		
//		session.save(author);//Persistent.Linked to hibernate session but not save to database.
//		
//		session.save(book);
//		
//		session.save(book1);
//		
//		session.save(book2);
		
//		Author author = new Author("2","Ho Thanh Phuoc",Date.valueOf("2002-08-30"));
//		
//		Book book = new Book("4", "Mình là hai nửa", 100000.0, author);
//		
//		Book book1 = new Book("5", "Tổng kết tết 2024", 100000.0, author);
//		
//		Book book2 = new Book("6", "Nếu phải xa nhau", 100000.0, author);
//		
//		session.save(author);//Persistent.Linked to hibernate session but not save to database.
//		
//		session.save(book);
//		
//		session.save(book1);
//		
//		session.save(book2);
		
		Book book = session.find(Book.class, "4");
		
		System.out.println("Author of book "+ book.getName()+ " is: " + book.getAuthor().getName());
		
		
		
		tr.commit();//Detached. Linked to hibernate session and save to database.
		
		session.close();
	}
}
}


