package test;

import dao.EnterpriseDetailsDAO;
import dao.EnterprisesDAO;
import model.EnterpriseDetails;
import model.Enterprises;

public class TestEnterpriseDetails {
public static void main(String[] args) {
	
//	Test one to one.
	
	Enterprises Enterprises = new Enterprises("Công Ty Cổ Phần Fujinet Systems");
	
	EnterprisesDAO.getInstance().insert(Enterprises);
	
	EnterpriseDetails EnterpriseDetails= new EnterpriseDetails("02838477000", "info@fujinet.net", "Lập trình với Java như: Java Core, JSP Servlet, Struts, Spring MVC, Spring Boot.", "Waseco Building – Floor 9 – Block C, 10 Phổ Quang, Phường 2, Quận Tân Bình", "Phát triển và xuất khẩu phần mềm: Lập trình, vận hành và bảo trì hệ thống nghiệp vụ, lập trình Web Application, lập trình Smart Phone Application.", "https://drive.google.com/drive/folders/1tB1avtqfxryd7inGLJ2g-TO9UzKD8U_Z");
	
	EnterpriseDetailsDAO.getInstance().insert(EnterpriseDetails);
	
	EnterprisesDAO.getInstance().setEnterpriseDetails(Enterprises, EnterpriseDetails);
	
	System.out.println(Enterprises.toString());
	
	
	
}
}
