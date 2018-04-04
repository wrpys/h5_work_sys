<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <!-- 新闻管理 -->
    <script type="text/javascript" src="${ctx}/static/kindeditor/kindeditor.js"></script>
</head>
<body>
<div class="container">
    <form id="searchForm" class="form-horizontal">
        <div class="row">
            <div class="control-group span8">
                <label class="control-label">新闻标题：</label>
                <div class="controls">
                    <input type="text" class="control-text" name="newsTitle">
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
                    <label class="control-label"><s>*</s>新闻标题：</label>
                    <div class="controls">
                        <input name="newsTitle" type="text" class="control-text" data-rules="{required:true}"/>
                    </div>
                </div>
            </div>
            <div class="row" style="width: 600px;height: 400px">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>新闻内容：</label>
                    <div class="controls">
                        <textarea name="newsContent" id="newsContent" data-rules="{required:true}"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    BUI.use(['common/search','bui/form'],function (Search,Form) {
        //文本编辑框
        var edit;
        var options;
        options = {
            width : '570px',
            height : '360px',
            items : [
                'source', '|', 'undo', 'redo', '|', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
                'table', 'hr', 'pagebreak','link', 'unlink'
            ],
            filterMode : false,
            resizeType : 0 ,
            uploadJson : '${ctx}/static/kindeditor/jsp/upload_json.jsp',
            fileManagerJson : '${ctx}/static/kindeditor/jsp/file_manager_json.jsp',
            allowImageUpload : true,
            allowFileManager : true,
            afterBlur:function(){this.sync();}//失去焦点的时候讲编辑器的内容更新到textarea
        };
        var columns = [
                { title : '新闻标题', width: 500, dataIndex: 'newsTitle'},
                { title : '创建人员', width: 100, dataIndex: 'nickName'},
                { title : '添加时间', width: 150, dataIndex: 'addTime'}

             ],
                store = Search.createStore('${ctx}/news/list',{pageSize:10}),
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
            var newData = {isNew : true}; //标志是新增加的记录
            if(!edit){
                edit = KindEditor.create('#newsContent',options);
            }
            edit.html('');
            editing.add(newData); //添加记录后，直接编辑
        }

        function editFunction(){
            var selections = grid.getSelection();
            if(selections.length==1){
                if(!edit){
                    edit = KindEditor.create('#newsContent',options);
                }
                edit.html(selections[0].newsContent);
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
                    ids.push(item.newsId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录么？',function(){
                        $.ajax({
                            url : '${ctx}/news/delete',
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
                url : record.isNew==true?'${ctx}/news/add':'${ctx}/news/update',
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
    }); //-----BUI end-----
</script>
<!-- script end -->
</body>
</html>