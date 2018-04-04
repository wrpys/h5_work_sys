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

        #menuContent{position: relative;}
        #treeDemo{position:absolute;z-index: 999;background-color: #fff;border:1px solid #CCCCCC;}
    </style>
</head>
<body>
    <div class="top">

        <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
            <ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height: 200px;overflow: scroll;"></ul>
        </div>
        <label style="position: relative;top: -14px;"><s style="color: #ff0000;">*</s>运行路径：</label>
        <input id="jdlLink" type="hidden" value="">
        <input style="position: relative;top: -14px;" id="jdlName" type="text" value="" readonly="true" data-rules="{required:true}">

        <input id="jdAddr"  name="jdAddr" type="hidden" value="">
        <iframe width="62" height="30" frameborder="0" scrolling="no" class="iframe-file-upload" src="${ctx}/static/jspUpload/jsp/uploadExcel.jsp"></iframe>
        <span id="fileName" style="display: inline-block;position: relative;top: -15px;"></span>
        <button class="button" id="runBnt" style="display:none;position: relative;top: -15px;">运行</button>
    </div>
    <div class="mid">
        <iframe id="jspIframe" width="100%" height="100%" frameborder="0" src=""></iframe>
    </div>
    <div class="bottom">
        注：运行需要实体的JSP页面，实体格式由教师提供。
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
    BUI.use(['common/search','bui/form','ztree/ztree'],function(Search,Form){
            //选择框树
        var settingTemp = {
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            view: {
                dblClickExpand: false
            },
            data:{
                key:{
                    name:'jdlName'
                },
                simpleData:{
                    enable:true,
                    idKey:'jdlId',
                    pIdKey:'jdlPid'
                }
            },
            callback: {
                onClick: onClickTemp,
                onCheck: onCheck
            }
        };
        <%--var zNodes =${fileTypes};--%>
        function onClickTemp(e, treeId, treeNode) {
            var zTreeTemp = $.fn.zTree.getZTreeObj("treeDemo");
            zTreeTemp.checkNode(treeNode, !treeNode.checked, null, true);
            return false;
        }
        function onCheck(e, treeId, treeNode) {
            if(treeNode.isParent){
                return false;
            }
            var zTreeTemp = $.fn.zTree.getZTreeObj("treeDemo"),
                    nodes = zTreeTemp.getCheckedNodes(true),
                    v = "";
            for (var i=0, l=nodes.length; i<l; i++) {
                v += nodes[i].jdlName + ",";
            }
            if (v.length > 0 ) v = v.substring(0, v.length-1);
            $("#jdlName").val(v);
            if(v!=''){
                $("#jdlLink").val(treeNode.getParentNode().jdlLink+'/'+treeNode.jdlLink);
            }else{
                $("#jdlLink").val("");
            }
        }
        function showMenu() {
            var cityObj = $("#jdlName");
            var cityOffset = $("#jdlName").offset();
            $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
            $("body").bind("mousedown", onBodyDown);
        }

        function hideMenu() {
            $("#menuContent").fadeOut("fast");
            $("body").unbind("mousedown", onBodyDown);
        }
        function onBodyDown(event) {
            if (!(event.target.id == "jdlName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                hideMenu();
            }
        }
        //树初始化
        $.fn.zTree.init($("#treeDemo"), settingTemp, ${jspDetectLinks});
        $('#jdlName').click(function(){
            console.log("ok");
            showMenu();
        });

            $("#runBnt").click(function(){
                var jdLink = $("#jdlLink").val();
                if(jdLink==''||jdLink==null){
                    BUI.Message.Alert("请选择运行路径！");
                    return;
                }
                var data = {
                    jdAddr : $("#jdAddr").val(),
                    jdLink:$("#jdlLink").val(),
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
                            $("#jspIframe").attr("src","${ctx}/"+$("#jdlLink").val()+"?jdAddr="+$("#jdAddr").val());
                        }else{
                            BUI.Message.Alert("运行失败，请重试！");
                        }
                    }
                });
            });
    });



    </script>
</body>

</html>