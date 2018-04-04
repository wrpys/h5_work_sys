<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>选择题</title>

<style type="text/css">
    *{margin: 0;padding: 0;}
    body{text-align: center;}
    #main{ width: 1003px;margin-left: auto;margin-right: auto;}
    .testList{width: 100%;list-style: none;}
    .testList li{width: 100%;height: auto;margin-top: 5px;border-bottom: 1px solid #ff0000;padding: 0 0 5px 10px;}
    .testList li p{text-align: left;font-size: 16px;}
    .testList li div{width:100%;text-align: left;}
</style>
</head>
<body>
    <div id="main">
        <ul class="testList">
            <form action="${ctx}/front/submitTest" method="post">
                <input type="hidden" name="ids" value="${testIds}">
            <c:forEach items="${testList}" var="test" varStatus="status">
                <li>
                    <p>
                        <b <c:if test="${not empty test.trueAnswer&&test.testAnswer!=test.trueAnswer}">style="color:#ff0000;"</c:if>>${status.index+1}.</b>
                        ${test.testTitle}
                        <c:if test="${not empty test.trueAnswer}">
                            <c:if test="${test.testAnswer==1}">(A)</c:if>
                            <c:if test="${test.testAnswer==2}">(B)</c:if>
                            <c:if test="${test.testAnswer==3}">(C)</c:if>
                            <c:if test="${test.testAnswer==4}">(D)</c:if>
                        </c:if>
                    </p>
                    <div>
                        <input type="radio" name="${test.testId}" value="1"
                                <c:if test="${test.trueAnswer==1}">checked="checked" </c:if>
                                >A.${test.testOptionA}
                    </div>
                    <div>
                        <input type="radio" name="${test.testId}" value="2"
                               <c:if test="${test.trueAnswer==2}">checked="checked" </c:if>
                                >B.${test.testOptionB}
                    </div>
                    <div>
                        <input type="radio" name="${test.testId}" value="3"
                               <c:if test="${test.trueAnswer==3}">checked="checked" </c:if>
                                >C.${test.testOptionC}
                    </div>
                    <div class="optionBottom">
                        <input type="radio" value="4" name="${test.testId}"
                               <c:if test="${test.trueAnswer==4}">checked="checked" </c:if>
                                >D.${test.testOptionD}
                    </div>
                </li>
            </c:forEach>
                <input type="submit" value="提交试卷">
            </form>
        </ul>
    </div>
</body>
</html>