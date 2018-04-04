<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 个人中心</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 95%;height:560px;margin-left: auto;margin-right: auto;margin-top:10px;padding: 0px 5px 5px 0px;}
        .sName{float: right;height: 50px;line-height: 50px;}
        .homeLeft,.homeRight{height:100%;border: 2px solid #dddddd;padding: 10px 10px 10px 10px;}
        .homeLeft h3{border-bottom: 2px solid #DDDDDD;text-align: center;}
        .homeLeft ul{list-style-type: none;margin: 0;padding: 0;}
        .homeLeft li{height: 35px;line-height: 35px;border-bottom: 1px solid #dddddd;padding-left: 5px;}
        .homeLeft li a{text-decoration: none;color: #666;}
        .homeLeft li a:hover{cursor: pointer;}
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/front/toIndex">作业系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li <c:if test="${active=='jianjie'}">class="active"</c:if> ><a href="${ctx}/front/toBriefIntroduction">简介</a></li>
                <li <c:if test="${active=='noticeIndex'}">class="active"</c:if>><a href="${ctx}/front/toNoticeIndex">公告</a></li>
                <li <c:if test="${active=='newsIndex'}">class="active"</c:if>><a href="${ctx}/front/toNewsIndex">新闻</a></li>
                <li <c:if test="${active=='fileIndex'}">class="active"</c:if>><a href="${ctx}/front/toFileIndex">资源下载</a></li>
                <c:if test="${not empty student}">
                    <li <c:if test="${active=='studentHome'}">class="active"</c:if> ><a href="${ctx}/front/toStudentHome" id="aHome">个人中心</a></li>
                </c:if>
            </ul>
            <span class="sName">欢迎，${student.sName} - <a href="${ctx}/front/studentLogout">退出</a></span>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="row row80">
    <div class="col-md-2 homeLeft">
        <h3>菜单栏</h3>
        <ul>
            <li><a href="${ctx}/front/toStudentInfo" target="main"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;我的信息</a></li>
            <li><a href="${ctx}/front/toMessageIndex" target="main"><span class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;我的消息</a></li>
            <li><a href="${ctx}/front/toCourseIndex" target="main"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;课程查询</a></li>
            <li><a href="${ctx}/front/toWorkIndex" target="main"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;作业提交</a></li>
        </ul>
    </div>
    <div class="col-md-10 homeRight">
        <iframe id="main" name="main" width="100%" scrolling="no" height="100%" frameborder="0" src="${ctx}/front/toHomeIndex"></iframe>
    </div>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>