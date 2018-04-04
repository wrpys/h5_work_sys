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
                <label class="control-label">账号：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="loginName">
                </div>
            </div>
            <div class="control-group span9">
                <label class="control-label">检测时间：</label>
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
</div>
<script type="text/javascript">
    BUI.use(['common/search','bui/form'],function (Search,Form) {
        var columns = [
                { title : '账号', width: 100, dataIndex: 'loginName'},
                { title : '文件地址', width: 300, dataIndex: 'jdAddr'},
                { title : '链接地址', width: 150, dataIndex: 'jdLink'},
                { title : '运行时间', width: 150, dataIndex: 'addTime'},
                { title : '操作', width: 50, dataIndex: 'jdAddr',renderer:function(value,obj){
                    var str = '<a href="${ctx}/'+value+'" target="_blank">运行</a>';
                    if(obj.jdLink!=''&&obj.jdLink!=undefined&&obj.jdLink!=null){
                        str = '<a href="${ctx}/'+obj.jdLink+'?jdAddr='+value+'" target="_blank">运行</a>';
                    }
                    return str;
                }}
             ],
                store = Search.createStore('${ctx}/jspDetect/list',{pageSize:10}),
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

    }); //-----BUI end-----
</script>
<!-- script end -->
</body>
</html>