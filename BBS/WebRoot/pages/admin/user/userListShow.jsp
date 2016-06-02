<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    <center>
    	<table border="1" width="580" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows">
    	<tr height="29"><td background="${pageContext.request.contextPath }/images/admin/backLT.jpg" colspan="6" style="text-indent:5"><b><font color="white">■ 查看用户</font></b></td></tr>	      	      
	      <tr height="30" bgcolor="#F0F0F0">
	          <td width="15%" align="center">用户ID</td>
	          <td width="30%" align="center">用户名</td>
	          <td width="20%" align="center">用户密码</td>
   	          <td width="15%" align="center">用户权限</td>
	          <td width="20%" align="center" colspan="2">操作</td>
	      </tr>
	      <!--该用户不存在 -->
	      <c:if test="${sessionScope.ufList.size()<=0 }">
	      		<tr height="80" align="center"><td colspan=6"><li>没有用户可显示！</li></td></tr> 
	      </c:if>
	      <!-- 该用户存在 -->
	      <c:if test="${sessionScope.ufList.size()>0 }">
	      	<tr>
	      		<td colspan="6">
	      			<table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="rows">
	      				<c:forEach items="${sessionScope.ufList }" var="uf">
	      					 <tr height="35" bgcolor="#FBFBFB">
                            	<td width="15%" align="center">${uf.id}</td>
                            	<td width="30%" align="center">${uf.username }</td>
                            	<td width="20%" align="center">${uf.userpassword}</td>
                            	<td width="15%" align="center">
                            		<c:if test="${uf.userable=='0' }">
                            			普通用户
                            		</c:if>
                            		<c:if test="${uf.userable=='1' }">
                            			版主
                            		</c:if>
                            		<c:if test="${uf.userable=='2'}">
                            			管理员
                            		</c:if>
                            	</td>
                                <td align="center"><a href="${pageContext.request.contextPath }/servlet/ModifyUserServlet?id=${uf.id}">√修改</a></td>
                                <td align="center"><a href="${pageContext.request.contextPath }/servlet/DeleteUserServlet?id=${uf.id}&userable=${uf.userable}&username=${uf.username}" onclick="javaScript:return confirm('确认要删除该信息?')">×删除</a></td>
                      
                            </tr>
	      				</c:forEach>
	      			</table>
	      		</td>
	      	</tr>
	      </c:if>
	      <tr height="19" style="background-image:url('${pageContext.request.contextPath }/images/admin/backLE.jpg')"><td colspan="6"></td></tr>                         
	    </table>
    </center>
  </body>
</html>
