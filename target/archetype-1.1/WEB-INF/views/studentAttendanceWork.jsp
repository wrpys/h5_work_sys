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
                <label class="control-label">课程名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="cName">
                </div>
            </div>
            <div class="control-group span9">
                <label class="control-label">上课时间：</label>
                <div class="controls">
                    <input type="text" class="calendar" name="ctTime">
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
            <input type="hidden" name="ciId">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>状态：</label>
                    <div class="controls" id="attendanceInfoList">
                        <input type="radio" name="attendanceInfo" value="1">出勤
                        <input type="radio" name="attendanceInfo" value="2">旷课
                        <input type="radio" name="attendanceInfo" value="3">迟到
                        <input type="radio" name="attendanceInfo" value="4">早退
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>状态：</label>
                    <div class="controls" id="workInfoList">
                        <input type="radio" name="workInfo" value="1">已交
                        <input type="radio" name="workInfo" value="2">未交
                        <input type="radio" name="workInfo" value="3">漏交
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>
<br><br><br><br>
<script type="text/javascript">
    BUI.use(['common/search','bui/list','bui/picker','bui/select'],function (Search,List,Picker,Select) {
        var weekDay = ["星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        var enumWork = {"0":"未记录","1":"已交","2":"未交","3":"漏交"};
        var enumAttendance = {"0":"未点名","1":"出勤","2":"旷课","3":"迟到","4":"早退"};
        var columns = [
                    { title: '学号', width: 100, dataIndex: 'sNo'},
                    { title: '姓名', width: 80, dataIndex: 'sName'},
                    { title: '课程号', width: 50, dataIndex: 'cId'},
                    { title: '课程名', width: 200, dataIndex: 'cName'},
                    { title: '上课时间', width: 200, dataIndex: 'ctTime',renderer : function(value){
                        var dateStr = value.substring(0,10);
                        var myDate = new Date(Date.parse(dateStr.replace(/-/g, "/")));
                        return dateStr+'&nbsp;--&nbsp;'+weekDay[myDate.getDay()];
                    }},
                    { title: '出勤状态', width: 80, dataIndex: 'attendanceInfo',renderer:BUI.Grid.Format.enumRenderer(enumAttendance)},
                    { title: '作业提交状态', width: 80, dataIndex: 'workInfo',renderer:BUI.Grid.Format.enumRenderer(enumWork)}
                ],
                store = Search.createStore('${ctx}/courseStudent/studentAttendanceWorkList',{pageSize:15}),
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
                                text: '<i class="icon-edit"></i>修改',
                                listeners : {
                                    'click' : editFunction
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
        function editFunction(){
            var selections = grid.getSelection();
            if(selections.length==0){
                BUI.Message.Alert("请选中一条记录！");
            }
            editing.edit(selections[0]);
            $("#workInfoList").find('input[value="'+selections[0].workInfo+'"]').prop("checked",true);
            $("#attendanceInfoList").find('input[value="'+selections[0].attendanceInfo+'"]').prop("checked",true);
        }

        function submit(record,editor){
            if(record.sId==''||record.cId==''){
                BUI.Message.Alert('修改失败');
            }
            $.ajax({
                url : '${ctx}/courseStudent/updateAttendance',
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