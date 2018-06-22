<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/12
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>
    <p>点击排行</p>
</h2>
<ul class="ph_n">
    <c:forEach var="article" items="${recommendArticles}" varStatus="status">
        <li>
            <c:choose>
                <c:when test="${status.index < 3}">
                    <span class="num1">${status.count}</span>
                </c:when>
                <c:otherwise>
                    <span>${status.count}</span>
                </c:otherwise>
            </c:choose>
            <a href="pages/article?id=${article.id}">
                    ${article.id}${article.title}
            </a>
        </li>
    </c:forEach>
</ul>
