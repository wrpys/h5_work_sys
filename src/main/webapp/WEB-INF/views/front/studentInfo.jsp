<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-6
  Time: 下午6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
    <style>
        .studentInfo{width: 80%;padding: 10px 50px;height: 400px;}
        .studentInfo h2{text-align: center;}
    </style>
</head>
<body>
    <div class="studentInfo">
        <h2>个人信息</h2>
        <p>学号：${studentInfo.sNo}</p>
        <p>姓名：${studentInfo.sName}</p>
        <p>性别：${studentInfo.sSex==false?"男":"女"}</p>
        <p>专业：${studentInfo.dName}</p>
        <p>年级：${studentInfo.grade} 级</p>
        <p>班级：${studentInfo.sClass} 班</p>
    </div>
</body>
</html>