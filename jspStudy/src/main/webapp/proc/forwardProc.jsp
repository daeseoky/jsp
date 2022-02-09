<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>forwardProc</title>
	</head>
	<body>
		<h3>포워드 페이지</h3>
		<%
			// 내부서버 페이지가느이 요청이기때문에 외부서버 요청을 할수 없다
			//pageContext.forward("https://www.naver.com/"); 
			pageContext.forward("../Sub01/Hello.jsp");
			
		%>
	
	</body>
</html>