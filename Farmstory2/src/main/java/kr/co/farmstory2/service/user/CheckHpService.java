package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.farmstory2.controller.CommonService;
import kr.co.farmstory2.dao.UserDao;

public class CheckHpService implements CommonService {

	@Override
	public String businessProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String hp = req.getParameter("hp");
		int result = UserDao.getInstance().selectCountHp(hp);

		// Json 데이터 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		// Json 출력
		return "json:"+json.toString();
	}

}