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
		
		// Dao ����(������ ��������)
		List<MemberVo> users = MemberDao.getInstance().selectUsers();
		
		// users �����ͼ���  View���� �����ϱ� ���� request ��ü�� ����
		req.setAttribute("users", users);
		
		return "/Sub08/member/list.jsp";
	}

}
