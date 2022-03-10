package model.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.service.CommonService;
import vo.UserVo;

public class ModifyService implements CommonService{
	
	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			//GET ��û
			String uid = req.getParameter("uid");
			UserVo user = UserDao.getInstance().selectUser(uid);
			
			req.setAttribute("user", user);
			
		return "/Sub08/user/modify.jsp";
		}else {
			// Post ��û
			String uid = req.getParameter("uid");
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String age = req.getParameter("age");
			
			UserVo vo = new UserVo();
			vo.setUid(uid);
			vo.setName(name);
			vo.setHp(hp);
			vo.setAge(age);
			
			UserDao.getInstance().updateUser(vo);
			
			return "redirect:/jspStudy/Sub08/user/list.do";
		}
	}

}
