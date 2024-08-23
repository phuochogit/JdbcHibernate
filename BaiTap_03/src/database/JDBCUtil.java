package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCUtil {
	public static Connection getConnection()//static because JDBCUtil.getConnection() instead of non static JDBCUtil j = new JDBC(); j.getConnection().
	{
		/**
		 * aaa
		 */
		Connection c = null;
			//Cac thong so.
			String url = "jdbc:mySQL://localhost:3306/ontap";
			String user = "root";
			String password = "";
			//Tao ket noi.
			try {//Tại sao phải dùng try catch và e.printStackTrace()?Bởi vì nếu không sử dụng try catch trường hợp kết nối database bị lỗi thì chỉ hiển thị lỗi sql exception, không biết cụ thể là lỗi ở đâu. Còn nếu sử dụng try catch e.printstacktrace() sẽ hiển thị chi tiết cụ thể lỗi sai nằm ở đâu.
				c = DriverManager.getConnection(url,user,password); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return c;
	}
	
	 public static void closeConnection(Connection c)
	 {
		 try {
			if (c!=null)
				c.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	 }
	 
	 public static void printInfo(Connection c)
	 {
		 
		java.sql.DatabaseMetaData mtdt = null;
		if(c!=null)
			try {
				mtdt = c.getMetaData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
