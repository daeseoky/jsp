package kr.co.Board2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Board2.controller.CommonService;
import kr.co.Board2.dao.UserDao;
import kr.co.Board2.vo.TermsVo;

public class TermsService implements CommonService {

	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		// 약과 가져오기
		TermsVo vo = UserDao.getInstance().selectTerms();
		
		req.setAttribute("termsVo", vo);
		
		return "/user/terms.jsp";
	}

}