<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>友情提示</title>
    <link style="text/css" rel="stylesheet" href="css/style.css"/>
  </head>
  
  <body bgcolor="#F9FDFF">
    <center>
    	<table border="0" width="325" height="223" cellpadding="0" cellspacing="0" style="margin-top:150">
    		<tr>
    			<td align="center" background="${pageContext.request.contextPath }/images/login/mess.gif">
    				<font color="red" size="10px">${request.msg }</font>
    				<a href="javascript:window.history.go(-1)">返回</a>
    			</td>
    		</tr>
    	</table>
    </center>
  </body>
</html>
