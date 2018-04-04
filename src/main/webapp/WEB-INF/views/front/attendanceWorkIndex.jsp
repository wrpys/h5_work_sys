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
    <title>个人中心 出勤和作业提交情况</title>
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
                <th>上课时间</th>
                <th>出勤情况</th>
                <th>作业提交情况</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${attendanceWorks}" var="attendanceWork">
            <tr>
                <td><fmt:formatDate  value="${attendanceWork.ctTime}"  pattern="yyyy-MM-dd" /></td>
                <td>
                    <c:choose>
                        <c:when test="${attendanceWork.attendanceInfo==1}">
                            出勤
                        </c:when>
                        <c:when test="${attendanceWork.attendanceInfo==2}">
                            旷课
                        </c:when>
                        <c:when test="${attendanceWork.attendanceInfo==3}">
                            迟到
                        </c:when>
                        <c:when test="${attendanceWork.attendanceInfo==4}">
                            早退
                        </c:when>
                        <c:otherwise>
                            未点名
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${attendanceWork.workInfo==1}">
                           已交
                        </c:when>
                        <c:when test="${attendanceWork.workInfo==2}">
                            未交
                        </c:when>
                        <c:when test="${attendanceWork.workInfo==3}">
                            漏交
                        </c:when>
                        <c:otherwise>
                            未录入
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>