package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.dao.UserDao;
import kr.co.farmstory2.vo.TermsVo;
import kr.co.farmstory2.controller.CommonService;

public class TermsService implements CommonService {

	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		// 약관 가져오기
				TermsVo vo = UserDao.getInstance().selectTerms();
				
				req.setAttribute("termsVo", vo);
				
				return "/user/terms.jsp";
	}

}