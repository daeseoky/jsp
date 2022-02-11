<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	String host = "jdbc:mysql://chhak.or.kr:3306/cesiya3";
	String user = "cesiya3";
	String pass = "1234";

	List<EmployeeBean> members = new ArrayList<>();
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
	
		String sql = "SELECT * FROM `Employee`";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			
			EmployeeBean mb = new EmployeeBean();
			mb.setUid(rs.getString(1));
			mb.setName(rs.getString(2));
			mb.setGender(rs.getInt(3));
			mb.setHp(rs.getString(4));
			mb.setEmail(rs.getString(5));
			mb.setPos(rs.getString(6));
			mb.setDep(rs.getInt(7));
			mb.setRdate(rs.getString(8));
			
			members.add(mb);
		}
		
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>list</title>
	</head>
	<body>
		<h3>직원목록</h3>
		<a href="./register.jsp">직원등록</a>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>휴대폰</th>
				<th>이메일</th>
				<th>직급</th>
				<th>부서</th>
				<th>입사일</th>
			</tr>
			<% for(EmployeeBean mb : members){ %>
				<tr>
					<td><%=mb.getUid() %></td>
					<td><%=mb.getName() %></td>
					<td>
						<%
							if (mb.getGender() == 1){
								out.println("남");
							}else{
								out.println("여");
							}
						%>
					</td>
					<td><%=mb.getHp() %></td>
					<td><%=mb.getEmail() %></td>
					<td><%=mb.getPos() %></td>
					<td>
						<%
							switch(mb.getDep()){
							case 101:
								out.println("영업1부");
								break;
							case 102:
								out.println("영업2부");
								break;
							case 103:
								out.println("영업3부");
								break;
							case 104:
								out.println("영업4부");
								break;
							case 105:
								out.println("인사부");
								break;
							
							}
	
						%>
					</td>
				<td><%=mb.getRdate().substring(0,10) %></td>
			</tr>
			<%} %>
		</table>
	
	
	</body>
</html>