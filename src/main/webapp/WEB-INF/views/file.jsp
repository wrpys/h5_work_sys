<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <style>
        .ztree {height:480px;overflow-y:auto;overflow-x:auto;}
        #menuContent{position: relative;}
        #treeDemo{position:absolute;z-index: 999;background-color: #fff;border:1px solid #CCCCCC;}
    </style>
</head>
<body>
<div class="container">
    <div class="span8 panel panel-small">
        <div class="panel-body">
            <div class="button-group">
                <button id="treeAddRoot" type="button" class="button button-small">
                    <i class="icon-plus"></i>添加父类型
                </button>
                <button id="treeAdd" type="button" class="button button-small">
                    <i class="icon-plus"></i>添加子类型
                </button>
                <button class="button button-small" type="button" id="treeUpdate">
                    <i class="icon-edit"></i>修改
                </button>
                <button class="button button-small" type="button" id="treeDelete">
                    <i class="icon-remove"></i>删除
                </button>
            </div>
            <ul id="tree" class="ztree"></ul>
        </div>
    </div>

    <div id="J_FileTypeContent" class="hide">
        <form id="fileTypeForm" class="form-horizontal">
            <div  id="categoryInit">
                <input type="hidden" name="ftId">
                <input type="hidden" name="ftPid">
                <div class="control-group">
                    <label class="control-label"><s>*</s>名称：</label>
                    <div class="controls">
                        <input name="ftName" data-rules="{required:true}" class="input-normal control-text" type="text">
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="span17 panel panel-small">
        <form id="searchForm" class="form-horizontal">
            <input name="fileType" type="hidden">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label">文件名：</label>
                    <div class="controls">
                        <input type="text" class="control-text" name="fileName">
                    </div>
                </div>
                <div class="control-group span8">
                    <label class="control-label">上传者：</label>
                    <div class="controls">
                        <input type="text" class="control-text" name="nickName">
                    </div>
                </div>
                <div class="control-group span12">
                    <label class="control-label">上传时间：</label>
                    <div class="controls">
                        <input type="text" class="calendar" name="startDate">
                        <span> - </span>
                        <input type="text" class="calendar" name="endDate">
                    </div>
                </div>
                <div class="span3">
                    <button type="button" id="btnSearch" class="button button-primary">搜索</button>
                </div>
            </div>
        </form>

        <div class="search-grid-container">
            <div id="grid"></div>
        </div>

        <div id="content" class="hide">
            <form id="J_Form" class="form-horizontal">
                <input type="hidden" name="fileId">
                <input type="hidden" name="fileSize" id="fileSize">
                <div class="row">
                    <div class="control-group span8" style="height: 30px;overflow: hidden;">
                        <label class="control-label"><s>*</s>上传文件：</label>
                        <input id="fileAddr"  name="fileAddr" type="hidden" value="dizhi"  data-rules="{required:true}" class="input-normal control-text">
                        <iframe width="100" height="30" frameborder="0" scrolling="no" class="iframe-file-upload" src="${ctx}/static/fileUpload/jsp/uploadFile.jsp"></iframe>
                    </div>
                </div>
                <div class="row span8 offset1">
                    <div class="progress progress-striped">
                        <div id="progress" class="bar bar-info"></div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span8">
                        <label class="control-label"><s>*</s>文件名：</label>
                        <div class="controls">
                            <input name="fileName" id="fileName" type="text" readonly="true"  data-rules="{required:true}" class="input-normal control-text">
                        </div>
                    </div>
                </div>
                <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
                    <ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height: 200px;overflow: scroll;"></ul>
                </div>
                <div class="row">
                    <div class="control-group span11">
                        <label class="control-label"><s>*</s>文件类型：</label>
                        <input name="fileType" id="ftId" type="hidden" value="">
                        <div class="controls">
                            <input id="ftName" type="text" value="" readonly="true" data-rules="{required:true}">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">

    //文件上传后名称的回显
    function displayFileName(upload_fileName,original_fileName,fileSize){
        progress.css('width','100%');
        clearInterval(progressInterval)
        $('#fileName').val(original_fileName);
        $('#fileAddr').val(upload_fileName);
        $("#fileSize").val(fileSize);
    }
    //进度监听
    var progressInterval;
    var progress = $('#progress');
    function showProgress(){
        progress.css('width','0%');
        progressInterval = setInterval(function(){
            getProgress();
        },3000);
    }
    //获取进度
    function getProgress(){
        $.ajax({
            url: "${ctx}/uploadDown/getProgress",
            type:'POST',
            dataType : 'json',
            success:function(data){
                var progressVal = data.pbytesRead/data.pcontentLength;
                progressVal =Math.round(progressVal*100);
                if(progressVal!=0){
                    progress.css('width',progressVal+'%');
                }
                if(progressVal==100){
                    clearInterval(progressInterval)
                }
            }
        });
    }

    BUI.use(['common/search','bui/overlay','bui/form','bui/select','bui/list','bui/picker','ztree/ztree'],function(Search,Overlay,Form,Select,List,Picker){

        //===========选择树=========================================================
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
                    name:'ftName'
                },
                simpleData:{
                    enable:true,
                    idKey:'ftId',
                    pIdKey:'ftPid'
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
                v += nodes[i].ftName + ",";
            }
            if (v.length > 0 ) v = v.substring(0, v.length-1);
            $("#ftName").val(v);
            if(v!=''){
                $("#ftId").val(treeNode.ftId);
            }else{
                $("#ftId").val("");
            }
        }
        function showMenu() {
            var cityObj = $("#ftName");
            var cityOffset = $("#ftName").offset();
            $("#menuContent").css({left:cityOffset.left - 323 + "px", top:cityOffset.top - 194 + cityObj.outerHeight() + "px"}).slideDown("fast");
            $("body").bind("mousedown", onBodyDown);
        }

        function hideMenu() {
            $("#menuContent").fadeOut("fast");
            $("body").unbind("mousedown", onBodyDown);
        }
        function onBodyDown(event) {
            if (!(event.target.id == "ftName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                hideMenu();
            }
        }
        $(document).ready(function(){
            $("#ftName").click(function(){
                $.ajax({
                    url: "${ctx}/file/getFileTypes",
                    type:'POST',
                    async:false,
                    dataType : 'json',
                    success:function(data){
                        console.log(data)
                        if(data.length!=0){
                            $.fn.zTree.init($("#treeDemo"), settingTemp, data);
                            showMenu();
                        }else{
                            BUI.Message.Alert('获取文件类别失败！');
                        }
                    }
                });
            });
        });

        //=====================ztree=====================
        var setting = {
            edit: {
                enable: true,
                showRemoveBtn: false,
                showRenameBtn: false
            },
            data:{
                key:{
                    name:'ftName'
                },
                simpleData:{
                    enable:true,
                    idKey:'ftId',
                    pIdKey:'ftPid'
                }
            },
            callback:{
                onClick: onClick
            }
        };

        $.fn.zTree.init($("#tree"), setting, ${fileTypes});
        var zTree = $.fn.zTree.getZTreeObj("tree");
        var node = zTree.getNodes()[0];
        zTree.expandNode(node,true,false,true);//ztree end

        function onClick(event, treeId, treeNode, clickFlag) {
//            var form= $('form')[0];
//            BUI.FormHelper.setFields(form,treeNode);//回填
            $("#searchForm").find("input[name='fileType']").val(treeNode.ftId)
            search.load();
        }

        /******************修改弹出框*********************************/
        //创建弹出框（点名）
        var fileTypeDialog;
        function createFileTypeDialog(){
            return new Overlay.Dialog({
                title:'学生列表',
                width:350,
                height:150,
                contentId:'J_FileTypeContent',
                success:function () {
                    var me = this;
                    var selected = zTree.getSelectedNodes();
                    if(selected.length==0){
                        return false;
                    }
                    var data=$("#fileTypeForm").serialize();

                    $.ajax({
                        url: "${ctx}/file/updateFileType",
                        type:'POST',
                        async:false,
                        dataType : 'json',
                        data:data,
                        //获取返回的node值，更新znode
                        success:function(data){
                            console.log(data)
                            if(data.success){
                                me.close();
                                BUI.Message.Alert('提交成功','success');
                                var fileType = data.fileType;
                                BUI.mix(selected[0],fileType);
                                zTree.updateNode(selected[0]);
                            }else{
                                BUI.Message.Alert(data.json.msg,'error');
                            }
                        }
                    });
                }
            });
        }
        $("#treeUpdate").click(function(){
            if(!fileTypeDialog){
                fileTypeDialog = createFileTypeDialog();
            }
            var nodes = zTree.getSelectedNodes();
            var form = $("#fileTypeForm");
            form.find('input[name="ftId"]').val(nodes[0].ftId);
            form.find('input[name="ftPid"]').val(nodes[0].ftPid);
            form.find('input[name="ftName"]').val(nodes[0].ftName);
            fileTypeDialog.show();
        });

        //添加父类
        $("#treeAddRoot").click(function(){
            var treeNode={ftPid:0,ftName:"文件父类型"};
            $.ajax({
                url:"${ctx}/file/addFileType",
                type:"POST",
                async:false,
                dataType:'json',
                data:treeNode,
                success:function(data){
                    if(data.success){
                        BUI.Message.Alert('添加成功','success');
                        zTree.addNodes(null,data.fileType);
                        zTree.updateNode(treeNode);
                    }else{
                        BUI.Message.Alert('添加失败','error');
                    }
                }
            })
        });

        //添加子类
        $("#treeAdd").click(function(){
            var nodes = zTree.getSelectedNodes();
            if(nodes.length==0){
                BUI.Message.Alert('请先选择一个类别','info');
                return;
            }

            var treeNode={ftPid:nodes[0].ftId,ftName:"文件子类型"};
            $.ajax({
                url:"${ctx}/file/addFileType",
                type:"POST",
                async:false,
                dataType:'json',
                data:treeNode,
                success:function(data){
                    if(data.success){
                        BUI.Message.Alert('添加成功','success');
                        zTree.addNodes(nodes[0],data.fileType);
                        zTree.updateNode(nodes[0]);
                    }else{
                        BUI.Message.Alert('添加失败','error');
                    }
                }
            })
        });

        //删除节点
        $("#treeDelete").click(function(){
            var nodes = zTree.getSelectedNodes();
            if(nodes.length==0){
                BUI.Message.Alert('请先选择一个节点');
            }
            BUI.Message.Confirm('确认要删除此节点吗？',function(){
                $.ajax({
                    url:"${ctx}/file/deleteFileType",
                    type:"POST",
//                        async:false,
                    dataType:'json',
                    data:{'ftId':nodes[0].ftId},
                    success:function(data){
                        if(data.success){
                            BUI.Message.Alert('删除成功','success');
                            zTree.removeNode(nodes[0]);
                        }else{
                            BUI.Message.Alert(data.msg,'error');
                        }
                    }
                });
            },'question');
        });
 /*******************右边文件列表****************************************************************************/
     var
     columns = [
         {title:'文件名',width:150,dataIndex:'fileName'},
         {title:'文件类型',width:100,dataIndex:'ftName'},
         {title:'上传者',width:80,dataIndex:'nickName'},
         {title:'上传时间',width:130,dataIndex:'createTime'},
         {title:'文件大小',width:80,dataIndex:'fileSize',renderer : function(value){
              var fileSizeNum = value/1024;
              fileSizeNum =Math.round(fileSizeNum*100)/100;
              if(fileSizeNum<1024){
                return fileSizeNum + "KB";
              }else if(fileSizeNum>=1024&&fileSizeNum<1024*1024){
                  fileSizeNum = fileSizeNum/1024;
                  fileSizeNum =Math.round(fileSizeNum*100)/100;
                  return fileSizeNum + "MB";
              }else if(fileSizeNum>=1024*1024&&fileSizeNum<1024*1024*1024){
                  fileSizeNum = fileSizeNum/1024;
                  fileSizeNum =Math.round(fileSizeNum*100)/100;
                  return fileSizeNum + "GB";
              }
          }},
         {title:'下载次数',width:60,dataIndex:'fileDownNum'}
     ],
         store = Search.createStore('${ctx}/file/list',{pageSize:10}),
         editing = new BUI.Grid.Plugins.DialogEditing({
             contentId : 'content',
             triggerCls : 'btn-edit',
             editor : {
                 success : function(){  //点击确认的时候触发，可以进行异步传输
                     var editor = this,
                             record = editing.get('record'),//获取编辑记录
                             data = editor.get('form').serializeToObject();//编辑完成的记录
                     editor.valid();

                     submit(BUI.mix(record,data),editor);
                     }
                 }
         }),


         gridCfg = Search.createGridCfg(columns,{
             tbar : {
                 items : [
                     {
                         btnCls : 'button button-small',
                         text : '<i class = "icon-plus"></i>添加',
                         listeners :
                         {
                             'click' : addFunction
                         }
                     },
                     {
                         btnCls : 'button button-small',
                         text : '<i class = "icon-edit"></i>修改',
                         listeners :
                         {
                             'click' : editFunction
                         }
                     },
                     {
                         btnCls : 'button button-small',
                         text :  '<i class = "icon-remove"></i>删除',
                         listeners:
                         {
                             'click' : delFunction
                         }
                     }
                 ]
             },
             plugins:[BUI.Grid.Plugins.CheckSelection,editing]  //勾选插件

         });

        var search = new Search({
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
        }

        function delFunction(){
            var selections = grid.getSelection();
            if(selections.length>=1){
                var ids = [];
                BUI.each(selections,function(item){
                    ids.push(item.fileId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录及文件吗？',function(){
                        $.ajax({
                            url : '${ctx}/file/deleteFile',
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
                url : record.fileId==''?'${ctx}/file/addFile':'${ctx}/file/updateFile',
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

    });
</script>
</body>
</html>
