package test;

import java.util.ArrayList;
import java.util.Iterator;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
 public static void main(String[] args) {
	 //Test select all.
//	 ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//	 for (Sach sach : list) {
//		System.out.println(sach.toString());
//	}
	 //Test select by id.
	 Sach find = new Sach("");
	 Sach sach = SachDAO.getInstance().selectById(find);
	 System.out.println(sach.toString());
//	 
	 //Test select by condition.
//	 String condition= "giaBan > 70000"; //Loi?.
//	 ArrayList<Sach> list = SachDAO.getInstance().selectByCondition(condition);
//	 for (Sach sach : list) {
//		System.out.println(sach.toString());
//	}
	}
 }

