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
    <title>个人中心 学生留言</title>
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
                <th>教师</th>
                <th>内容</th>
                <th>时间</th>
                <th>是否有新回复</th>
                <th>操作 <a href="${ctx}/front/toStudentAddMessage">留言</a></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${messageList}" var="message">
            <tr>
                <td>${message.teacherName}</td>
                <td>${message.msgContent}</td>
                <td><fmt:formatDate  value="${message.msgAddTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>
                    <c:choose>
                        <c:when test="${message.msgIsRead==0}">是</c:when>
                        <c:when test="${message.msgIsRead==1}">否</c:when>
                    </c:choose>
                </td>
                <td>
                    <a href="${ctx}/front/messageDetail?msgId=${message.msgId}">详情</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav class="pageNum">
        <ul class="pagination">
            ${pageBar}
        </ul>
    </nav>
</div>
</body>
</html>