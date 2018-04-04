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
    <title>个人中心 作业提交</title>
    <%@include file="../../tags/frontDefault.jspf"%>
</head>
<body>
<div class="bs-example">
    <table class="table">
        <thead>
            <tr>
                <th>年级</th>
                <th>布置时间</th>
                <th>作业描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${works}" var="work">
            <tr>
                <td>${work.cName}</td>
                <td><fmt:formatDate  value="${work.wAddTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>${work.wDesc}</td>
                <td>
                    <a href="${ctx}/front/toSubmitWork?wId=${work.wId}">提交作业</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>