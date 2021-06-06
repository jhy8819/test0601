package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.Service;
import test.vo.TestVO;

public class EnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String count = request.getParameter("count");
		String prof = request.getParameter("prof");
		
		TestVO enroll = new TestVO();
		enroll.setId(id);
		enroll.setTitle(title);
		enroll.setCount(count);
		enroll.setProf(prof);
		
		Service service = Service.getInstance();
		service.enrollSubject(enroll);
		
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "menu.jsp");
	}

}
