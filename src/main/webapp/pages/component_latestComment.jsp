<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>
    <p>最新评论</p>
</h2>
<ul class="pl_n">
    <c:forEach var="critique" items="${upToDateCritiques}" varStatus="status">
        <dl>
            <dt><img src="images/s8.jpg"></dt>
            <dt> </dt>
            <dd>
                    ${critique.name}
                <time>${critique.time}</time>
            </dd>
            <dd>
                <a href="http://localhost:8080/BlogJSPServlet2/article/article#">
                        ${critique.content}
                    <!--   <s:property value="content" escape="false"/>  -->
                </a>
            </dd>
        </dl>
    </c:forEach>
</ul>
