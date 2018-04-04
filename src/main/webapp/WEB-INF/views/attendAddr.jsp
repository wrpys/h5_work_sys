<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%@include file="../layouts/default.jsp"%>
    <style>
        .ztree {height:480px;overflow-y:auto;overflow-x:auto;}
    </style>
</head>
<body>
    <div class="container">
        <div class="span8 panel panel-small">
            <div class="panel-body">
                <div class="button-group">
                    <button id="treeAddRoot" type="button" class="button button-small">
                        <i class="icon-plus"></i>添加教学楼
                    </button>
                    <button id="treeAdd" type="button" class="button button-small">
                        <i class="icon-plus"></i>添加教室
                    </button>
                    <button class="button button-small" type="button" id="treeDelete">
                        <i class="icon-remove"></i>删除
                    </button>
                </div>
                <ul id="tree" class="ztree"></ul>
            </div>
        </div>

        <div class="span11 panel panel-small">
            <form id="attendAddrForm" class="form-horizontal">
                <div  id="categoryInit">
                    <input type="hidden" name="aaId" value="">
                    <input type="hidden" name="aaPid" value="">
                    <div class="control-group">
                        <label class="control-label"><s>*</s>名称：</label>
                        <div class="controls">
                            <input name="aaName" data-rules="{required:true}" class="input-normal control-text" type="text">
                        </div>
                    </div>
                </div>
                <div class="form-actions actions-bar centered">
                    <button id="attendAddrUpdate" type="button" class="button button-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        BUI.use(['bui/overlay','bui/form','bui/select','bui/list','bui/picker','ztree/ztree'],function(Overlay,Form,Select,List,Picker){
            //=====================ztree=====================
            var setting = {
                edit: {
                    enable: true,
                    showRemoveBtn: false,
                    showRenameBtn: false
                },
                data:{
                    key:{
                        name:'aaName'
                    },
                    simpleData:{
                        enable:true,
                        idKey:'aaId',
                        pIdKey:'aaPid'
                    }
                },
                callback:{
                    onClick: onClick
                }
            };

            $.fn.zTree.init($("#tree"), setting, ${attendAddrs});
            var zTree = $.fn.zTree.getZTreeObj("tree");
            var node = zTree.getNodes()[0];
            zTree.expandNode(node,true,false,true);//ztree end

            function onClick(event, treeId, treeNode, clickFlag) {
                var form= $('form')[0];
                BUI.FormHelper.setFields(form,treeNode);//回填
            }

            //添加父类
            $("#treeAddRoot").click(function(){
                var treeNode={aaPid:0,aaName:"教学楼名称"};
                $.ajax({
                    url:"${ctx}/attendAddr/add",
                    type:"POST",
                    async:false,
                    dataType:'json',
                    data:treeNode,
                    success:function(data){
                        if(data.success){
                            BUI.Message.Alert('添加成功','success');
                            zTree.addNodes(null,data.attendAddr);
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
                    BUI.Message.Alert('请先选择一个节点','info');
                    return;
                }

                var treeNode={aaPid:nodes[0].aaId,aaName:"教室名称"};
                $.ajax({
                    url:"${ctx}/attendAddr/add",
                    type:"POST",
                    async:false,
                    dataType:'json',
                    data:treeNode,
                    success:function(data){
                        if(data.success){
                            BUI.Message.Alert('添加成功','success');
                            zTree.addNodes(nodes[0],data.attendAddr);
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
                BUI.Message.Confirm('确认要删除此地址吗？',function(){
                    $.ajax({
                        url:"${ctx}/attendAddr/delete",
                        type:"POST",
//                        async:false,
                        dataType:'json',
                        data:{'aaId':nodes[0].aaId},
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

            //修改数据并全部提交
            $("#attendAddrUpdate").click(function(){
                var selected = zTree.getSelectedNodes();
                if(selected.length==0){
                    return false;
                }
                var data=$("#attendAddrForm").serialize();

                $.ajax({
                    url: "${ctx}/attendAddr/update",
                    type:'POST',
                    async:false,
                    dataType : 'json',
                    data:data,
                    //获取返回的node值，更新znode
                    success:function(data){
                        console.log(data)
                        if(data.success){
                            BUI.Message.Alert('提交成功','success');
                            var attendAddr = data.attendAddr;
                            BUI.mix(selected[0],attendAddr);
                            zTree.updateNode(selected[0]);
                        }else{
                            BUI.Message.Alert(data.json.msg,'error');
                        }
                    }
                });
            });

        });
    </script>
</body>
</html>
