<%@page import="java.util.logging.LogManager"%>
<%@page import="java.util.logging.Logger"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>로그테스트</title>
	</head>
	<body>
		<h3>로그 실습하기</h3>
		<%
			//java 기본 로그
			Logger _logger = Logger.getGlobal();
		
			_logger.info("info log!");
			_logger.warning("warning log!");
			_logger.severe("severe log!");
		
		%>
	</body>
</html>