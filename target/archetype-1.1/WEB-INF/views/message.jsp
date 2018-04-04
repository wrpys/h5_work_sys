<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <style>
        #replyContentList{padding: 10px 10px;height: 380px;overflow-y: scroll;overflow-x: hidden;}
        .student{color: #62A7F9;}
        .teacher{color: #008040;}
    </style>
</head>
<body>
<div class="container">
    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">学号：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="sNo">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">姓名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="studentName">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">教师姓名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="teacherName">
                </div>
            </div>
            <div class="control-group span9">
                <label class="control-label">留言时间：</label>
                <div class="controls">
                    <input type="text" class="calendar" name="startDate">
                    <span> - </span>
                    <input type="text" class="calendar" name="endDate">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">是否回复：</label>
                <div class="controls">
                    <select name="msgIsRead">
                        <option value="">请选择</option>
                        <option value="1">回复</option>
                        <option value="0">未回复</option>
                    </select>
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">是否回复：</label>
                <div class="controls">
                    <select name="msgIsRead">
                        <option value="">请选择</option>
                        <option value="1">回复</option>
                        <option value="0">未回复</option>
                    </select>
                </div>
            </div>
            <div class="span3 offset2">
                <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
            </div>
        </div>
    </form>

    <div class="search-grid-container">
        <div id="grid"></div>
    </div>
</div>

<div id="J_ContentReply" class="hide">
    <div id="J_ContentGrid" >
        <ul id="replyContentList">
        </ul>
    </div>
    <div class="control-group" style="text-align: right;padding-right:20px;margin-top: 10px;">
        <input id="msgId" type="hidden" value="">
        <input id="replyContent" type="text" style="width: 360px;"><i id="icon-hint"></i>
        <button class="button button-primary" id="replyButton" data-rules="{required:true}">回复</button>
    </div>
</div>

<script type="text/javascript">
    var replyFun;
    BUI.use(['bui/calendar','bui/overlay','common/search','bui/list','bui/picker','bui/select','bui/grid','bui/data'],function (Calendar,Overlay,Search,List,Picker,Select,Grid,Data) {
        var
                msgIsReadEnum = {"0":"否","1":"是"},
                columns = [
                    { title : '学号', width: 100, dataIndex: 'sNo'},
                    { title : '学生姓名', width: 100, dataIndex: 'studentName'},
                    { title : '教师姓名', width: 100, dataIndex: 'teacherName'},
                    { title : '留言内容', width: 300, dataIndex: 'msgContent'},
                    { title : '留言时间', width: 150, dataIndex: 'msgAddTime'} ,
                    { title : '是否已读', width: 70, dataIndex: 'msgIsRead',renderer:BUI.Grid.Format.enumRenderer(msgIsReadEnum)},
                    { title : '是否回复', width: 70, dataIndex: 'msgIsReply',renderer:function(value,obj){
                        var str = '<a onclick="replyFun(\''+obj.msgId+'\');">回复</a>';
                        return str;
                    }}
                ],
                store = Search.createStore('${ctx}/message/list',{pageSize:10}),
                editing = new BUI.Grid.Plugins.DialogEditing({
                    contentId : 'content',
                    triggerCls : 'btn-edit'
                }),
                gridCfg = Search.createGridCfg(columns,{
                    plugins: [BUI.Grid.Plugins.CheckSelection,editing,BUI.Grid.Plugins.AutoFit] //勾选插件
                });
        var  search = new Search({
                    store : store,
                    gridCfg : gridCfg
                }),
                grid = search.get('grid');
        grid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');

        //创建弹出框
        function createReplyDialog(){
            return new Overlay.Dialog({
                title:'留言回复列表',
                width:500,
                height:500,
                contentId:'J_ContentReply',
                success:function () {
                    search.load();
                    this.close();
                }
            });
        }

        //查看及回复审核
        var replyDialog;
        replyFun=function(msgId){
            if(!replyDialog){
                replyDialog = createReplyDialog();
            }
            findReplyList(msgId);
            replyDialog.show();
        }

        function findReplyList(msgId){
            $.ajax({
                url : '${ctx}/message/getMessageByMsgId',
                dataType : 'json',
                type:'post',
                data : {msgId:msgId},
                success : function(data){
                    var liContent="";
                    $.each(data,function(index,element){
                        if(element.sendRole==${studentRole}){
                            $("#msgId").val(element.msgId);
                            liContent+="<li><p class='student'>" + element.studentName +
                                    '(' + element.roleName + ')&nbsp;&nbsp;' +
                                    element.msgAddTime + "</p>";
                            liContent+="<span>"+element.msgContent+"</span></li>";
                        }else if(element.sendRole==${teacherRole}){
                            liContent+="<li><p class='teacher'>" + element.teacherName +
                                    '(' + element.roleName + ')&nbsp;&nbsp;' +
                                    element.msgAddTime + "</p>";
                            liContent+="<span>"+element.msgContent+"</span></li>";
                        }
                        var replyContentList=$("#replyContentList");
                        replyContentList.html(liContent);
                        replyContentList.scrollTop(10000);
                    });
                }
            });
        }

        //回复
        $("#replyButton").on('click',function(){
            var replyContent=$("#replyContent").val();
            if(replyContent==''){return ;}
            var msgId = $("#msgId").val();
            $.ajax({
                url : '${ctx}/message/add',
                dataType : 'json',
                type:'post',
                data : {msgId:msgId,msgContent:replyContent},
                success : function(data){
                    if(data.success){
                        findReplyList(msgId);
                        $("#replyContent").val('')
                    }else{ //编辑失败
                        BUI.Message.Alert('回复失败！');
                    }
                }
            });
        });

    }); //-----BUI end-----

</script>
<!-- script end -->
</body>
</html>