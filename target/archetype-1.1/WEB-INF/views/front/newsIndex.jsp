<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 新闻列表</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 10px 5px 5px 0px;}
        ul{list-style-type: none;padding-left: 5px;}
        .row80 ul li{padding: 3px 10px;font-size: 16px;}
        .index{width: 30px;text-align: right;}
        .noticeTitle{width: 60%;display: inline-block;}
        .noticeName{width: 10%;display: inline-block;color: #454545;}
        .addTime{width: 18%;display: inline-block;color: #454545;}
        .pageNum{float: right;margin-right: 10%;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="row row80">
    <ul>
        <c:forEach items="${newsList}" var="news" varStatus="status">
        <li>
            <label class="index">${status.index+1}:</label>
            <a class="noticeTitle" href="${ctx}/front/newsDetail?newsId=${news.newsId}" title="${news.newsTitle}">
                ${fn:substring(news.newsTitle, 0, 40)}</a>
            <span class="noticeName">${news.nickName}</span>
            <span class="addTime"><fmt:formatDate  value="${news.addTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></span>
        </li>
        </c:forEach>
    </ul>
    <nav class="pageNum">
        <ul class="pagination">
            ${pageBar}
        </ul>
    </nav>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>