<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选择用户权限</title>
  </head>
  	<center>
  		<form action="${pageContext.request.contextPath }/servlet/UserListServlet">
  			<table border="0" width="580" cellspacing="0" cellpadding="0">
  				<tr></tr>
  				<tr></tr>
  				<tr></tr>
  				<tr align="center">
  					<td align="center">
  					选择用户权限：
  						<select name="showAble">
  							<option value="">--请选择用户权限--</option>
  							<option value="0" selected="selected">普通用户</option>
  							<option value="1">版主</option>
  							<option value="2">管理员</option>
  						</select>	
  					</td>
  				</tr>
  				<tr align="center">
  					<td>
  						<input type="submit" value="提交"/>
  					</td>
  					
  				</tr>
  			</table>
  		</form>
  	</center>
  <body>
    
  </body>
</html>
