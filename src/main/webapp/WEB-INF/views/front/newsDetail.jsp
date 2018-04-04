<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 新闻详情</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 10px 5px 5px 0px;}
        .row80 h2{text-align: center;}
        .row80 p{text-align: right;padding-right: 200px;}
        .row80 div{padding: 0 70px;}
        .row80 div p{text-align: left;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="row row80">
        <h2>${news.newsTitle}</h2>
        <p>作者：${news.nickName}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate  value="${news.addTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></p>
        <div>${news.newsContent}</div>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>