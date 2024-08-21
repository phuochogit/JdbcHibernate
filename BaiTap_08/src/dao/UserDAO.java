package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;
import model.User;

public class UserDAO implements DAOInterface<User>{

	public static UserDAO getInstance()//UserDao().getInstance().insert(); instead of UserDAO() s = new UserDAO(); s.insert();.
	{
		return new UserDAO();
	}
	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {//Su dung try catch de neu bi loi thi cac doan code ben duoi se tiep tuc thuc hien, tranh viec dung chuong trinh dot ngot. Lam mat du lieu.Ví dụ Momo đang chuyển tiền mua bánh mì từ momo qua ngân hàng mbbank. Nếu kết nối của momo qua mbbank bị lỗi thì các đoạn code bên dưới sẽ tiếp tục thực hiện, tránh việc dừng ứng dụng đột ngột làm mất dữ liệu. 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "INSERT INTO User (username, password, hovaten) "
					  + "VALUES(?, ?, ?);";//?, ?, ? Là gì? Giống như viết một phương thức  chương trình biên dịch phương thức này sau đó truyền đầu vào parameter vào lúc đó không phải là cộng chuỗi("+t.getId()+"','"+t.getTenSach()+") nữa mà những cái gì mà truyền vào liên quan đến câu lệnh sql sẽ bị chặn.Vậy nên cần set value đầu vào parameter cho các dấu ?. Tóm lại INSERT INTO User (username, password, hovaten) VALUES (?,?,?) là phương thức có tham số đầu vào là username, password, hovaten. Vì vậy, nếu cần thêm giá trị cho tham số đầu vào ta dùng index, giá trị tham số(VD:1,"u1" là tham số thứ nhất username với giá trị là 1 hay username = 1). Không dùng cộng chuỗi("+t.getId()+"','"+t.getTenSach()+") vì vô câu lệnh String sql t.getId() sẽ biến thành chuỗi text chứ không phải là phương thức. Nó sẽ không hiểu chuỗi text này là gì và dẫn đến lỗi. 
			
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHovaten());
			
			//Buoc 3: Thuc thi cau lenh sql.
			
			
			ketQua = pst.executeUpdate();//Tra ve so luong dong thay doi.
			
			//Buoc 4: Xu ly ket qua.
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ketQua+ " dong bi thay doi");
			
			//Buoc 5: Ngat ket noi. Vi du mua hang bach hoa xanh, tinh tien xong phai roi di tuc ngat ket noi, de nguoi tiep theo co the duoc tiep tuc tinh tien.
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "UPDATE User"
					  + " SET"
					  	+ " password=?" 
					  	+ ", hovaten=?"
					  + " WHERE"
					  	+ " username =?;"; 
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			pst.setString(1, t.getPassword());
			pst.setString(2,t.getHovaten());
			pst.setString(3, t.getUsername());
			//Buoc 3: Thuc thi cau lenh sql.
			
			System.out.println(sql);
			
			ketQua = pst.executeUpdate();//Tra ve so luong dong thay doi.
			
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
	public int delete(User t) {
		int ketQua = 0;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "DELETE FROM User"		  
					  + " WHERE"
					  	+ " username = ?;";
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			pst.setString(1,t.getUsername());
			
			//Buoc 3: Thuc thi cau lenh sql.
			
			System.out.println(sql);
			
			ketQua = pst.executeUpdate();//Tra ve so luong dong thay doi.
			
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
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "SELECT * FROM User;";
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			
			//Buoc 3: Thuc thi cau lenh sql.
			
			System.out.println(sql);
			
			ResultSet rs = pst.executeQuery();//Saved data get from database into ResultSet.
			//excuteQuery là câu lệnh lấy dữ liệu từ csdl MySQL và đưa lên chương trình console Java. ResultSet is a table of data representing a database result set, which is usually generated by executing a statement that queries the database.
			
			//Buoc 4: Xu ly ket qua.
			while(rs.next())//next() get first row in result set table, then second, and so on. Return true if data still have, return false if out of data.
			{
				String username = rs.getString("username");//Parameter columnLabel not columnIdex because if i create new column in database before id. The sequence of index will change, and it is affect on the result.  
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				
				User User = new User(username, password, hovaten);
				ketQua.add(User);//Appends the specified element to the end of this list.
				
			}
			//Buoc 5: Ngat ket noi. 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "SELECT * FROM User WHERE username = ?;";
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			pst.setString(1, t.getUsername());
			//Buoc 3: Thuc thi cau lenh sql.
			
			System.out.println(sql);
			
			ResultSet rs = pst.executeQuery();//Saved data get from database into ResultSet.
			//excuteQuery là câu lệnh lấy dữ liệu từ csdl MySQL và đưa lên chương trình console Java. ResultSet is a table of data representing a database result set, which is usually generated by executing a statement that queries the database.
			
			//Buoc 4: Xu ly ket qua.
			while(rs.next())//next() get first row in result set table, then second, and so on. Return true if data still have, return false if out of data.
			{
				String username = rs.getString("username");//Parameter columnLabel not columnIdex because if i create new column in database before id. The sequence of index will change, and it is affect on the result.  
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				ketQua = new User(username, password, hovaten);
				
			}
			//Buoc 5: Ngat ket noi. 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	private void selectByCondition() {
		// TODO Auto-generated method stub

	}
	public ArrayList<User> selectByConditionHovaten(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
		try { 
			//Buoc 1: Tao ket noi den csdl.
			Connection con = JDBCUtil.getConnection();
			
			//Buoc 2: Tao ra doi tuong statement.
			String sql = "SELECT * FROM user WHERE hovaten LIKE ?;";
			
			PreparedStatement pst = con.prepareStatement(sql);//Creates a Statement object for sendingSQL statements to the database.
			
			pst.setString(1, condition);
			
			//Buoc 3: Thuc thi cau lenh sql.
			
			System.out.println(sql);
			
			ResultSet rs = pst.executeQuery();//Saved data get from database into ResultSet.
			//excuteQuery là câu lệnh lấy dữ liệu từ csdl MySQL và đưa lên chương trình console Java. ResultSet is a table of data representing a database result set, which is usually generated by executing a statement that queries the database.
			
			//Buoc 4: Xu ly ket qua.
			while(rs.next())//next() get first row in result set table, then second, and so on. Return true if data still have, return false if out of data.
			{
				String username = rs.getString("username");//Parameter columnLabel not columnIdex because if i create new column in database before id. The sequence of index will change, and it is affect on the result.  
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				
				User User = new User(username, password, hovaten);
				ketQua.add(User);//Appends the specified element to the end of this list.
				
			}
			//Buoc 5: Ngat ket noi. 
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public ArrayList<User> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
