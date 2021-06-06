package test.service;

import java.util.ArrayList;
import test.dao.TestDao;
import test.vo.TestVO;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private TestDao dao = TestDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public boolean login(String id, String pwd) {
		
		return dao.login(id,pwd);
	}
	public void enrollSubject(TestVO enroll) {
		// TODO Auto-generated method stub
		dao.enrollSubject(enroll);
	}
	public java.util.ArrayList<TestVO> showSubject() {
		// TODO Auto-generated method stub
		ArrayList <TestVO> list = dao.showSubject();
		return list;
	}
	public TestVO subjectSearch(String id) {
		// TODO Auto-generated method stub
		TestVO subject = dao.subjectSearch(id);
		return subject;
	}
	public void subjectUpdate(TestVO subject) {
		// TODO Auto-generated method stub
		dao.subjectUpdate(subject);
	}
	public String subjectUpdate(String id, String enrollment) {
		// TODO Auto-generated method stub
		return dao.subjectUpdate(id,enrollment);
	}
	
	
	
	
	
	
	
	
	
	
}
