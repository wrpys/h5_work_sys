<%--
  Created by IntelliJ IDEA.
  User: wrp
  Date: 15-1-5
  Time: 下午8:04
  首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <title>作业系统 首页</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <script>
        if(window.top !== window.self){ window.top.location = window.location;}
    </script>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 0px 5px 5px 0px;}
        .col-md-4border{height: 200px;}
        .h3-border{border-bottom: 2px solid #DDDDDD;}

        .dataList li{margin-top: 5px;}
        .dataList li a{text-decoration: none;color: #666;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="container">
    <div class="row row80">
        <div class="col-md-4">
            <div class="col-md-4border">
                <h3 class="h3-border">公告</h3>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#noticeNow" role="tab" data-toggle="tab">最新</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="noticeNow">
                        <ul class="dataList" style="margin-left: -15px;">
                        <c:forEach items="${noticeList}" var="notice">
                            <li><a href="${ctx}/front/noticeDetail?noticeId=${notice.noticeId}" title="${notice.noticeTitle}">${fn:substring(notice.noticeTitle, 0, 20)}</a></li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-4border">
                <h3 class="h3-border">新闻</h3>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#newNow" role="tab" data-toggle="tab">最新</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="newNow">
                        <ul class="dataList" style="margin-left: -15px;">
                            <c:forEach items="${newsList}" var="news">
                                <li><a href="${ctx}/front/newsDetail?newsId=${news.newsId}" title="${news.newsTitle}">${fn:substring(news.newsTitle, 0, 20)}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-md-4border">
                <h3 class="h3-border">资源</h3>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#fileNow" role="tab" data-toggle="tab">最新</a></li>
                    <li role="presentation"><a href="#fileHottest" role="tab" data-toggle="tab">最热</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="fileNow">
                        <ul class="dataList" style="margin-left: -15px;">
                            <c:forEach items="${fileNewest}" var="file">
                                <li><a href="${ctx}/front/downFile?fileId=${file.fileId}" title="${file.fileName}">${fn:substring(file.fileName, 0, 20)}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="fileHottest">
                        <ul class="dataList" style="margin-left: -15px;">
                            <c:forEach items="${fileHottest}" var="file">
                                <li><a href="${ctx}/front/downFile?fileId=${file.fileId}" title="${file.fileName}">${fn:substring(file.fileName, 0, 20)}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>