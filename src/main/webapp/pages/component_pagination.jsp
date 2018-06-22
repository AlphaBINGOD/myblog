<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/10
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page">
    <%--用于分页--%>
    <c:forEach var="i" begin="1" end="3" step="1">
        <%--若是请求页的页码则加粗显示--%>
        <c:choose>
            <c:when test="${i==1}">
                <c:if test="${currentPage > 1}">
                    <a href="pages/${url}?currentPage=${currentPage-1}">&lt;</a>
                    <a href="pages/${url}?currentPage=${currentPage-1}">${currentPage-1}</a>
                </c:if>
            </c:when>
            <c:when test="${i==2}">
                <b>${currentPage}</b>
            </c:when>
            <c:when test="${i==3}">
                <c:if test="${currentPage < totalPage}">
                    <a href="pages/${url}?currentPage=${currentPage+1}">${currentPage+1}</a>
                    <a href="pages/${url}?currentPage=${currentPage+1}">&gt;</a>
                </c:if>
            </c:when>
        </c:choose>
    </c:forEach>
</div>
