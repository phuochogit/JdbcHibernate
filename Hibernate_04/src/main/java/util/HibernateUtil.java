package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory  = buildSessionFactory();//sessionFactory API object connect between Java and MySQL.Image: https://www.bing.com/images/search?view=detailV2&ccid=MHdEcNzt&id=28FCC2B2496844FA766D871DAA06796C2198AD5A&thid=OIP.MHdEcNztjoq5aIi7kEHTGwHaFK&mediaurl=https%3A%2F%2Fwww.javatpoint.com%2Fimages%2Fhibernate%2Farchitecture.jpg&cdnurl=https%3A%2F%2Fth.bing.com%2Fth%2Fid%2FR.30774470dced8e8ab96888bb9041d31b%3Frik%3DWq2YIWx5Bqodhw%26pid%3DImgRaw%26r%3D0%26sres%3D1%26sresct%3D1%26srh%3D799%26srw%3D1148&exph=464&expw=666&q=sessionFactory+in+java&simid=607998508987660179&FORM=IRPRST&ck=C7B614D5299D31B87A473FE23144F85A&selectedIndex=9&itb=0&cw=855&ch=823&ajaxhist=0&ajaxserp=0. 

	private static SessionFactory buildSessionFactory() {
		try {//Use try catch because if this below command get an error. The following command still running, not stop immediately to avoid losing data.
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Error can not buildSessionFactory.");
			e.printStackTrace();//Show details about what went wrong.
		}
		return null;
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		getSessionFactory().close();
	}
	
}
