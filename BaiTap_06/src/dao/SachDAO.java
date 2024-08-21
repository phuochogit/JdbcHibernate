package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach>{

	public static SachDAO getInstance()//SachDao().getInstance().insert(); instead of SachDAO() s = new SachDAO(); s.insert();.
	{
		return new SachDAO();
	}
	@Override
	public int insert(Sach t) {
		int ketQua = 0;
		try {//Su dung try catch de neu bi loi thi cac doan code ben duoi se tiep tuc thuc hien, tranh viec dung chuong trinh dot ngot. Lam mat du lieu.Ví dụ Momo đang chuyển tiền mua bánh mì từ momo qua ngân hàng mbbank. Nếu kết nối của momo qua mbbank bị lỗi thì các đoạn code bên dưới sẽ tiếp tục thực hiện, tránh việc dừng ứng dụng đột ngột làm mất dữ liệu. 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "INSERT INTO sach(id, tenSach, giaBan, namXuatBan) "
						  + "VALUES('"+t.getId()+"','"+t.getTenSach()+"',"+t.getGiaBan()+","+t.getNamXuatBan()+");";
			
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
	public int update(Sach t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "UPDATE sach"
						  + " SET"
						  	+ " tenSach='"+t.getTenSach()+"'" 
						  	+ ", giaBan="+t.getGiaBan()
						  	+ ", namXuatBan="+t.getNamXuatBan()
						  + " WHERE"
						  	+ " id = '"+t.getId()+"'"+";";
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
	public int delete(Sach t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = con.createStatement();//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			String sql = "DELETE FROM sach"		  
						  + " WHERE"
						  	+ " id = '"+t.getId()+"'"+";";
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
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
