package model.service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.service.CommonService;
import vo.MemberVo;

public class ListService implements CommonService{

	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		// Dao 실행(데이터 가져오기)
		List<MemberVo> users = MemberDao.getInstance().selectUsers();
		
		// users 데이터셋을  View에서 참조하기 위해 request 객체로 저장
		req.setAttribute("users", users);
		
		return "/Sub08/member/list.jsp";
	}

}
