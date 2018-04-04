<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
</head>
<body>
<div class="container">
    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">课程名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="cName">
                </div>
            </div>
            <div class="control-group span9">
                <label class="control-label">布置时间：</label>
                <div class="controls">
                    <input type="text" class="calendar" name="startDate">
                    <span> - </span>
                    <input type="text" class="calendar" name="endDate">
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

    <div id="content" class="hide">
        <form id="J_Form" class="form-horizontal">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>课程：</label>
                    <div class="controls">
                        <select  name="cId" data-rules="{required:true}">
                            <option value="">请选择</option>
                            <c:forEach items="${courses}" var="course">
                                <option value="${course.cId}">${course.cName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8" style="height: 200px;">
                    <label class="control-label"><s>*</s>作业描述：</label>
                    <div class="controls">
                        <textarea name="wDesc" style="height: 150px;"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <%--上课时间-出勤和作业提交--%>
    <div id="J_WorkInfoContent" class="hide">
        <div class="panel panelHeight">
            <div id="J_WorkInfoContentGrid" ></div>
        </div>
    </div>

</div>
<script type="text/javascript">
BUI.use(['common/search','bui/list','bui/picker','bui/select','bui/calendar','bui/overlay','bui/data','bui/grid','bui/calendar'],function (Search,List,Picker,Select,Calendar,Overlay,Data,Grid,Calendar) {
        var columns = [
                { title : '课程名', width: 150, dataIndex: 'cName'},
                { title : '布置时间', width: 150, dataIndex: 'wAddTime'},
                { title : '作业描述', width: 400, dataIndex: 'wDesc'},
                { title: '操作', width: 300, dataIndex: 'cId',renderer : function(value,obj){
                    var returnStr = '<span class="grid-command searchWorkInfo">查看提交情况</span>';
                    return returnStr;
                }}

             ],
                store = Search.createStore('${ctx}/work/list',{pageSize:10}),
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
                        ]
                    },
                    plugins: [BUI.Grid.Plugins.CheckSelection,editing,BUI.Grid.Plugins.AutoFit] //勾选插件
                });
        var  search = new Search({
                    store : store,
                    gridCfg : gridCfg
                }),
                grid = search.get('grid');
                grid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');

        function addFunction(){
            editing.add({state:1}); //添加记录后，直接编辑
        }

        function editFunction(){
            var selections = grid.getSelection();
            if(selections.length==1){
                editing.edit(selections[0]);
            }else{
                BUI.Message.Alert("请选中一条记录！");
            }
        }

        function delFunction(){
            var selections = grid.getSelection();
            if(selections.length>=1){
                var ids = [];
                BUI.each(selections,function(item){
                    ids.push(item.wId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录么？',function(){
                        $.ajax({
                            url : '${ctx}/work/delete',
                            type:'post',
                            dataType : 'json',
                            data : {ids : ids.join(',')},
                            success : function(data){
                                if(data.success){ //删除成功
                                    search.load();
                                }else{ //删除失败
                                    if(data.url==null||data.url==''){
                                        BUI.Message.Alert('删除失败！');
                                    }else{
                                        BUI.Message.Confirm(data.msg,function(){
                                            window.parent.tabTemp.addTab({
                                                id: 46,
                                                title: '首页管理',
                                                href: data.url
                                            }, true);
                                        },'question');
                                    }
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
            $.ajax({
                url : (record.wId==undefined||record.wId==null||record.wId=='')?'${ctx}/work/add':'${ctx}/work/update',
                dataType : 'json',
                type:'post',
                data : record,
                success : function(data){
                    if(data.success){ //编辑、新建成功
                        editor.accept(); //隐藏弹出框
                        search.load();
                    }else{ //编辑失败
                        var msg = data.msg;
                        BUI.Message.Alert('错误原因:' + msg);
                    }
                }
            });
        }

        /*****************************操作及查看作业提交情况******************************************************/
        var Grid = Grid,
             Store = Data.Store;
        var
                WorkInfoColumns = [
                    { title: '学号', width: 100, dataIndex: 'sNo'},
                    { title: '姓名', width: 80, dataIndex: 'sName'},
                    { title: '提交时间', width: 130, dataIndex: 'wiAddTime'},
                    { title: '文件名', width: 200, dataIndex: 'wiFileName'},
                    { title: '作业描述', width: 300, dataIndex: 'wIDesc'},
                    { title: '操作', width: 120, dataIndex: 'wiId',renderer:function(value,obj){
                        var returnStr ="未提交";
                        if(value!==null&&value!=undefined&&value!=''){
                            returnStr = "<a href='${ctx}/work/downWorkInfoFile?wiId="+value+"'>下载</a>";
                        }
                        return returnStr;
                    }}
                ];
        var WorkInfoParams = {
            wId:null
        };
        var WorkInfoStore = new Store({
                    url : '${ctx}/work/getWorkInfoByWId',
                    pageSize:10,
                    params : WorkInfoParams
                }),
                WorkInfoGrid = new Grid.Grid({
                    render:'#J_WorkInfoContentGrid',
                    columns : WorkInfoColumns,
                    itemStatusFields : { //设置数据跟状态的对应关系
                        selected : 'selected',
                        disabled : 'disabled'
                    },
                    store : WorkInfoStore,
                    bbar:{
                        pagingBar:true
                    }
                });

        //创建弹出框（学生选课）
        var WorkInfoDialog;
        function createWorkInfoDialog(){
            return new Overlay.Dialog({
                title:'上课时间列表',
                width:980,
                height:500,
                contentId:'J_WorkInfoContent',
                success:function () {
                    this.close();
                }
            });
        }


        grid.on('cellclick',function  (ev) {
            var record = ev.record, //点击行的记录
                    field = ev.field, //点击对应列的dataIndex
                    target = $(ev.domTarget); //点击的元素
            if(target.hasClass('searchWorkInfo')){
                console.log("ok")
                if(!WorkInfoDialog){
                    WorkInfoDialog = createWorkInfoDialog();
                    WorkInfoGrid.render();
                }
                WorkInfoParams.wId = record.wId;
                WorkInfoStore.load(WorkInfoParams);
                WorkInfoDialog.show();
            }
        });



    }); //-----BUI end-----
</script>
<!-- script end -->
</body>
</html>