<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*得到工程名  /myblog   */
    String path = request.getContextPath();
    /*也就是   http://localhost:8080/myblog/      用于设置页面的基础路径*/
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <%--设置基准路径--%>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人博客——jim</title>
    <meta name="keywords" content="个人博客,博客,响应式">
    <meta name="description" content="如影随形主题的个人博客，神秘、俏皮。">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/media.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <!--[if lt IE 9]>
    <script src="include/js/modernizr.js"></script>
    <![endif]-->
    <script src="js/share.js"></script><link rel="stylesheet" href="css/share_style1_32.css">
</head>
<body>
<div class="ibody">
    <header>
        <h1>提拉米苏.甜腻的苦涩</h1>
        <h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
        <div class="logo"><a href="http://localhost:8080/BlogJSPServlet2/index/index"></a></div>
        <nav id="topnav">
            <a href="index">首页</a>
            <a href="pages/aboutMe">关于我</a>
            <a href="pages/article">慢生活</a>
            <a href="pages/album">我的相册</a>
            <a href="pages/critique" id="topnav_current">留言板</a>
        </nav>
    </header>
    <article>
        <h2 class="about_h">您现在的位置是：
            <a href="http://localhost:8080/BlogJSPServlet2/index/index">首页</a>&gt;
            <a href="http://localhost:8080/BlogJSPServlet2/critique/critique">留言板</a>
        </h2>
        <div class="template">
            <h3>
                <p><span>最新留言</span></p>
            </h3>
            <ul class="pl_n">
                <c:forEach var="critique" items="${pageCritiqueList}">
                    <dl>
                        <dt><img src="images/s8.jpg"></dt>
                        <dt></dt>
                        <dd>
                            <table align="left" width="200">
                                <tbody>
                                    <tr>
                                        <td width="80">${critique.name}</td>
                                        <td><time>${critique.time}</time></td>
                                    </tr>
                                </tbody>
                            </table>
                        </dd>
                        <dd>
                            <a href="http://localhost:8080/BlogJSPServlet2/critique/critique#">
                                ${critique.content}
                                <!--   <s:property value="content" escape="false"/>  -->
                            </a>
                        </dd>
                    </dl>
                </c:forEach>
            </ul>
            <%--页码--%>
            <%@include file="component_pagination.jsp"%>
            <h3>
                <p><span>随便说说</span></p>
                <a href="http://localhost:8080/BlogJSPServlet2/critique/critique#" target="_blank" class="more"></a>
            </h3>
            <form action="pages/critique" method="post">
                <table>
                    <tbody><tr>
                        <input type="hidden" name="token" value="${sessionScope.token}">
                        <td><span>您的姓名:</span></td><td><input name="name"></td>
                    </tr>
                    <tr>
                        <td>
                            <div style="width:70px;padding-bottom: 189px;">
                                <span>留言内容:</span>
                            </div>
                            </td><td>
                            <textarea name="content"  style="height:200px; width:630px;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td><td><button type="submit" style="width: 60px;height: 30px;font-size: larger;">提交</button></td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </article>
    <aside>
        <div class="rnav">
            <li class="rnav1 "><a href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
            <li class="rnav2 "><a href="http://user.qzone.qq.com/657682618">QQ空间</a></li>
            <li class="rnav3 "><a href="http://localhost:8080/BlogJSPServlet2/critique/critique#">个人作品</a></li>
            <li class="rnav4 "><a href="http://localhost:8080/BlogJSPServlet2/critique/critique#">随便逛逛</a></li>
        </div>
        <div class="ph_news">
            <%--浏览排行--%>
            <%@include file="component_rankingByBrowse.jsp"%>
            <%--推荐文章--%>
            <%@include file="component_recommendArticles.jsp"%>
            <div class="copyright">
                <ul>
                    <p> Design by <a href="http://localhost:8080/BlogJSPServlet2/critique/critique#">jim</a></p>
                    <p></p>
                    <p></p>
                </ul>
            </div>
        </div></aside>
    <script src="js/silder.js"></script>
    <div class="clear"></div>
    <!-- 清除浮动 -->
</div>
</body>
</html>
