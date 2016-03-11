<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拦截号码记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/js/ligerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/js/ligerUI/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/ligerUI/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<%=basePath%>/js/jquery.json-2.2.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/My97DatePicker/WdatePicker.js" type="text/javascript" ></script>  
	<script src="<%=basePath%>/pages/interceptRecord.js" type="text/javascript"></script> 
	<script type="text/javascript">var basePath = "<%=basePath%>"</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br/>
  	<table style="font-size: 10px;">
  	 	<tr>
  	 		<td>&nbsp;手机号码：<input id="q_phone" style="width: 150px;" /></td>
  	 		<td>&nbsp;拦截号码：<input id="q_interceptNumber" style="width: 150px;" /></td>
  	 		<td>&nbsp;开始时间：<input id="startTime" style="width: 150px;" onClick="WdatePicker()" /></td>
  	 		<td>&nbsp;结束时间：<input id="endTime" style="width: 150px;" onClick="WdatePicker()" /></td>
  	 	</tr>
  	 </table>
  	 <br/>
  	<input value="${sessionScope.wxUser.wxUserId}" id="belongsUser" style="display: none;" />
    &nbsp;<input type="button" value="查询" onclick="gridRefresh();" class="l-button" style="width:80px;float:left;margin-left:6px;" />
    <input type="button" value="删除" onclick="del();" class="l-button" style="width:80px;float:left; margin-left:6px;" />
  	<br>
  	<br>
    <div id="maingrid"></div>
  </body>
</html>
