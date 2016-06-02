<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>前台登录</title>
    <link style="text/css" rel="stylesheet" href="css/style.css">
  </head>
  
  <body bgcolor="#AA8D60">
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    		<table background="${pageContext.request.contextPath }/images/login/loginB.jpg" width="500" height="300" border="0" cellspacing="0" cellpadding="0" style="margin-top:90">
    			<tr height="175">
	    				<td colspan="2" align="center">
	    					<font color="red" size="6px">${requestScope.msg }</font>	
	    				</td>
    			</tr>
    			<tr align="left">
    				
    				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				用户名：<input type="text" name="username"/></td>
    			</tr>
    			<tr align="left">
    				
    				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				密码：<input type="password" name="userpassword"/></td>
    			</tr>
    			<tr>
					<td align="left">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="登陆"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置">
					</td>
					<td></td>    			
    			</tr>
    		</table>
    		<table width="500" border="0" width="350" cellspacing="0" cellpadding="0">
    			<tr>
    				<td colspan="2"><img src="${pageContext.request.contextPath }/images/login/loginE.jpg"></td>
    			</tr> 
    		</table>
    	</form>
    </center>
  </body>
</html>
