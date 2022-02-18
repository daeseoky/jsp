<%@page import="Bean.StudentsBean"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터베이스 작업(statement 사용)
	
	String host = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
	String user = "cesiya3";
	String pass = "1234";

	List<StudentsBean> members = new ArrayList<>();
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM `Students`";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
			StudentsBean mb = new StudentsBean();
			mb.setSid(rs.getString(1));
			mb.setName(rs.getString(2));
			mb.setGender(rs.getInt(3));
			mb.setHp(rs.getString(4));
			mb.setGrade(rs.getInt(5));
			mb.setRdate(rs.getString(6));
			
			members.add(mb);
		}
		
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//Json 데이터출력
	Gson gson = new Gson();
	
	String jsonData = gson.toJson(members);
	out.print(jsonData);
	
%>
