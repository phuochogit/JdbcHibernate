package test;

import dao.StudentDetailsDAO;
import dao.StudentsDAO;
import model.StudentDetails;
import model.Students;

public class TestStudentDetails {
public static void main(String[] args) {
	
//	Test one to one.
	
	Students students = new Students("Ho Thanh Phuoc");
	
	StudentsDAO.getInstance().insert(students);
	
	StudentDetails studentDetails= new StudentDetails("Kinh", "Không", "Vietnam", "Tỉnh Phú Yên", "Thị xã Sông Cầu", "0812665018", "phuochowork@gmail.com", "2021010258@sv.ufm.edu.vn", true);
	
	StudentDetailsDAO.getInstance().insert(studentDetails);
	
	StudentsDAO.getInstance().setStudentDetails(students, studentDetails);
	
	System.out.println(students.toString());
	
}
}
