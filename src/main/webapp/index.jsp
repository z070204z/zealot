<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/js/ligerUI/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/js/ligerUI/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/ligerUI/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
    <script src="<%=basePath%>/js/jquery.json-2.2.js" type="text/javascript"></script> 
	<script src="<%=basePath%>/page/contact/contact.js" type="text/javascript"></script> 
	<script type="text/javascript">var basePath = "<%=basePath%>"</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br/>
  <input type="button" value="拦截号码管理" onclick="javascript:window.location.href='pages/interceptNumber.jsp'" class="l-button" style="width:80px;float:left; margin-left:6px;" />
  <input type="button" value="拦截号码记录" onclick="javascript:window.location.href='pages/interceptRecord.jsp'" class="l-button" style="width:80px;float:left; margin-left:6px;" />
  <br/>page 1
  </body>
</html>
