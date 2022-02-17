<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	//전송 데이터 수신
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("uid");
	
	// 데이터 작업(PrepareStatement)
		String host = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
		String user = "cesiya3";
		String pass = "1234";
		
		int result = 0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(host, user, pass);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate("DELETE FROM `Member` WHERE `uid`='"+uid+"'");
			conn.close();
						
		}catch(Exception e){
			e.printStackTrace();
		}

		//결과 Json 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		String jsonData = json.toString();
		out.print(jsonData);
		
%>