<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"
		session ="true"
		buffer="8kb"
		autoFlush="true"
		isThreadSafe="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>p88 예제 - import, session, buffer, autoFlush, isThreadSafe 속성</title>
	</head>
	<body>
		<h2>p88 예제 - import, session, buffer, autoFlush, isThreadSafe 속성</h2>
		<%
		Timestamp now = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = format.format(now);
		%>
		
		오늘은 <%=strDate %> 입니다.
	
	</body>
</html>