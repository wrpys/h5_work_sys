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
    <title>个人中心</title>
    <style>
        .main{padding: 10px 20px;overflow-y: scroll;height: 500px;}
        .messageBG{background: #ddd;font-size: 14px;padding: 5px 5px;}
        .main p i{font-weight: 600;color: #dd0000;}
        .main h2{text-align: center;}

        .notice{width: 80%;margin: 0 auto;}
        .info{width: 35%;float: right;}
    </style>
</head>

<body>
<div class="main">
    <p class="messageBG">您有未读消息：<i>${notReadMessage}</i> 条</p>
    <div class="notice">
        <h3>最新公告</h3>
        <h2>${notice.noticeTitle}</h2>
        <div>${notice.noticeContent}</div>
    </div>
</div>
</body>
</html>