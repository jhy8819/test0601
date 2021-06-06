package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.HttpUtil;
import test.service.Service;
import test.vo.TestVO;

public class Enroll1Controller implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String path = null;
		
		if(job.equals("search"))
			path = "/search.jsp";
		else if(job.equals("update"))
			path="/enroll1.jsp";
		
		
		
		Service service = Service.getInstance();
		TestVO subject = service.subjectSearch(id);
		
		request.setAttribute("subject", subject);
		if(job.equals("search")) path="/result/subjectSearchOutput.jsp";
		HttpUtil.forward(request, response, path);
	}
}
