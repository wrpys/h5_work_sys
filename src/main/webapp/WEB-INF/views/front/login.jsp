<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
<title>登录-作业系统</title>
<meta name="mobile-agent" content="format=xhtml;">
<meta name="applicable-devive" content="mobile">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="telephone=no" name="format-detection">
<%@include file="inc.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/front/work/main.css"/>
<body>
<section>
	<div class="order_from">
        <div class="tips">作业系统</div>
        <form id="form" method="post" action="<%=request.getContextPath()%>/reservationsInfoCtr/reservationsInfo" onsubmit="return validateFun();">
            <table>
                <tbody>
                    <tr>
                        <td class="td_name">您的称呼:</td>
                        <td class="td_value">
                            <input type="text" class="" name="userName" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td class="td_name">联系手机:</td>
                        <td class="td_value">
                            <input type="text" class="" value="" name="mobile"> 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="td_sub">
                            <button class="btn_subimt" type="submit" onclick="">登录</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</section>
<%@include file="footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>