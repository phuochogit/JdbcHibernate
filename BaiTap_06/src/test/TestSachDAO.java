package test;

import java.util.Iterator;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
 public static void main(String[] args) {
//Test insert.
//	Sach sach1 = new Sach("LTJV","Lap trinh Java",50000,2025);
//	Sach sach2 = new Sach("LTC","Lap trinh C",70000,2030);
//	
//	SachDAO.getInstance().insert(sach2);//SachDao.getInstance.insert() instead of SachDao s = new SachDao(); s.insert();.
//	for (int i = 0; i < 1000; i++) {
//		Sach sach = new Sach("LT"+i,"Lap trinh i: "+i,20000,2015);
//		SachDAO.getInstance().insert(sach);
//	}
//Test update.
//	 Sach sach2 = new Sach("LTC","Lap trinh C",100000,2030);
//	 SachDAO.getInstance().update(sach2);
//Test delete.
	 for (int i = 0; i < 1000; i++) {
		 Sach sach = new Sach("LT"+i);
		 SachDAO.getInstance().delete(sach);
		
	}
 }
}
