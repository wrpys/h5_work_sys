<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 资源下载</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 0px 5px 5px 0px;}
        .col-md-4border{height: 300px;}
        .h3-border{border-bottom: 2px solid #DDDDDD;}
        .h3-border span{display: inline-block;width: 80%;font-size: 26px;font-weight: bold;}
        .h3-border a{display: inline-block;width: 18%;}
        ul{list-style-type: none;padding-left: 5px;}
        .index{width: 4%;text-align: right;}
        .fileAddr{width: 65%;display: inline-block;}
        .nickName{width: 18%;display: inline-block;color: #454545;}
        .down{width: 10%;display: inline-block;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="row row80">
    <c:forEach items="${fileTypes}" var="fileType">
        <div class="col-md-6">
            <div class="col-md-4border">
                <p class="h3-border">
                    <span>${fileType.ftName}</span>
                    <a href="${ctx}/front/toFileTypeIndex?ftId=${fileType.ftId}">more&gt;&gt;</a>
                </p>
                <c:forEach items="${files}" var="file">
                    <c:if test="${fileType.ftId==file.fileType}">
                        <ul>
                            <c:forEach items="${file.files}" var="fileTemp" varStatus="status">
                                <li>
                                    <label class="index">${status.index+1}:</label>
                                    <a class="fileAddr" href="${ctx}/front/downFile?fileId=${fileTemp.fileId}" title="${fileTemp.fileName}">${fn:substring(fileTemp.fileName, 0, 25)}</a>
                                    <span class="nickName">${fileTemp.nickName}</span>
                                    <a class="down" href="${ctx}/front/downFile?fileId=${fileTemp.fileId}"><span class="glyphicon glyphicon-download-alt"></span></a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>