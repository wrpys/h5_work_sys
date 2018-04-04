<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-3-5
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <title>jsp在线检测</title>
    <style>
        .top{height: 30px;width: 100%;padding: 10px 2.3%;}
        .mid{height: 500px;width: 95%;margin-left:auto;margin-right: auto;border: 2px solid #ddd;}
        .bottom{height: 30px;width: 100%;line-height: 30px;text-align: center;}

    </style>
</head>
<body>
    <div class="top">
        <input id="jdAddr"  name="jdAddr" type="hidden" value="">
        <iframe width="62" height="30" frameborder="0" scrolling="no" class="iframe-file-upload" src="${ctx}/static/jspUpload/jsp/uploadExcel.jsp"></iframe>
        <span id="fileName" style="display: inline-block;position: relative;top: -15px;"></span>
        <button class="button" id="runBnt" style="display:none;position: relative;top: -15px;">运行</button>
    </div>
    <div class="mid">
        <iframe id="jspIframe" width="100%" height="100%" frameborder="0" src=""></iframe>
    </div>
    <div class="bottom">
        注：运行无需实体的JSP页面。
    </div>
    <script type="text/javascript">
        var jdId = null;
        //上传文件的回显,显示运行按钮
        function displayFileName(path,realName){
            $('#fileName').html("文件名： "+realName);
            $('#jdAddr').val(path);
            $("#runBnt").show();
            jdId = null;
        }

        $(function(){

            $("#runBnt").click(function(){
                var data = {
                    jdAddr : $("#jdAddr").val(),
                    jdId:jdId
                };
                $.ajax({
                    url: "${ctx}/jspDetect/add",
                    type:'POST',
                    async:false,
                    dataType:'json',
                    data:data,
                    success:function(json){
                        console.log(json)
                        if(json.success){
                            jdId = json.jdId;
                            $("#jspIframe").attr("src","${ctx}/"+$("#jdAddr").val());
                        }else{
                            BUI.Message.Alert("运行失败，请重试！");
                        }
                    }
                });
            });

        })



    </script>
</body>

</html>