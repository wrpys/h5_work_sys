<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-6
  Time: 下午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>个人中心 课程查询</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .pageNum{float: right;margin-right: 10%;}
    </style>
</head>
<body>
<div class="bs-example">
    <table class="table">
        <thead>
            <tr>
                <th>课程名</th>
                <th>教师</th>
                <th>上课地址</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.cName}</td>
                <td>${course.nickName}</td>
                <td>${course.aaName}</td>
                <td>
                    <a href="${ctx}/front/toAttendanceWorkIndex?cId=${course.cId}">出勤和作业提交情况</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>