<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<section id="board" class="modify">
    <h3>글수정</h3>
    <article>
        <form action="/Farmstory2/board/modify.do" method="post">
        <input type="hidden" name="no" value="${article.no}">
            <table>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="title" value="${article.title}"/></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content">${article.content}</textarea>                                
                    </td>
                </tr>
                <tr>
                    <td>첨부</td>
                    <td><input type="file" name="file"/></td>
                </tr>
            </table>
            <div>
                <a href="/Farmstory2/board/view.do?cate=${cate}&type=${type}&no=${article.no}" class="btnCancel">취소</a>
                <input type="submit"  class="btnWrite" value="수정완료">
            </div>
        </form>
    </article>
</section>
<%@ include file="../_footer.jsp" %>