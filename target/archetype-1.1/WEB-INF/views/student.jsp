<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <style>
        .importBtn{display: none;}
    </style>
</head>
<body>
<div class="container" style="height:auto;">
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
                    <input type="text" class="control-text" name="sName">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">性别：</label>
                <div class="controls">
                    <select name="sSex">
                        <option value="">请选择</option>
                        <option value="0">男</option>
                        <option value="1">女</option>
                    </select>
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">专业：</label>
                <div class="controls bui-form-group-select">
                    <select class="input-small" onchange="getChild(this,1);">
                        <option value="" selected="selected">系别</option>
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.dId}">${department.dName}</option>
                        </c:forEach>
                    </select>&nbsp;&nbsp;
                    <select class="input-small" value="" name="dId" id="dId2">
                        <option value="" selected="selected">专业</option>
                    </select>
                </div>
            </div>
            <div class="span3 offset2">
                <button type="button" id="btnSearch" class="button button-primary">搜索</button>
            </div>
        </div>
    </form>
    <%--xls文件导入--%>
    <div class="row">
        <input type="hidden" id="excel_fileName" value="" />
        <span style="margin-left: 20px;">通过xls文件导入:
            <button class="button button-small" id="showXls">xls文件模板</button>
            <iframe frameborder="0" width="62" height="24" style="position: relative;top: 7px;" scrolling="no" class="iframe-excel-upload"
                    src="${ctx}/static/excelUpload/jsp/uploadExcel.jsp"></iframe>
            <span id="excel_realName"></span>
            <button class="button button-small importBtn" onclick="xlsImport();">确认导入</button>
        </span>
    </div>
    <div class="search-grid-container">
        <div id="grid"></div>
    </div>

    <div id="content" class="hide">
        <form id="J_Form" class="form-horizontal">
            <input type="hidden" name="sId">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>学号：</label>
                    <div class="controls">
                        <input name="sNo" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>姓名：</label>
                    <div class="controls">
                        <input name="sName" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label">性别：</label>
                    <div class="controls">
                        <label class="radio"><input name="sSex" id="sSex1" type="radio" value="0" checked />男</label>&nbsp;&nbsp;&nbsp;
                        <label class="radio"><input name="sSex" id="sSex2" type="radio" alue="1"/>女</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>专业：</label>
                    <div class="controls bui-form-group-select">
                        <select class="input-small" id="dPid" onchange="getChild(this,2);">
                            <option value="" selected="selected">系别</option>
                            <c:forEach items="${departments}" var="department">
                                <option value="${department.dId}">${department.dName}</option>
                            </c:forEach>
                        </select>&nbsp;&nbsp;
                        <select class="input-small" value="" name="dId" id="dId" data-rules="{required:true}">
                            <option value="" selected="selected">专业</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>年级：</label>
                    <div class="controls">
                        <input name="grade" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>班级：</label>
                    <div class="controls">
                        <input name="sClass" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
        </form>
    </div>

    <%--学生xls模板--%>
    <div id="J_StudentContent" class="hide">
            <img src="${ctx}/img/merchandise/origonal/studentTemp.png" width="450" height="100" style="width: 450px;height: 100px;max-width: 450px;max-height: 100px;"/>
    </div>

</div>
<br><br><br><br>
<script type="text/javascript">

//上传文件的回显,显示导入按钮
function displayFileName(excel_fileName,excel_realName){
    $('#excel_realName').html("文件： "+excel_realName);
    $('#excel_fileName').val(excel_fileName);
    $('.importBtn').show(); //如果有xls导入的功能
}

//导入xls数据到数据库 (如果需要将xls数据导入到数据库)
function xlsImport(){
    var data = {
        excel_fileName : $('#excel_fileName').val()
    };
    $.ajax({
        url : '${ctx}/student/importStudet',
        type:'post',
        dataType : 'json',
        data : data,
        success : function(data){
            $('#excel_realName').html("");
            $('#excel_fileName').val("");
            $('.importBtn').hide(); //如果有xls导入的功能
            if(data.success){ //导入成功
                searchTemp.load();
            }else{ //导入失败
                BUI.Message.Alert(data.msg,'error');
            }
        }
    });

}
    var searchTemp;
    BUI.use(['common/search','bui/list','bui/picker','bui/select','bui/overlay'],function (Search,List,Picker,Select,Overlay) {
        var
                enumSex = {"true":"女","false":"男"},
                columns = [
                    { title: '学号', width: 150, dataIndex: 'sNo'},
                    { title: '姓名', width: 100, dataIndex: 'sName'},
                    { title: '性别', width: 100, dataIndex: 'sSex',renderer:BUI.Grid.Format.enumRenderer(enumSex)},
                    { title: '专业', width: 100, dataIndex: 'dName'},
                    { title: '年级', width: 100, dataIndex: 'grade'},
                    { title: '班级', width: 100, dataIndex: 'sClass'}
                ],
                store = Search.createStore('${ctx}/student/list',{pageSize:10}),
                editing = new BUI.Grid.Plugins.DialogEditing({
                    contentId : 'content',
                    triggerCls : 'btn-edit',
                    editor : {
                        success : function(){ //点击确认的时候触发，可以进行异步提交
                            var editor = this,
                                    record = editing.get('record'),
                                    data = editor.get('form').serializeToObject();
                            editor.valid();
                            if(editor.isValid()){
                                submit(BUI.mix(record,data),editor);
                            }
                        }
                    }
                }),
                gridCfg = Search.createGridCfg(columns,{
                    tbar: {
                        items: [
                            {
                                btnCls: 'button button-small',
                                text: '<i class="icon-plus"></i>添加',
                                listeners : {
                                    'click' : addFunction
                                }
                            },{
                                btnCls: 'button button-small',
                                text: '<i class="icon-edit"></i>修改',
                                listeners : {
                                    'click' : editFunction
                                }
                            },{
                                btnCls: 'button button-small',
                                text: '<i class="icon-remove"></i>删除',
                                listeners : {
                                    'click' : delFunction
                                }
                            }
//                            ,{
//                                btnCls: 'button button-small',
//                                text: '<i class="icon-remove"></i>启用/禁用',
//                                listeners : {
//                                    'click' : changeFunction
//                                }
//                            }
                            ,{
                                btnCls: 'button button-small',
                                text: '<i class="icon-repeat"></i>重置密码',
                                listeners : {
                                    'click' : resetFunction
                                }
                            }
                        ]
                    },
                    plugins: [BUI.Grid.Plugins.CheckSelection,editing] //勾选插件
                });
        var  search = new Search({
                    store : store,
                    gridCfg : gridCfg
                }),
                grid = search.get('grid');
        grid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');
        searchTemp = search;
        editing.on("editorshow",function(ev){
            var record = editing.get('record');
        })

        function addFunction(){
            editing.add({state:1});
            $("#sSex1").prop("checked",true);
        }
        function editFunction(){
            var selections = grid.getSelection();
            if(selections.length!=1){
                BUI.Message.Alert("请选中一条记录！");
                return;
            }

            editing.edit(selections[0]);
            $("#dPid").val(selections[0].dPid);
            getChild($("#dPid option[value="+selections[0].dPid+"]"),2);
            $('#dId').val(selections[0].dId);
            console.log(selections[0])
            if(selections[0].sSex==false){
                $("#sSex1").prop("checked",true);
            }else{
                $("#sSex2").prop("checked",true);
            }
        }

        function delFunction(){
            var selections = grid.getSelection();
            if(selections.length>=1){
                var ids = [];
                BUI.each(selections,function(item){
                    ids.push(item.sId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录么？',function(){
                        $.ajax({
                            url : '${ctx}/student/delete',
                            type:'post',
                            dataType : 'json',
                            data : {ids : ids.join(',')},
                            success : function(data){
                                if(data.success){ //删除成功
                                    search.load();
                                }else{ //删除失败
                                    BUI.Message.Alert(data.msg,'error');
                                }
                            }
                        });
                    },'question');
                }
            }else{
                BUI.Message.Alert("未选中任何记录！");
            }
        }

        <%--function changeFunction(){--%>
            <%--var selections = grid.getSelection();--%>
            <%--if(selections.length==1){--%>
                <%--var selected = selections[0];--%>
                <%--var confirmStr = "确认要启用该用户？";--%>
                <%--if(selected.state==1){--%>
                    <%--confirmStr = "确认要禁用该用户？";--%>
                <%--}--%>
                <%--BUI.Message.Confirm(confirmStr,function(){--%>
                    <%--$.ajax({--%>
                        <%--url : '${ctx}/student/changeState',--%>
                        <%--type:'post',--%>
                        <%--dataType : 'json',--%>
                        <%--data : selected,--%>
                        <%--success : function(data){--%>
                            <%--if(data.success){--%>
                                <%--search.load();--%>
                                <%--BUI.Message.Alert('修改成功！');--%>
                            <%--}else{--%>
                                <%--BUI.Message.Alert('修改失败！');--%>
                            <%--}--%>
                        <%--}--%>
                    <%--});--%>
                <%--},'question');--%>
            <%--}else{--%>
                <%--BUI.Message.Alert("请选中一条记录！");--%>
            <%--}--%>
        <%--}--%>

        function resetFunction(){
            var selections = grid.getSelection();
            var ids = [];
            BUI.each(selections,function(item){
                ids.push(item.sId);
            });
            if(ids.length){
                BUI.Message.Confirm('确认要重置密码吗？',function(){
                    $.ajax({
                        url : '${ctx}/student/resetPassword',
                        type:'post',
                        dataType : 'json',
                        data : {ids : ids.join(',')},
                        success : function(data){
                            if(data.success){
                                BUI.Message.Alert('重置成功！');
                            }else{
                                BUI.Message.Alert('重置失败！');
                            }
                        }
                    });
                },'question');
            }
        }
        function submit(record,editor){
            console.log(record);
            $.ajax({
                url : record.sId==''?'${ctx}/student/add':'${ctx}/student/update',
                dataType : 'json',
                type:'post',
                data : record,
                success : function(data){
                    if(data.success){ //编辑、新建成功
                        editor.accept(); //隐藏弹出框
                        search.load();
                    }else{ //编辑失败
                        var msg = data.msg;
                        BUI.Message.Alert('提示:' + msg);
                    }
                }
            });
        }



        //xls模板
        var studentDialog;
        function createStudentDialog(){
            return new Overlay.Dialog({
                title:'xls模板',
                width:480,
                height:160,
                contentId:'J_StudentContent',
                success:function () {
                    this.close();
                }
            });
        }
        //显示
        $('#showXls').click(function(){
            if(!studentDialog){
                studentDialog = createStudentDialog();
            }
            studentDialog.show();
        });


    });//seajs end

    //系别专业级联
    function getChild(obj,i){
        var dPid = $(obj).val();
        if(dPid==null||dPid==''){
            $("#dId").empty().html('<option value="" selected="selected">专业</option>');
            return ;
        }
        $.ajax({
            url : '${ctx}/department/getDepartmentByDPid',
            async: false,
            dataType : 'json',
            type:'post',
            data : {dPid:dPid},
            success : function(data){
                var seleteHtml = '<option value="" selected="selected">专业</option>';
                $.each(data,function(i,value){
                    console.log(value)
                    seleteHtml += '<option value="'+value.dId+'">'+value.dName+'</option>';
                })
                if(i==1){$("#dId2").empty().html(seleteHtml);
                }else if(i==2){$("#dId").empty().html(seleteHtml); }
            }
        });
    }

</script>
<!-- script end -->
</body>
</html>