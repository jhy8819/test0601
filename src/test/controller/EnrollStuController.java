package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.service.Service;
import test.vo.TestVO;

public class EnrollStuController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subject = request.getParameter("subject");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service service = Service.getInstance();
		String enrollment = service.subjectUpdate(id,subject);
		
		request.setAttribute("enrollment", enrollment);
		HttpUtil.forward(request, response, "/menu1.jsp");
	}
}		
