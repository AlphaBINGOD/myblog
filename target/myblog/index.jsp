<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/3
  Time: 16:34
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

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人博客——主页</title>
    <meta name="keywords" content="个人博客模板,博客模板,响应式">
    <meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/media.css" rel="stylesheet">
    <style type="text/css">
        /*为段落定义样式*/
    </style>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
    <!--[if lt IE 9]>
    <script src="include/js/modernizr.js"></script>
    <![endif]-->
    <script src="js/share.js"></script><link rel="stylesheet" href="css/share_style1_32.css"></head>
<body>

<div class="ibody">
    <header>
        <h1>提拉米苏.甜腻的苦涩</h1>
        <h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
        <div class="logo"><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"></a></div>

        <nav id="topnav">
            <a href="index" id="topnav_current">首页</a>
            <a href="pages/aboutMe">关于我</a>
            <a href="pages/article?currentPage=1">慢生活</a>
            <a href="pages/album">我的相册</a>
            <a href="pages/critique">留言板</a>
        </nav>
    </header>
    <article>
        <div class="banner">
            <ul class="texts">
                <p>The best life is use of willing attitude, a happy-go-lucky life. </p>
                <p>最好的生活是用心甘情愿的态度，过随遇而安的生活。</p>
            </ul>
        </div>
        <div class="bloglist">
            <h2>
                <p><span>推荐</span>文章</p>
            </h2>

            <c:forEach var="article" items="${pageArticles}">
                <div class="blogs">
                    <h3>
                        <a href="pages/article?id=${article.id}">f
                        ${article.title}
                    </a>
                    </h3>
                    <figure><img src=${article.image}></figure>
                    <ul>
                        <div class="content" style="height:12em;clear:both;">
                            ${article.content}
                        </div>
                        <a href="pages/article?id=${article.id}" target="_blank" class="readmore" style="color:white;">阅读全文&gt;&gt;</a>
                    </ul>
                    <p class="autor">
                        <span>作者：${article.editor}</span>
                        <span>分类：【<a href="http://localhost:8080/">${article.type}</a>】</span>
                        <span>浏览（<a href="http://localhost:8080/">${article.browse}</a>）</span>
                        <span>评论（<a href="http://localhost:8080/">${article.comment}</a>）</span>
                    </p>
                    <div class="dateview">${article.time}</div>
                </div>
            </c:forEach>
        </div>
        <%@ include file="pages/component_pagination.jsp"%>
    </article>
    <aside>

        <div class="avatar"><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"><span>关于Jim</span></a></div>
        <div class="topspaceinfo">
            <h1>执子之手，与子偕老</h1>
            <p>于千万人之中，我遇见了我所遇见的人....</p>
        </div>
        <div class="about_c">
            <p>网名：jim</p>
            <p>职业：Java程序员</p>
            <p>籍贯：江西-鹰潭</p>
            <p>QQ：3535305171</p>
            <p>邮箱：3535305171@qq.com</p>
        </div>
        <div class="bdsharebuttonbox bdshare-button-style1-32" data-bd-bind="1527750390322"><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#" class="bds_more" data-cmd="more"></a></div>
        <div class="tj_news">
            <%@include file="pages/component_rankingByBrowse.jsp"%>
            <%@include file="pages/component_recommendArticles.jsp"%>
        </div>
        <div class="links">
            <h2>
                <p>友情链接</p>
            </h2>
            <ul>
                <li><a href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
                <li><a href="http://user.qzone.qq.com/657682618">QQ空间</a></li>
            </ul>
        </div>

        <div class="copyright">
            <ul>
                <p> Design by <a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#">jim</a></p>
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
