<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拦截号码管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/js/ligerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/js/ligerUI/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/ligerUI/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<%=basePath%>/js/jquery.json-2.2.js" type="text/javascript"></script> 
	<script src="<%=basePath%>/pages/interceptNumber.js" type="text/javascript"></script> 
	<script type="text/javascript">var basePath = "<%=basePath%>"</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br/>
  	<table style="font-size: 10px;">
  	 	<tr>
  	 		<td>&nbsp;拦截号码：<input id="q_number" style="width: 150px;" /></td>
  	 	</tr>
  	 </table>
  	 <br/>
  	<input value="${sessionScope.wxUser.wxUserId}" id="belongsUser" style="display: none;" />
    &nbsp;<input type="button" value="查询" onclick="gridRefresh();" class="l-button" style="width:80px;float:left;margin-left:6px;" />
    <input type="button" value="新增" onclick="saveDialog();" class="l-button" style="width:80px;float:left; margin-left:6px;" />
    <input type="button" value="修改" onclick="updateDialog();" class="l-button" style="width:80px;float:left; margin-left:6px;" />
    <input type="button" value="删除" onclick="del();" class="l-button" style="width:80px;float:left; margin-left:6px;" />
  	<br>
  	<br>
    <div id="maingrid"></div>
	<div id="editDialog" style="display: none;" >
		<table border="0" style="font-size:12px;width: 99%" >
			<tr style="line-height:30px" >
				<td  width="80px">拦截号码：</td>
				<td><input id="number" /></td>
			</tr>
		</table>
		<input id="id" type="hidden" />
	</div>
  </body>
</html>
