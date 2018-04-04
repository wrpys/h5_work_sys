<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>作业系统 资源下载</title>
    <%@include file="../../tags/frontDefault.jspf"%>
    <style>
        .row80{width: 90%;margin-left: auto;margin-right: auto;padding: 0px 5px 5px 0px;}
        .h3-border{border-bottom: 2px solid #DDDDDD;}
        .h3-border span{display: inline-block;width: 80%;font-size: 26px;font-weight: bold;}
        .h3-border a{display: inline-block;width: 18%;}
        ul{list-style-type: none;padding-left: 5px;}
        .index{width: 40px;text-align: right;}
        .fileAddr{width: 50%;display: inline-block;}
        .nickName{width: 100px;display: inline-block;color: #454545;}
        .createTime{width: 150px;display: inline-block;color: #454545;}
        .down{width: 40px;display: inline-block;}
        .fileTitle span{font-size: 16px;font-weight: bold;}
        .pageNum{float: right;margin-right: 10%;}
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="row row80">
    <div class="col-md-4border">
        <p class="h3-border">
            <span>${fileType.ftName}</span>
        </p>
        <ul>
                <li class="fileTitle">
                    <label class="index">序号</label>
                    <label class="fileAddr">文件名</label>
                    <label class="nickName">上传者</label>
                    <label class="nickName">文件大小</label>
                    <label class="nickName">下载次数</label>
                    <label class="createTime">上传时间</label>
                    <label class="down">下载</label>
                </li>
                <c:forEach items="${fileList}" var="file" varStatus="status">
                <li>
                    <label class="index">${status.index+1}:</label>
                    <a class="fileAddr" href="${ctx}/front/downFile?fileId=${file.fileId}" title="${file.fileName}">${fn:substring(file.fileName, 0, 40)}</a>
                    <span class="nickName">${file.nickName}</span>
                    <span class="nickName">
                        <c:choose>
                            <c:when test="${file.fileSize/1024<1024}">
                                <fmt:formatNumber type="number" value="${file.fileSize/1024}" maxFractionDigits="2"/> KB
                            </c:when>
                            <c:when test="${file.fileSize/1024<(1024*1024)}">
                                <fmt:formatNumber type="number" value="${file.fileSize/1024/1024}" maxFractionDigits="2"/> MB
                            </c:when>
                            <c:otherwise>
                                <fmt:formatNumber type="number" value="${file.fileSize/1024/1024/1024}" maxFractionDigits="2"/> GB
                            </c:otherwise>
                        </c:choose>
                    </span>
                    <span class="nickName">${file.fileDownNum}</span>
                    <span class="createTime"><fmt:formatDate  value="${file.createTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></span>
                    <a class="down" href="${ctx}/front/downFile?fileId=${file.fileId}"><span class="glyphicon glyphicon-download-alt"></span></a>
                </li>
                </c:forEach>
        </ul>
    </div>
    <nav class="pageNum">
        <ul class="pagination">
            ${pageBar}
        </ul>
    </nav>
</div>
<%@include file="bottom.jsp"%>
</body>
</html>