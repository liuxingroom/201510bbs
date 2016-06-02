<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列表查看论坛类别</title>
  </head>
  	
  <body>
    <center>
  		<br>
  		<table border="1" width="580" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows">
  			 <tr height="29">
  			 	<td background="${pageContext.request.contextPath }/images/admin/backLT.jpg" colspan="4" style="text-indent:5">
  			 		<b><font color="white">■ 查看论坛类别</font></b>
  			 	</td>
  			 </tr>
  			 <tr height="30" bgcolor="#F0F0F0">
	          	<td width="20%" align="center">类别ID</td>
	          	<td width="60%" style="text-indent:15">类别名称</td>
	          	<td align="center" colspan="2">操作</td>
	      </tr>
	      <c:if test="${sessionScope.classList.size()<=0 }">
	      		<tr height="80" bgcolor="#FBFBFB"><td align="center" colspan="4"><li>类别列表不存在！</li></td></tr>
	      </c:if>
	      <c:if test="${sessionScope.classList.size()>0 }">
	      		<tr>
	      			<td colspan="4">
	      				<table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="rows">
	      					<c:forEach items="${sessionScope.classList }" var="c">
	      						<tr height="30" bgcolor="#FBFBFB">
	                      			<td width="20%" align="center">${c.classid }</td>
	                      			<td width="60%" style="text-indent:15"><a href="${pageContext.request.contextPath }/servlet/ClassServlet?classid=${c.classid}">${c.classname }</a></td>
	                      			<td align="center"><a href="${pageContext.request.contextPath }/servlet/GetClassServlet?classid=${c.classid}">√修改</a></td>
	                      			<td align="center"><a href="${pageContext.request.contextPath }/servlet/DeleteClassServlet?classid=${c.classid}" onclick="javaScript:return confirm('确认要删除该信息?')">×删除</a></td>
    	            			</tr>
	      					</c:forEach>
	      				</table>
	      			
	      			</td>
	      		</tr>
	      </c:if>
	      <tr height="19" style="background-image:url('${pageContext.request.contextPath }/images/admin/backLE.jpg')"><td colspan="4"></td></tr>	      

  		</table>
  	</center>
  </body>
</html>
