<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>前台-查看某个用户详细内容</title>
    <link style="text/css" rel="stylesheet" href="css/style.css"/>
  </head>
  
  <body>
    <center>
    	<table border="1" width="70%" bgcolor="#F9F9F9" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="none" style="margin-top:8">
    		<tr height="60">  <td colspan="2" style="text-indent:5">■ 查看用户信息</td></tr>
 	        <tr height="50">
 	        	<td align="right">用户头像：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	        	<td><img src="${pageContext.request.contextPath }/images/face/user/${sessionScope.userform.userface}" style="border:1 solid;border-color:#E0E0E0"></td>
 	        </tr>
 	        <tr height="50">
	            <td align="right">用 户 名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    	        <td>${sessionScope.userform.username }</td>
   	        </tr>
   	         <tr height="50">
	            <td align="right">用户性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>${sessionScope.userform.usersex }</td>
	        </tr>
	        <tr height="50">
	            <td align="right">用户权限：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>
	            	<c:if test="${sessionScope.userform.userable=='0' }">
	            		普通用户
	            	</c:if>
	            	<c:if test="${sessionScope.userform.userable=='1' }">
	            		版主
	            	</c:if>
	            	<c:if test="${sessionScope.userform.userable=='2' }">
	            		管理员
	            	</c:if>	      
	            </td>
	        </tr>
	        <tr height="50">
	            <td align="right">联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>${sessionScope.userform.userphone }</td>
	        </tr>
	        <tr height="50">
	            <td align="right">E-mail：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>${sessionScope.userform.useremail }</td>
	        </tr>
   	        <tr height="50">
	            <td align="right">来自：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>${sessionScope.userform.userfrom }</td>
	        </tr>
            <tr height="60">
            	<td colspan="2" align="center" style="text-indent:20">
            		<a href="${pageContext.request.contextPath }/index.jsp">返回</a>
            	</td>
            </tr>      	      
      		
    	</table>
    </center>
  </body>
</html>
