package test;

import java.sql.Date;
import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {

	public static void main(String[] args) {
		//Test select all.
//		 ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
//		 for (KhachHang khachhang : list) {
//			System.out.println(khachhang.toString());
//		}
		//Test select by hoVaTen.
//		KhachHang find = new KhachHang("Ho Thanh Phuoc");
//		KhachHang khachhang = KhachHangDAO.getInstance().selectByHovaten(find);
//		System.out.println(khachhang.toString());
		//Test select by condition.
		 String condition= "diaChi = 'HCM'"; //Loi?.
		 ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectByCondition(condition);
		 for (KhachHang khachhang : list) {
			System.out.println(khachhang.toString());
		}
	}
	

}
