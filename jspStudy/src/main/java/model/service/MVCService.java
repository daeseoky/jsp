package model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCService implements CommonService {
	
	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		// view ������ ��� ����
		return "/Sub08/2.MVC.jsp";
	}

}
