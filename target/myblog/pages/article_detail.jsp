<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/4
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <title>Title</title>
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
            <a href="pages/article" id="topnav_current">慢生活</a>
            <a href="pages/album">我的相册</a>
            <a href="pages/critique">留言板</a>
        </nav>
    </header>
    <article>
        <h2 class="about_h">您现在的位置是：
            <a href="http://localhost:8080/BlogJSPServlet2/index/index">首页</a>
            &gt;<a href="article">慢生活</a>
            &gt;<span>${idArticle.title}</span>
        </h2>
        <div class="index_about">
            <h2 class="c_titile">${idArticle.title}</h2>
            <p class="box_c">
                <span class="d_time">发布时间：${idArticle.time}</span>
                <span>编辑：${idArticle.editor} </span>
                <span>浏览(${idArticle.browse}) </span>
                <span>评论(${idArticle.comment})</span>
            </p>
            <ul class="infos">
                ${idArticle.content}"
            </ul>
            <div class="keybq">
                <p>
                    <span>关键字词</span>：心得笔记
                </p>
            </div>
            <div class="nextinfo">
                <c:if test="${prevArticle != null}">
                    <p>上一篇：<a href="article?id=${prevArticle.id}">${prevArticle.title}</a></p>
                </c:if>
                <c:if test="${nextArticle != null}">
                    <p>下一篇：<a href="article?id=${nextArticle.id}">${nextArticle.title}</a></p>
                </c:if>

            </div>
        </div>
    </article>
    <aside>
        <div class="rnav">
            <li class="rnav1 "><a href="http://localhost:8080/BlogJSPServlet2/article/article_detail?id=2#">日记</a></li>
            <li class="rnav2 "><a href="http://localhost:8080/BlogJSPServlet2/article/article_detail?id=2#">欣赏</a></li>
            <li class="rnav3 "><a href="http://localhost:8080/BlogJSPServlet2/article/article_detail?id=2#">程序人生</a></li>
            <li class="rnav4 "><a href="http://localhost:8080/BlogJSPServlet2/article/article_detail?id=2#">经典语录</a></li>
        </div>
        <div class="ph_news">
            <%--浏览排行--%>
            <%@include file="component_rankingByBrowse.jsp"%>
            <%--推荐文章--%>
            <%@include file="component_recommendArticles.jsp"%>
            <%--最新评论--%>
            <%@include file="component_latestComment.jsp"%>
        </div>

        <div class="copyright">
            <ul>
                <p> Design by <a href="http://localhost:8080/BlogJSPServlet2/article/article_detail?id=2#">jim</a></p>
                <p></p>
                <p></p>
            </ul>
        </div>
    </aside>
    <script src="js/silder.js"></script>
    <div class="clear"></div>
    <!-- 清除浮动 -->
</div>
</body>
</html>
