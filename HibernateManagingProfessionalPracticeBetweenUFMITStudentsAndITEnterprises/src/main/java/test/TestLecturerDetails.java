package test;

import dao.LecturerDetailsDAO;
import dao.LecturersDAO;
import model.LecturerDetails;
import model.Lecturers;

public class TestLecturerDetails {
public static void main(String[] args) {
	
//	Test one to one.
	
	Lecturers Lecturers = new Lecturers("Ton That Hoa An");
	
	LecturersDAO.getInstance().insert(Lecturers);
	
	LecturerDetails LecturerDetails= new LecturerDetails("Kinh", "Không", "Vietnam", "Hồ Chí Minh", "Quận 1", "", "", "", true);
	
	LecturerDetailsDAO.getInstance().insert(LecturerDetails);
	
	LecturersDAO.getInstance().setLecturerDetails(Lecturers, LecturerDetails);
	
	System.out.println(Lecturers.toString());
	
}
}
