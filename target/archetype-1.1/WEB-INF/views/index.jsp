<%--
  Created by IntelliJ IDEA.
  User: wrp
  Date: 15-3-1
  Time: 下午2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <title>后台首页</title>
    <style>
        .main{padding: 10px 20px;}
        .messageBG{background: #ddd;font-size: 14px;padding: 5px 5px;}
        .main p i{font-weight: 600;color: #dd0000;}
        .main h2{text-align: center;}

        .notice{width: 60%;float: left;}
        .info{width: 35%;float: right;}
    </style>
</head>

<body>
<div class="main">
    <p class="messageBG">您有未读留言：<i>${notReadMessage}</i>&nbsp;&nbsp;条</p>
    <div class="notice">
        <h3>最新公告</h3>
        <h2>${notice.noticeTitle}</h2>
        <div>${notice.noticeContent}</div>
    </div>
    <div class="info">
        <h3>系统信息</h3>
        <p>系统时间：<fmt:formatDate  value="${sysTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <p>系统版本：1.0</p>
    </div>
</div>
</body>
</html>