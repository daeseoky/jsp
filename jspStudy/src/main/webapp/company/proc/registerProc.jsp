<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String pos = request.getParameter("pos");
	String dep = request.getParameter("dep");

	//데이터베이스 작업(PrepareStatment 사용)
	String host = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
	String user = "cesiya3";
	String pass = "1234";
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(host, user, pass);
	String sql = "INSERT INTO `Member` VALUES(?,?,?,?,?,now());";
	PreparedStatement psmt = conn.prepareStatement(sql);
	
	psmt.setString(1, uid);
	psmt.setString(2, name);
	psmt.setString(3, hp);
	psmt.setString(4, pos);
	psmt.setString(5, dep);
	
	psmt.executeUpdate();
	conn.close();
	
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	//직원목록 이동
	response.sendRedirect("../list.jsp");
%>