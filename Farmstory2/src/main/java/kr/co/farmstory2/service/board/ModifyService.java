package kr.co.farmstory2.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.dao.ArticleDao;
import kr.co.farmstory2.vo.ArticleVo;
import kr.co.farmstory2.vo.UserVo;
import kr.co.farmstory2.controller.CommonService;

public class ModifyService implements CommonService {

	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		// 로그인 체크
		HttpSession sess = req.getSession();
		UserVo userVo = (UserVo) sess.getAttribute("sessUser");
		
		if(req.getMethod().equals("GET")) {
			// Get 요청
			if(userVo == null) {
				return "redirect:/farmstory2/user/login.do";
			}else {
				String no = req.getParameter("no");
				
				ArticleDao dao = ArticleDao.getInstance();
				ArticleVo article = dao.selectArticle(no);
			
				req.setAttribute("article", article);
			
				return "/board/modify.jsp";
			}
			
		}else {
			// Post 요청
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String cate = req.getParameter("cate");
			String type = req.getParameter("type");
			String no = req.getParameter("no");
			
			ArticleDao.getInstance().updateArticle(title, content, no);
						
			return "redirect:/Farmstory2/board/view.do?cate="+cate+"&type="+type+"&no="+no;
		}
	}

}