package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {//Generic java giống với template trong c++ tức viết một hàm và tất cả các kiểu dữ liệu có thể dùng được.Ví dụ trong ta có hàm tính toán trong c++ thì hàm này nhận tham số đầu vào là kiểu dữ liệu số nguyên hoặc số thực đều được, và trả về là số nguyên hoặc số thực đều được. Minh họa template <class T>; T tinhtoan(T a, T b). 
	
	public int insert(T t);//static because DAOInterface.insert(); instead of DAOInterface d = new DAOInterface(); d.insert();.
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
	public ArrayList<T> selectByCondition(String condition);
	
}
