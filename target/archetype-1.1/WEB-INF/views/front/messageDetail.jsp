<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-13
  Time: 下午6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>留言详情</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <script>
        function checkForm(){
            var msgContent = $('#msgContent').val();
            if(msgContent==undefined||msgContent==null||msgContent==''){
                alert('请输入留言！');
                return false;
            }
            return true;
        }
    </script>
    <style>
        body{padding-top: 10px;}
        ul{list-style: none;width:90%;border: 2px solid #ddd;height: 390px;overflow-y: scroll;}
        ul li{padding: 5px 20px 0 0;}
        ul li p{font-size: 12px;}
        .student{color: #62A7F9;}
        .teacher{color: #008040;}
    </style>
</head>
<body>
    <ul>
        <c:forEach items="${replyList}" var="message">
            <li
                    <c:choose>
                        <c:when test="${message.sendRole==3}">class="student"</c:when>
                        <c:otherwise>class="teacher"</c:otherwise>
                    </c:choose>
                >
                <c:choose>
                    <c:when test="${message.sendRole==3}">
                        <p>${message.studentName}:<fmt:formatDate  value="${message.msgAddTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></p>
                    </c:when>
                    <c:otherwise>
                        <p>${message.teacherName}:<fmt:formatDate  value="${message.msgAddTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></p>
                    </c:otherwise>
                </c:choose>
                ${message.msgContent}
            </li>
        </c:forEach>
    </ul>
    <form action="${ctx}/front/studentAdd" method="post" onsubmit="return checkForm();">
        <input type="hidden" name="msgId" value="${msgId}">
        <input type="hidden" name="msgPid" value="${msgPid}">
        <textarea class="form-control" rows="3" name="msgContent" id="msgContent" placeholder="回复内容" style="width: 90%;margin-bottom: 5px;"></textarea>
        <button type="submit" class="btn btn-default" style="margin-left: 50px;">提交</button>
    </form>
</body>
</html>