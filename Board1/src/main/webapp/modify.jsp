<%@page import="kr.co.board1.bean.ArticleBean"%>
<%@page import="kr.co.board1.dao.ArticleDao"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");

	ArticleBean article = ArticleDao.getInstance().selectArticle(id);


%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글수정</title>
    <link rel="stylesheet" href="./css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
    <div id="wrapper">
        <section id="board" class="modify">
            <h3>글수정</h3>
            <article>
                <form action="/Board1/proc/modify.jsp" method="post">
                    <input type="hidden" name="id" value="<%= id %>"/>
                    <table>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" placeholder="제목을 입력하세요." value="<%= article.getTitle() %>"/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                                <textarea name="content"><%= article.getContent() %></textarea>                                
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="/Board1/list.jsp" class="btnCancel">취소</a>
                        <input type="submit"  class="btnWrite" value="수정완료">
                    </div>
                </form>
            </article>
        </section>
    </div>
</body>
</html>