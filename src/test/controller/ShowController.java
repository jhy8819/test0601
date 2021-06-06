package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.Service;
import test.vo.TestVO;

public class ShowController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Service service = Service.getInstance();
		ArrayList<TestVO> list = service.showSubject();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/showListOutput.jsp");
	}

}
