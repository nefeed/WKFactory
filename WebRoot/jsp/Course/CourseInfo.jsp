<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String CourseNum = request.getParameter("CourseNum"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>课程详情界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script> 
	<script type="text/javascript" src="js/Course/CourseInfo.js"></script>
    <script type="text/javascript">
      var CourseNum = <%="'"+CourseNum+"'"%> ;
    </script>
    <style type="text/css">
		table tr td{ border-top:#00CCFF solid 1px; text-align:center; }
	</style>
  </head>
  
  <body>
    <div align="center" >
    	<label>Course Information</label>
    </div>
    <div id = "CourseMain" align = "center">
    <table align="center" id = "CourseInfoTable">
    	<tr>
    		<td><label>CourseName:</label></td><td><input id="CourseName" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>CourseContent:</label></td><td><textarea id="CourseContent" readonly="readonly" rows="3" ></textarea></td>
    	</tr>
    	<tr>
    		<td><label>SubjectName:</label></td><td><input id="SubjectName" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>AudienceNum:</label></td><td><input id="AudienceNum" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>SubscriptionNum:</label></td><td><input id="SubscriptionNum" type="text" readonly="readonly" ></td>
    	</tr>
    	<tr>
    		<td><label>CreateTime:</label></td><td><input id="Createtime" type="text" readonly="readonly" ></td>
    	</tr>
    </table>
    </div>
    
    
    <div align="center">
    	<button id = "UpdateButton" onclick="UpdateCourse()" >UpdateCourse</button><button onclick="Back()">Back</button>
    </div>
    <div align = "center" id = "DownloadAccessoryBody">
	
	</div>
	<div align = "center" id = "AccessoryBody">
		<button onclick = "ChangeUpload()">Upload Accessory</button>
	</div>
    <div align = "center" id = "ChapterBody">
    
	</div>
	<div align = "center" id = "CommentBody">
	
	</div>
  </body>
</html>
