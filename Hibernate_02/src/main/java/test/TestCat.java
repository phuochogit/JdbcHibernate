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
// 	Test select all.
//	List<Cat> list = CatDAO.getInstance().selectAll();
//	for (Cat cat : list) {
//		System.out.println(cat.toString());
//	}
//	Test select by id.
//	Cat find = new Cat(4);
//	Cat cat = CatDAO.getInstance().selectById(find);
//	System.out.println(cat.toString());
//	Test insert.
//	Cat cat = new Cat("Tom",Date.valueOf("2020-01-01"),true);
//	CatDAO.getInstance().insert(cat);
//	Test update.
//	Cat cat = new Cat(1, "Tom", Date.valueOf("2020-01-01"), false);
//	CatDAO.getInstance().update(cat);
//	Test delete.
//	Cat cat = new Cat(9);
//	CatDAO.getInstance().delete(cat);
}
}
