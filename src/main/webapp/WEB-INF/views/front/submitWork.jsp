<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-18
  Time: 下午5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
    <%@include file="../../tags/frontDefault.jspf"%>
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <c:if test="${not empty workInfo}">
            <h2>作业已提交</h2>
            <p><label>提交时间：<fmt:formatDate  value="${workInfo.wiAddTime}"  pattern="yyyy-MM-dd HH:mm:ss" /></label></p>
            <p><label>文件名：</label>${workInfo.wiFileName}</p>
            <p><label>作业描述：</label>${workInfo.wIDesc}</p>
        </c:if>
    </div>
    <div class="col-md-6">
        <form action="${ctx}/front/submitWork" method="post" class="form-inline">
            <h2>
                <c:if test="${not empty workInfo}">重新提交
                    <input type="hidden" name="wiId" value="${workInfo.wiId}">
                </c:if>
                <c:if test="${empty workInfo}">提交作业</c:if>
            </h2>
            <input type="hidden" name="wId" value="${wId}">
            <input type="hidden" name="wiFileSize" id="fileSize">
            <div class="form-group">
                <label>上传文件：</label>
                <input id="fileAddr"  name="wiFileAddr" type="hidden" value="dizhi"  data-rules="{required:true}" class="input-normal control-text">
                <iframe style="position: relative;top: 10px;" width="100" height="30" frameborder="0" scrolling="no" class="iframe-file-upload" src="${ctx}/static/fileUpload/jsp/uploadFile.jsp"></iframe>
            </div><br><br>
            <div class="form-group">
                <label>文件名：</label>
                <input style="width:300px;" class="form-control" name="wiFileName" id="fileName" type="text" readonly="true" >
            </div><br><br>
            <div class="progress" style="width:360px;">
                <div id="progress" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
            </div>
            <textarea class="form-control" style="width:360px;" rows="5" name="wIDesc"  placeholder="作业描述"></textarea><br><br>
            <button type="submit" class="btn btn-default" style="margin-left: 50px;">提交</button>
        </form>
    </div>
</div>
<script type="text/javascript">
    var progress = $('#progress');
    //文件上传后名称的回显
    function displayFileName(upload_fileName,original_fileName,fileSize){
        progress.css('width','100%');
        clearInterval(progressInterval)
        $('#fileName').val(original_fileName);
        $('#fileAddr').val(upload_fileName);
        $("#fileSize").val(fileSize);
    }
    //进度监听
    var progressInterval;
    function showProgress(){
        progress.css('width','0%');
        progressInterval = setInterval(function(){
            getProgress();
        },3000);
    }
    //获取进度
    function getProgress(){
        $.ajax({
            url: "${ctx}/uploadDown/getProgress",
            type:'POST',
            dataType : 'json',
            success:function(data){
                var progressVal = data.pbytesRead/data.pcontentLength;
                progressVal =Math.round(progressVal*100);
                if(progressVal!=0){
                    progress.css('width',progressVal+'%');
                }
                if(progressVal==100){
                    clearInterval(progressInterval)
                }
            }
        });
    }

</script>
</body>
</html>