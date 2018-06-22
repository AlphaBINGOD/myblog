<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/15
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
从jsp跳转到servlet,主要是为了解决首页数据获取问题
默认的首页并不是真正的首页,这个首页会自动跳转到真正的首页,这个过程中也会请求数据
--%>
<jsp:forward page="/index"></jsp:forward>