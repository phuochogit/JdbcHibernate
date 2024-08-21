package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{
	public static KhachHangDAO getInstance()
	{
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "INSERT INTO khachhang(hoVaTen, ngaySinh, diaChi) "
						  + "VALUES('"+t.getHoVaTen()+"','"+t.getNgaySinh()+"','"+t.getDiaChi()+"');";
			
			ketQua = st.executeUpdate(sql);//Tra ve so luong dong thay doi.
			
			//Buoc 4: Xu ly ket qua.
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ketQua+ " dong bi thay doi");
			
			//Buoc 5: Ngat ket noi. Vi du mua hang bach hoa xanh, tinh tien xong phai roi di tuc ngat ket noi, de nguoi tiep theo co the duoc tiep tuc tinh tien.
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "UPDATE khachhang"
						  + " SET"
						  	+ " diaChi='"+t.getDiaChi()+"'"
						  + " WHERE"
						  	+ " hoVaTen = '"+t.getHoVaTen()+"'"+";";
			System.out.println(sql);
			
			ketQua = st.executeUpdate(sql);
			
			//Buoc 4: Xu ly ket qua.
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ketQua+ " dong bi thay doi");
			
			//Buoc 5: Ngat ket noi. 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "DELETE FROM khachhang"		  
						  + " WHERE"
						  	+ " hoVaTen = '"+t.getHoVaTen()+"'"+";";
			System.out.println(sql);
			
			ketQua = st.executeUpdate(sql);//Tra ve so luong dong thay doi.
			
			//Buoc 4: Xu ly ket qua.
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ketQua+ " dong bi thay doi");
			
			//Buoc 5: Ngat ket noi. 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
