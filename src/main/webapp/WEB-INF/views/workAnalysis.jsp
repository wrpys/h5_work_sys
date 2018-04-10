<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<%@include file="../layouts/default.jsp"%>
</head>
<body>
	<div class="container">
		<div class="search-grid-container">
			<div id="grid"></div>
		</div>

		<div id="content" class="hide">
			<form id="J_Form" class="form-horizontal">
				<input type="hidden" name="wId">
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>姓名：</label>
						<div class="controls">
							<input type="text" data-rules="{required:true}"
								class="control-text" name="wWorkName">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>年级：</label>
						<div class="controls">
							<input name="grade" type="text" data-rules="{required:true}"
								class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>班级：</label>
						<div class="controls">
							<input name="clzss" type="text" data-rules="{required:true}"
								class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8" style="height: 200px;">
						<label class="control-label"><s>*</s>提交时间：</label>
						<div class="controls">
							<textarea name="wWorkRequirement" style="height: 150px;"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label"><s>*</s>成绩：</label>
						<div class="controls">
							<input name="clzss" type="text" data-rules="{required:true}"
								class="input-normal control-text">
						</div>
					</div>
				</div>
			</form>
		</div>

		<%--上课时间-出勤和作业提交--%>
		<div id="J_WorkInfoContent" class="hide">
			<div class="panel panelHeight">
				<div id="J_WorkInfoContentGrid"></div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	BUI.use(['common/search','bui/list','bui/picker','bui/select','bui/calendar','bui/overlay','bui/data','bui/grid','bui/calendar'],function (Search,List,Picker,Select,Calendar,Overlay,Data,Grid,Calendar) {
        var Grid = Grid,
             Store = Data.Store;
        var wid = "${wId}";
    	var clzssId = "${clzssId}";
        var  WorkInfoColumns = [
                    { title: '姓名', width: 80, dataIndex: 's_name'},
                    { title: '年级', width: 200, dataIndex: 'grade'},
                    { title: '班级', width: 200, dataIndex: 'clzss'},
                    { title: '提交时间', width: 130, dataIndex: 'wi_add_time'},
                    {
                        title:"成绩", width: 130,dataIndex: 'w_i_score',
                        renderer: function (value, row, index) {
                        	if(value=null || typeof(value) == "undefined"){
                        		return "未提交";
                        	}else{
                        		return row.w_i_score;
                        	}
                        }
                    }
                ];
        	store = Search.createStore('${ctx}/work/getWorkAnalysis?wId=' + "${wId}" +"&clzssId="+"${clzssId}",{pageSize:10}),
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
        	gridCfg = Search.createGridCfg(WorkInfoColumns,{
                tbar: {
                    items: []
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
    	});
</script>
</body>
</html>