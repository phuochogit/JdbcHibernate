package test;

import dao.UserDAO;
import java.util.ArrayList;
import model.User;

public class TestUserDAO {
public static void main(String[] args) {
	//Test prepared statement insert.
//	User u2 = new User("u2","u234","UUU2");
//	UserDAO.getInstance().insert(u2);
	
	//Test prepared statement update.
//	User u2 = new User("u2","u234","UUU2updatewithsemicolon");
//	UserDAO.getInstance().update(u2);
	
	//Test prepared statement delete.
//	User u2 = new User("u2");
//	UserDAO.getInstance().delete(u2);
	
	//Test prepared statement select all.
//	ArrayList<User> list = UserDAO.getInstance().selectAll();
//	 for (User user : list) {
//		System.out.println(user.toString());
//	}
	//Test prepared statement select by id.
	
//	User u_find = new User("u1","u123","UUU");
//	User u_result = UserDAO.getInstance().selectById(u_find);
//	System.out.println(u_result);
	
//	User find = new User("","","");
////'or 1=1;-- 
//	User find1 = new User("'or 1=1;-- ");
//	User user = UserDAO.getInstance().selectById(find1);
//	System.out.println(user.toString());
	
	
	 String condition= "UUU%"; //Loi?.
	 ArrayList<User> list = UserDAO.getInstance().selectByConditionHovaten(condition);
	 for (User user : list) {
		System.out.println(user.toString());
	}

	
	
}
}
