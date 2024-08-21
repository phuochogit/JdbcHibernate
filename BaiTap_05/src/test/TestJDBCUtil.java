package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {

	public static void main(String[] args) {
		try {//Su dung try catch vi neu bi loi st = connection.createStatement() thi cac doan code ben duoi nhu excuteUpdate(sql) se van chay binh thuong khong bi dung chuong trinh dot ngot ngay tai dong st = connection.createStatement() dan den viec khong insert duoc du lieu. 
			// TODO Auto-generated method stub
			//Buoc 1: Tao ket noi.
			Connection connection = JDBCUtil.getConnection();
			//Buoc 2: Tao ra doi tuong statement.
			Statement st = connection.createStatement();
			//Buoc 3: Thuc thi mot cau lenh SQL.
			String sql = "INSERT INTO person (last_name,first_name,gender,dob, income)"
					+ "VALUES (\"Tran\",\"Thi C\",\"M\",\"2023-08-07\",15000000)";//Su dung dau "" thi can phai co \. Vi du \"Tran\" 
			int check = st.executeUpdate(sql);
			//Buoc 4: Xu ly ket qua.
			System.out.println("So dong thay doi: " + check);
			if(check>0)
				System.out.println("Them du lieu thanh cong");
			else
				System.out.println("Them du lieu that bai");
			//Buoc 5: Ngat ket noi.
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
