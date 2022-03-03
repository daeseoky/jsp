<%@page import="kr.co.Farmstory1.bean.UserBean"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserBean sessUser = (UserBean)session.getAttribute("sessUser");
	String success = request.getParameter("success");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="/Farmstory1/css/style.css"/>
    <link rel="stylesheet" href="/Farmstory1/user/css/style.css"/>
    <link rel="stylesheet" href="/Farmstory1/board/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script>
    	let success = "<%= success %>";
    	
    	if(success == '100'){
    		alert("아이디, 비밀번호를 다시 확인하십시요.");    		
    	}else if(success == '101'){
    		alert("정상적으로 로그아웃을 했습니다.");
    	}else if(success == '102'){
    		alert("로그인을 먼저 하셔야 합니다.");
    	}else if(success == '200'){
    		alert("회원가입을 성공하였습니다. 생성된 아이디로 로그인 하세요.");
    	}
    </script>
</head>
<body>
    <div id="wrapper">
        <header>
            <a href="/Farmstory1" class="logo"><img src="/Farmstory1/img/logo.png" alt="로고"/></a>
            <p>
                <a href="/Farmstory1">HOME |</a>
                <% if(sessUser == null){ %>
                	<a href="/Farmstory1/user/login.jsp">로그인 |</a>
                	<a href="/Farmstory1/user/terms.jsp">회원가입 |</a>
                <% }else{ %>
                	<a href="/Farmstory1/user/logout.jsp">로그아웃 |</a>
                <% } %>
                <a href="/Farmstory1/board/list.jsp?cate=community&type=qna">고객센터</a>
            </p>
            <img src="/Farmstory1/img/head_txt_img.png" alt="3만원 이상 무료배송"/>
            
            <ul class="gnb">
                <li><a href="/Farmstory1/introduction/hello.jsp">팜스토리소개</a></li>
                <li><a href="/Farmstory1/board/list.jsp?cate=market&type=market"><img src="/Farmstory1/img/head_menu_badge.png" alt="30%"/>장보기</a></li>
                <li><a href="/Farmstory1/board/list.jsp?cate=croptalk&type=story">농작물이야기</a></li>
                <li><a href="/Farmstory1/board/list.jsp?cate=event&type=event">이벤트</a></li>
                <li><a href="/Farmstory1/board/list.jsp?cate=community&type=notice">커뮤니티</a></li>
            </ul>
        </header>