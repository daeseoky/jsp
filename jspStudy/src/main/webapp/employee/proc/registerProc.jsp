<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String hp = request.getParameter("hp");
	String email = request.getParameter("email");
	String pos = request.getParameter("pos");
	String dep = request.getParameter("dep");

	String host = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
	String user = "cesiya3";
	String pass = "1234";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		String sql = "INSERT INTO `Employee` VALUES(?,?,?,?,?,?,?,now());";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, gender);
		psmt.setString(4, hp);
		psmt.setString(5, email);
		psmt.setString(6, pos);
		psmt.setString(7, dep);
		
		psmt.executeUpdate();
		conn.close();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");
%>
