<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-18
  Time: 上午11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生留言</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <script>
        function checkForm(){
            var form = $('form');
            var userId = form.find('select[name="userId"]').val();
            if(userId==undefined||userId==null||userId==''){
                alert('请选择教师！');
                return false;
            }
            var msgContent = form.find('textarea[name="msgContent"]').val();
            if(msgContent==undefined||msgContent==null||msgContent==''){
                alert('请输入留言！');
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="${ctx}/front/studentAdd" method="post" onsubmit="return checkForm();" id="form">
    <input type="hidden" name="msgPid" ${msgPid}>
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" style="position: relative;top: 10px;width: 90px;">接收者：</label>
        <div class="col-sm-10">
            <select name="userId" class="form-control">
                <option value="">请选择</option>
                <c:forEach items="${teachers}" var="teacher">
                    <option value="${teacher.userId}">${teacher.nickName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <br><br><br><br>
    <textarea class="form-control" rows="5" name="msgContent"  placeholder="留言内容"></textarea><br>
    <button type="submit" class="btn btn-default" style="margin-left: 50px;">提交</button>
</form>
</body>
</html>