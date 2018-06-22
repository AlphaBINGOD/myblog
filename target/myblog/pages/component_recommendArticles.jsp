<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/13
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>
    <p>栏目推荐</p>
</h2>
<ul>
    <c:forEach var="article" items="${upToDateArticles}" varStatus="status">
        <li>
            <a href="pages/article?id=${article.id}">
                    ${article.id}${article.title}
            </a>
        </li>
    </c:forEach>
</ul>
