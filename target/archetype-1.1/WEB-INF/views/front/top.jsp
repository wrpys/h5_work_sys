<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script>

        $(document).ready(function(){
            var loginForm = $("#loginForm");
            //判断是否登录
            $('#aHome').click(function(){
                $.ajax({
                    url : "${ctx}/front/isLogin",
                    async: false,
                    type:'get',
                    dataType : 'json',
                    success : function(data){
                        console.log(data)
                        if(data.success){
                            if(data.isLogin){
                                window.location.href="${ctx}/front/toStudentHome";
                            }else{
                                loginForm.show();
                            }
                        }
                    }
                });
            });

            //登陆
            $('#loginSubmit').click(function(){
                var sNo = loginForm.find('input[name="sNo"]').val();
                var sPassword = loginForm.find('input[name="sPassword"]').val();
                if(sNo==null||sNo==''||sPassword==null||sPassword==''){
                    alert('学号或密码不能为空！');
                    return ;
                }
                $.ajax({
                    url : "${ctx}/front/studentLogin",
                    async: false,
                    type:'post',
                    dataType : 'json',
                    data:{sNo:sNo,sPassword:sPassword},
                    success : function(data){
                        console.log(data)
                        if(data.success){
                            loginForm.hide();
                            window.location.href="${ctx}/front/toStudentHome";
                        }else{
                            alert(data.msg);
                        }

                    }
                });
            });

        });

    </script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/front/toIndex">作业系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li <c:if test="${active=='jianjie'}">class="active"</c:if> ><a href="${ctx}/front/toBriefIntroduction">简介</a></li>
                <li <c:if test="${active=='noticeIndex'}">class="active"</c:if>><a href="${ctx}/front/toNoticeIndex">公告</a></li>
                <li <c:if test="${active=='newsIndex'}">class="active"</c:if>><a href="${ctx}/front/toNewsIndex">新闻</a></li>
                <li <c:if test="${active=='fileIndex'}">class="active"</c:if>><a href="${ctx}/front/toFileIndex">资源下载</a></li>
                <c:if test="${not empty student}">
                    <li <c:if test="${active=='studentHome'}">class="active"</c:if> ><a href="${ctx}/front/toStudentHome" id="aHome">个人中心</a></li>
                </c:if>
            </ul>
            <form class="navbar-form navbar-left" role="search" id="loginForm"
                  <c:if test="${not empty student}">style="display: none;"</c:if>
                  <c:if test="${empty student}">style="display: inline-block;"</c:if>
            >
                <div class="form-group">
                    <input type="text" class="form-control" name="sNo" placeholder="学号">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="sPassword" placeholder="密码">
                </div>
                <span id="loginSubmit" class="btn btn-primary">登录</span>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="margin-bottom: 10px;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${ctx}/img/1.jpg" alt="作业系统">
            <div class="carousel-caption">
                <h3>作业系统</h3>
            </div>
        </div>
        <div class="item">
            <img src="${ctx}/img/2.jpg" alt="作业系统">
            <div class="carousel-caption">
                <h3>作业系统</h3>
            </div>
        </div>
        <div class="item">
            <img src="${ctx}/img/3.jpg" alt="作业系统">
            <div class="carousel-caption">
                <h3>作业系统</h3>
            </div>
        </div>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">上一页</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">下一页</span>
    </a>
</div>
</body>
</html>