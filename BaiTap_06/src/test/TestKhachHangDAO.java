package test;

import java.sql.Date;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {

	public static void main(String[] args) {
//Test insert.
//		KhachHang khachhang = new KhachHang("Nguyen Van A",Date.valueOf("2024-08-09"),"HCM");
//		KhachHangDAO.getInstance().insert(khachhang);
//Test update.
//		KhachHang khachhang = new KhachHang("Nguyen Van A", "HN");
//		KhachHangDAO.getInstance().update(khachhang);
//Test delete.
		KhachHang khachhang = new KhachHang("Nguyen Van A");
		KhachHangDAO.getInstance().delete(khachhang);
	}

}
