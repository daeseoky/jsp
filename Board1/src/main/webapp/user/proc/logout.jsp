<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션해제
	session.invalidate();
	
	//로그인페이지 이동
	response.sendRedirect("/Board1/user/login.jsp?success=101");
%>