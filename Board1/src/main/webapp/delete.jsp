<%@page import="kr.co.board1.bean.UserBean"%>
<%@page import="kr.co.board1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean sessUser = (UserBean) session.getAttribute("sessUser");
	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	
	ArticleDao.getInstance().deleteArticle(id);
	
	// 리다이렉트
	response.sendRedirect("/Board1/list.jsp");
%>

