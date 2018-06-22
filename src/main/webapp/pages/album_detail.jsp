
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/15
  Time: 9:56
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1,text/html; charset=utf-8">
    <link rel="shortcut icon" href="http://localhost:8080/BlogJSPServlet2/favicon.ico">
    <title>个人博客——照片</title>
    <meta name="keywords" content="个人博客模板,博客模板,响应式">
    <meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/media.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.gallery.js"></script>
    <script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0,initial-scale=1.0,maximum-scale=1.0">
    <!--[if lt IE 9]>
    <script src="include/js/modernizr.js"></script>
    <![endif]-->
    <script src="js/share.js"></script><link rel="stylesheet" href="css/share_style1_32.css">


</head>
<body>
<div class="ibody">
    <header>css
        <h1>提拉米苏.甜腻的苦涩</h1>
        <h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
        <div class="logo"><a href="http://localhost:8080/BlogJSPServlet2/index/index"></a></div>

        <nav id="topnav">
            <a href="index">首页</a>
            <a href="pages/aboutMe">关于我</a>
            <a href="pages/article">慢生活</a>
            <a href="pages/album" id="topnav_current">我的相册</a>
            <a href="pages/critique">留言板</a>
        </nav>
    </header>
    <article>
        <h2 class="about_h">您现在的位置是：<a href="http://localhost:8080/BlogJSPServlet2/index/index">首页</a>&gt;<a href="http://localhost:8080/BlogJSPServlet2/album/album">个人相册</a>&gt;<a href="http://localhost:8080/BlogJSPServlet2/album/album_detail?id=1#">照片</a></h2>
        <div class="template">
            <h3>
                <p><span>个人相册</span></p>
            </h3>
            <ul>
                <div class="container">
                    <section id="dg-container" class="dg-container">
                        <div class="dg-wrapper">
                            <c:forEach var="photo" items="${photoList}">
                                <a href="#" class="dg-center" style="opacity: 1; visibility: visible;">
                                    <img src="${photo.image}" width="480px" height="260px">
                                    <div>${photo.note}</div>
                                </a>
                            </c:forEach>
                        </div>
                        <nav>
                            <span class="dg-prev">
                                  &lt;
                            </span>
                                    <span class="dg-next">
                                &gt;
                            </span>
                        </nav>
                    </section>
                </div>
                <script type="text/javascript">
                    $(function() {
                        $('#dg-container').gallery();
                    });
                </script>
            </ul>
            <%@include file="component_latestComment.jsp"%>
        </div>
    </article>
    <aside>
        <div class="rnav">
            <li class="rnav1 "><a href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
            <li class="rnav2 "><a href="http://user.qzone.qq.com/657682618">QQ空间</a></li>
            <li class="rnav3 "><a href="http://localhost:8080/BlogJSPServlet2/album/album_detail?id=1#">个人作品</a></li>
            <li class="rnav4 "><a href="http://localhost:8080/BlogJSPServlet2/album/album_detail?id=1#">原创程序</a></li>
        </div>
        <div class="ph_news">
            <%@include file="component_rankingByBrowse.jsp"%>
            <%@include file="component_recommendArticles.jsp"%>
            <div class="copyright">
                <ul>
                    <p> Design by <a href="http://localhost:8080/BlogJSPServlet2/album/album_detail?id=1#">jim</a></p>
                    <p></p>
                    <p></p>
                </ul>
            </div>
        </div>
    </aside>
    <script src="js/silder.js"></script>
    <div class="clear"></div>
    <!-- 清除浮动 -->
</div>

</body>
</html>
