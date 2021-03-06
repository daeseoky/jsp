package model.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.service.CommonService;

public class DeleteService implements CommonService{
	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String uid = req.getParameter("uid");
		
		UserDao.getInstance().deleteUser(uid);
			
		return "redirect:/jspStudy/Sub08/user/list.do";
		
	}

}
