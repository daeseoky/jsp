package model.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.service.CommonService;
import vo.MemberVo;

public class ModifyService implements CommonService{
	
	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
			//GET 요청
			String uid = req.getParameter("uid");
			MemberVo user = MemberDao.getInstance().selectUser(uid);
			
			req.setAttribute("user", user);
			
		return "/Sub08/member/modify.jsp";
		}else {
			// Post 요청
			String uid = req.getParameter("uid");
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String pos = req.getParameter("pos");
			String dep = req.getParameter("dep");
			
			MemberVo vo = new MemberVo();
			vo.setUid(uid);
			vo.setName(name);
			vo.setHp(hp);
			vo.setPos(pos);
			vo.setDep(dep);
			
			MemberDao.getInstance().updateUser(vo);
			
			return "redirect:/jspStudy/Sub08/member/list.do";
		}
	}

}
