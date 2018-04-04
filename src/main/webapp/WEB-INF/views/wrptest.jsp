<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<%@include file="../layouts/default.jsp"%>
<body>
<div class="container" style="height:auto;">
    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">课程别名：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="cName">
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



    <%--学生出勤信息--%>
    <div id="J_StudentAttendanceContent" class="hide">
        <div class="panel panel-small">
            <div class="row">
                <div class="control-group span5">
                    <div class="controls">
                        <label class="control-label">学号：</label>
                        <input type="text" class="control-text" id="sNo">
                    </div>
                </div>
                <div class="span6">
                    <button type="button" id="btnSearchAttendance" class="button button-primary">搜索</button>
                    <button type="button" id="exportAttendance" class="button button-primary">导出数据</button>
                </div>
            </div><br>
            <div id="J_AttendanceContentGrid" ></div>
        </div>
    </div>

    <%--学生作业提交信息--%>
    <div id="J_StudentWorkContent" class="hide">
        <div class="panel panel-small">
            <div class="row">
                <div class="control-group span5">
                    <div class="controls">
                        <label class="control-label">学号：</label>
                        <input type="text" class="control-text" id="sNo2">
                    </div>
                </div>
                <div class="span6">
                    <button type="button" id="btnSearchAttendance2" class="button button-primary">搜索</button>
                    <button type="button" id="exportWork" class="button button-primary">导出数据</button>
                </div>
            </div><br>
            <div id="J_WorkContentGrid" ></div>
        </div>
    </div>
    <iframe id="iframe" name="iframe" src="" style="display: none;"></iframe>
</div>
<br><br><br><br>
<script type="text/javascript">
    var CID;
    BUI.use(['common/search','bui/list','bui/picker','bui/select','bui/data','bui/grid','bui/overlay'],function (Search,List,Picker,Select,Data,Grid,Overlay) {
        var
                columns = [
                    { title: '课程号', width: 50, dataIndex: 'cId'},
                    { title: '课程别名', width: 200, dataIndex: 'cName'},
                    { title: '教师', width: 80, dataIndex: 'nickName'},
                    { title: '操作', width: 300, dataIndex: 'cId',renderer : function(value,obj){
                        var returnStr = '<span class="grid-command attendance">出勤统计</span>&nbsp;&nbsp;';
                        returnStr += '<span class="grid-command work">作业提交统计</span>&nbsp;&nbsp;';
                        return returnStr;
                    }}
                ],
                store = Search.createStore('${ctx}/course/list',{pageSize:15}),
                editing = new BUI.Grid.Plugins.DialogEditing({
                    contentId : 'content',
                    triggerCls : 'btn-edit'
                }),
                gridCfg = Search.createGridCfg(columns);
        var  search = new Search({
                    store : store,
                    gridCfg : gridCfg
                }),
                grid = search.get('grid');
        grid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');

        editing.on("editorshow",function(ev){
            var record = editing.get('record');
        });




/*********************出勤*****************************************************/

    var Grid = Grid,
        Store = Data.Store,
        studentAttendanceColumns = [
            { title: '学号', width: 120, dataIndex: 'sNo'},
            { title: '姓名', width: 100, dataIndex: 'sName'},
            { title: '未点名次数', width: 50, dataIndex: 'sId',renderer:function(value,obj){
                return showAttendance(0,obj.attendances,obj.attendanceInfos);
            }},
            { title: '出勤', width: 50, dataIndex: 'sId',renderer:function(value,obj){
                return showAttendance(1,obj.attendances,obj.attendanceInfos);
            }},
            { title: '旷课', width: 50, dataIndex: 'sId',renderer:function(value,obj){
                return showAttendance(2,obj.attendances,obj.attendanceInfos);
            }},
            { title: '迟到', width: 50, dataIndex: 'sId',renderer:function(value,obj){
                return showAttendance(3,obj.attendances,obj.attendanceInfos);
            }},
            { title: '早退', width: 50, dataIndex: 'sId',renderer:function(value,obj){
                return showAttendance(4,obj.attendances,obj.attendanceInfos);
            }},
            { title: '是否满勤', width: 70, dataIndex: 'sId',renderer:function(value,obj){
                return isAttendanceOver(obj.attendances,obj.attendanceInfos);
            }}
        ];
        var AttendanceParams = {
            cId:'',
            cNo:''
        };
        var studentAttendanceStore = new Store({
                    url : '${ctx}/courseStudent/attendanceList',
                    pageSize:10,
                    params : { }
                }),
                studentAttendanceGrid = new Grid.Grid({
                    render:'#J_AttendanceContentGrid',
                    columns : studentAttendanceColumns,
                    itemStatusFields : {
                        selected : 'selected',
                        disabled : 'disabled'
                    },
                    store : studentAttendanceStore,
                    bbar:{
                        pagingBar:true
                    }
                });
        studentAttendanceGrid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');
        //创建弹出框（学生列表）
        var attendanceDialog;
        function createAttendanceDialog(){
            return new Overlay.Dialog({
                title:'学生列表',
                width:850,
                height:500,
                contentId:'J_StudentAttendanceContent',
                success:function () {
                    var me = this;
                    me.close();
                }
            });
        }

        //搜索学生
        $("#btnSearchAttendance").click(function(){
            AttendanceParams.sNo = $('#sNo').val();
            studentAttendanceStore.load(AttendanceParams);
        });


/******************作业提交************************************************************/

    var studentWorkColumns = [
        { title: '学号', width: 120, dataIndex: 'sNo'},
        { title: '姓名', width: 100, dataIndex: 'sName'},
        { title: '未录入', width: 50, dataIndex: 'sId',renderer:function(value,obj){
            return showWork(0,obj.works,obj.workInfos);
        }},
        { title: '已交', width: 50, dataIndex: 'sId',renderer:function(value,obj){
            return showWork(1,obj.works,obj.workInfos);
        }},
        { title: '未交', width: 50, dataIndex: 'sId',renderer:function(value,obj){
            return showWork(2,obj.works,obj.workInfos);
        }},
        { title: '漏交', width: 50, dataIndex: 'sId',renderer:function(value,obj){
            return showWork(3,obj.works,obj.workInfos);
        }},
        { title: '是否满交', width: 70, dataIndex: 'sId',renderer:function(value,obj){
            return isWorkOver(obj.works,obj.workInfos);
        }}
        ];
        var WorkParams = {
            cId:'',
            cNo:''
        };
        var studentWorkStore = new Store({
                    url : '${ctx}/courseStudent/workList',
                    pageSize:10,
                    params : { }
                }),
                studentWorkGrid = new Grid.Grid({
                    render:'#J_WorkContentGrid',
                    columns : studentWorkColumns,
                    itemStatusFields : {
                        selected : 'selected',
                        disabled : 'disabled'
                    },
                    store : studentWorkStore,
                    bbar:{
                        pagingBar:true
                    }
                });
        studentWorkGrid.set("emptyDataTpl",'<div class="centered"><img alt="Crying" src="${ctx}/img/merchandise/origonal/no_pic.png"><h2>没有数据哦</h2></div>');
        //创建弹出框（学生列表）
        var workDialog;
        function createWorkDialog(){
            return new Overlay.Dialog({
                title:'学生列表',
                width:850,
                height:500,
                contentId:'J_StudentWorkContent',
                success:function () {
                    var me = this;
                    me.close();
                }
            });
        }

        //搜索学生
        $("#btnSearchAttendance2").click(function(){
            WorkParams.sNo = $('#sNo2').val();
            studentWorkStore.load(WorkParams);
        });

/*****************操作**************************************************************/
    grid.on('cellclick',function  (ev) {
        var record = ev.record, //点击行的记录
                field = ev.field, //点击对应列的dataIndex
                target = $(ev.domTarget); //点击的元素
        CID = record.cId;
        if(target.hasClass('attendance')){
            if(!attendanceDialog){
                attendanceDialog = createAttendanceDialog();
                studentAttendanceGrid.render();

            }
            AttendanceParams.cId = record.cId;
            studentAttendanceStore.load(AttendanceParams);
            attendanceDialog.show();
        }else if(target.hasClass('work')){
            if(!workDialog){
                workDialog = createWorkDialog();
                studentWorkGrid.render();

            }
            WorkParams.cId = record.cId;
            studentWorkStore.load(WorkParams);
            workDialog.show();
        }
    });

    //展示出勤
    function showAttendance(i,attendances,attendanceInfos){
        var index = -1;
        var attendancesArray = attendances.split(',');
        for(var j=0;j<attendancesArray.length;j++){
            if(i==attendancesArray[j]){
                index = j;
            }
        }
        if(index==-1){
            return 0+'次';
        }else{
            var attendanceInfosArray = attendanceInfos.split(',');
            return attendanceInfosArray[index]+'次';
        }
    }

        //判断是否满勤
        function isAttendanceOver(attendances,attendanceInfos){
            var index = -1;
            var attendancesArray = attendances.split(',');
            for(var j=0;j<attendancesArray.length;j++){
                if(1==attendancesArray[j]){
                    index = j;
                }
            }

            var sum = 0;
            var attendanceInfosArray = attendanceInfos.split(',');
            for(var i=0;i<attendanceInfosArray.length;i++){
                sum += parseInt(attendanceInfosArray[i]);
            }

            if(sum>0){
                if(index==-1){
                    return "未满勤";
                }else{
                    if(sum==attendanceInfosArray[index]){
                        return "满勤";
                    }else{
                        return "未满勤";
                    }
                }
            }
        }

        //展示作业提交
        function showWork(i,works,workInfos){
            var index = -1;
            var worksArray = works.split(',');
            for(var j=0;j<worksArray.length;j++){
                if(i==worksArray[j]){
                    index = j;
                }
            }
            if(index==-1){
                return 0+'次';
            }else{
                var workInfosArray = workInfos.split(',');
                return workInfosArray[index]+'次';
            }
        }

        //判断是否满交
        function isWorkOver(works,workInfos){
            var index = -1;
            var worksArray = works.split(',');
            for(var j=0;j<worksArray.length;j++){
                if(1==worksArray[j]){
                    index = j;
                }
            }

            var sum = 0;
            var workInfosArray = workInfos.split(',');
            for(var i=0;i<workInfosArray.length;i++){
                sum += parseInt(workInfosArray[i]);
            }

            if(sum>0){
                if(index==-1){
                    return "未满交";
                }else{
                    if(sum==workInfosArray[index]){
                        return "满交";
                    }else{
                        return "未满交";
                    }
                }
            }
        }

        /************************导出数据****************************************/
        $("#exportAttendance").click(function(){
            $.ajax({
                url : '${ctx}/courseStudent/exportAttendance',
                type:'post',
                dataType : 'json',
                data : {cId:CID},
                success : function(data){
                    $("#iframe").attr("src","${ctx}/courseStudent/downFile?fileName="+data.fileName);
                }
            });
        });
        $("#exportWork").click(function(){
            $.ajax({
                url : '${ctx}/courseStudent/exportWork',
                type:'post',
                dataType : 'json',
                data : {cId:CID},
                success : function(data){
                    $("#iframe").attr("src","${ctx}/courseStudent/downFile?fileName="+data.fileName);
                }
            });
        });

    });//seajs end
</script>
<!-- script end -->
</body>
</html>