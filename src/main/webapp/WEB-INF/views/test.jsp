<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
</head>
<body>
<div class="container" style="height:auto;">
    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">题目：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="testTitle">
                </div>
            </div>
            <div class="control-group span8">
                <label class="control-label">答案：</label>
                <div class="controls">
                    <select class="input-small" name="testAnswer">
                        <option value="" selected="selected">请选择</option>
                        <option value="1">A</option>
                        <option value="2">B</option>
                        <option value="3">C</option>
                        <option value="4">D</option>
                    </select>
                </div>
            </div>
            <div class="control-group span9">
                <label class="control-label">创建时间：</label>
                <div class="controls">
                    <input type="text" class="calendar" name="startDate">
                    <span> - </span>
                    <input type="text" class="calendar" name="endDate">
                </div>
            </div>
            <div class="span3 offset2">
                <button type="button" id="btnSearch" class="button button-primary">搜索</button>
            </div>
        </div>
    </form>

    <div class="search-grid-container">
        <div id="grid"></div>
    </div>

    <div id="content" class="hide">
        <form id="J_Form" class="form-horizontal">
            <input type="hidden" name="testId">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>题目：</label>
                    <div class="controls">
                        <input name="testTitle" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>选项A：</label>
                    <div class="controls">
                        <input name="testOptionA" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>选项B：</label>
                    <div class="controls">
                        <input name="testOptionB" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>选项C：</label>
                    <div class="controls">
                        <input name="testOptionC" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>选项D：</label>
                    <div class="controls">
                        <input name="testOptionD" type="text" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>答案：</label>
                    <div class="controls bui-form-group-select">
                        <select class="input-small" name="testAnswer" id="testAnswer">
                            <option value="" selected="selected">请选择</option>
                            <option value="1">A</option>
                            <option value="2">B</option>
                            <option value="3">C</option>
                            <option value="4">D</option>
                        </select>
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>
<br><br><br><br>
<script type="text/javascript">
    BUI.use(['common/search','bui/list','bui/picker','bui/select'],function (Search,List,Picker,Select) {
        var
                enumTestAnswer = {0:"无",1:"A",2:"B",3:"C",4:"D"},
                columns = [
                    { title: '题目', width: 300, dataIndex: 'testTitle'},
                    { title: '选项A', width: 120, dataIndex: 'testOptionA'},
                    { title: '选项B', width: 120, dataIndex: 'testOptionB'},
                    { title: '选项C', width: 120, dataIndex: 'testOptionC'},
                    { title: '选项D', width: 120, dataIndex: 'testOptionD'},
                    { title: '答案', width: 40, dataIndex: 'testAnswer',renderer:BUI.Grid.Format.enumRenderer(enumTestAnswer)},
                    { title: '添加时间', width: 150, dataIndex: 'addTime'}
                ],
                store = Search.createStore('${ctx}/test/list',{pageSize:15}),
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
                                text: '<i class="icon-edit"></i>删除',
                                listeners : {
                                    'click' : delFunction
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

        editing.on("editorshow",function(ev){
            var record = editing.get('record');
        })

        function addFunction(){
            editing.add({state:1});
        }
        function editFunction(){
            var selections = grid.getSelection();
            if(selections.length==0){
                BUI.Message.Alert("请选中一条记录！");
            }

            editing.edit(selections[0]);
            $("#testAnswer").val(selections[0].testAnswer);
        }

        function delFunction(){
            var selections = grid.getSelection();
            if(selections.length>=1){
                var ids = [];
                BUI.each(selections,function(item){
                    ids.push(item.testId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录么？',function(){
                        $.ajax({
                            url : '${ctx}/test/delete',
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

        function submit(record,editor){
            console.log(record);
            $.ajax({
                url : (record.testId==''||record.testId==undefined)?'${ctx}/test/add':'${ctx}/test/update',
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
    });//seajs end
</script>
<!-- script end -->
</body>
</html>