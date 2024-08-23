package test;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.EnterprisesDAO;
import model.Enterprises;
import model.Enterprises;
import model.Students;
import util.HibernateUtil;

public class TestEnterprises {
public static void main(String[] args) {
//	Test insert.
	Enterprises Enterprises = new Enterprises("DotB");
	EnterprisesDAO.getInstance().insert(Enterprises);
//	Test update.
//	Enterprises Enterprises = new Enterprises(2021010258, "DOTB");//Long id so 2021010258 understand as Integer id so 2021010258 to understand as Long id.
//	EnterprisesDAO.getInstance().update(Enterprises);
//	Test delete.
//	Enterprises Enterprises = new Enterprises(2021010258);
//	EnterprisesDAO.getInstance().delete(Enterprises);
//	Test select all.
//	List<Enterprises> list = EnterprisesDAO.getInstance().selectAll();
//	for (Enterprises Enterprises : list) {
//		System.out.println(Enterprises.toString());
//	}
//	Test select by id.
//	Enterprises find = new Enterprises(2021010261);
//	Enterprises Enterprises = EnterprisesDAO.getInstance().selectById(find);
//	System.out.println(Enterprises.toString());
	
}
}
