<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%@include file="../layouts/default.jsp" %>
    <style>
        .work-info, .discuss-content {
            border: 1px solid #ccc;
        }

        .work-info h1, .discuss-content h1 {
            padding-top: 10px;
            padding-left: 10px;
        }

        .work-info ul, .discuss-content ul {
            margin-left: 50px;
        }

        .user-info {
            color: #4093c6;
        }

        .time-info {
            margin-left: 25px;
        }
        .reply-list li {
            margin-bottom: 25px;
        }
        .discuss-content ul a {
            margin-left: 25px;
        }
    </style>
</head>
<body>
<div class="container" style="height:auto;">
    <div class="work-info">
        <h1>作业信息</h1>
        <hr>
        <ul>
            <li>
                <b>作业名称：</b><span class="work-title">${work.wWorkName}</span>
            </li>
            <li>
                <b>布置时间：</b><span class="work-title"><fmt:formatDate value="${work.wAddTime}"
                                                                     pattern="yyyy-MM-dd HH:mm:ss"/></span>
            </li>
            <li>
                <b>作业详情：</b>
                <p class="work-desc">${work.wWorkRequirement}</p>
            </li>
        </ul>
    </div>
    <div class="discuss-content">
        <h1>讨论列表</h1>
        <hr>
        <ul id="discuss-info">
        </ul>
    </div>

    <div id="content" class="hide">
        <form id="J_Form" class="form-horizontal">
            <input type="hidden" name="wId">
            <input type="hidden" name="msgPid">
            <input type="operRole" name="2">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>回复：</label>
                    <div class="controls">
                        <input name="msgContent" type="text" data-rules="{required:true}"
                               class="input-normal control-text">
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>
<br><br><br><br>
<script type="text/javascript">
    BUI.use(['common/search', 'bui/list', 'bui/picker', 'bui/select', 'bui/overlay'], function (Search, List, Picker, Select, Overlay) {

        $.ajax({
            url: '${ctx}/message/getDiscuss?wId=${work.wId}',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                var discussDom = $("#discuss-info");
                if (data && data.length > 0) {
                    for (var i = 0; i < data.length; i++) {
                        var mItem = data[i];
                        var _html = [];
                        _html.push('<li><p>');
                        _html.push('<span class="user-info">' + mItem.operName + '(' + mItem.operRoleName + ')' + '</span>');
                        _html.push('<span class="time-info">' + mItem.createTime + '</span>');
                        if (!mItem.messageExt) {
                            _html.push('<a onclick="replyDiscuss(' + messageExt.msgId + ');">回复</a>');
                        }
                        _html.push('<p>' + mItem.msgContent + '</p>');
                        _html.push('</li>');
                        if (mItem.messageExt) {
                            _html.push('<ul class="reply-list">');
                            _html.push(buildDiscuss(mItem.messageExt));
                            _html.push('</ul>');
                        }
                        discussDom.append(_html.join(""));
                    }
                } else {
                    discussDom.html("暂无讨论");
                }
            }
        });

        function buildDiscuss(messageExt) {
            var _html = [];
            _html.push('<li><p>');
            _html.push('<span class="user-info">' + messageExt.operName + '(' + messageExt.operRoleName + ')' + '</span>');
            _html.push('<span class="time-info">' + messageExt.createTime + '</span>');
            if (!messageExt.messageExt) {
                _html.push('<a onclick="replyDiscuss(' + messageExt.msgId + ');">回复</a>');
            }
            _html.push('<p>' + messageExt.msgContent + '</p>');
            _html.push('</li>');
            if (messageExt.messageExt) {
                _html.push(buildDiscuss(messageExt.messageExt));
            }
            return _html.join("");
        }

    });//seajs end

    function replyDiscuss (msgId) {
        alert(msgId);
    }

</script>
<!-- script end -->
</body>
</html>