<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台-查看某个用户详细内容</title>
    <script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../../js/bbs.js"></script>
  </head>
  
  <body>
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/UpdateUserServlet" method="post">
    		<table border="0" width="90%" height="630" cellspacing="0" cellpadding="0">
	          <tr height="60">  <td colspan="4" style="text-indent:5">■ 修改用户信息</td></tr>
    	      <tr height="70">
	                <td align="right" width="35%">用户ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="1"><input type="hidden" name="id" value="${sessionScope.userForm.id }"/>${sessionScope.userForm.id }
	                <td colspan="2" rowspan="2" valign="bottom" style="padding-bottom:10">
	                    <img id="head" src="${pageContext.request.contextPath }/images/face/user/${sessionScope.userForm.userface}">
	                </td>
	          </tr>
	          <tr>
	                <td align="right">用户头像：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="2">
   	                	<select name="userface" onchange="showHeadTo(this.options[this.selectedIndex].value)">
	                		<option value="">请选择</option>
	                		<option value="user0.gif"
	                			<c:if test="${sessionScope.userForm.userface=='user0.gif'}">
	                				selected="selected"
	                			</c:if>
	                		>头像1</option>
	                		<option value="user1.gif"
	                			<c:if test="${sessionScope.userForm.userface=='user1.gif'}">
	                				selected="selected"
	                			</c:if>
	                		>头像2</option>
	                		<option value="user6.gif"
	                			<c:if test="${sessionScope.userForm.userface=='user6.gif'}">
	                				selected="selected"
	                			</c:if>
	                		>头像3</option>
	                		<option value="user7.gif"
	                			<c:if test="${sessionScope.userForm.userface=='user7.gif'}">
	                				selected="selected"
	                			</c:if>
	                		>头像4</option>
	                	</select>
	                </td>
	          </tr>
	          <tr>
	                <td align="right">用户名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    	            <td colspan="3"><input type="text" name="username" value="${sessionScope.userForm.username }"/></td>
    	      </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="3"></td>
    	      </tr>
	                   
	          <tr>
	                <td align="right">确认密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="3"><input type="password" name="userpassword" value="${sessionScope.userForm.userpassword }"/></td>
	          </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="3"></td>
    	      </tr>	          
   	          <tr>
	                <td align="right">用户性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td>
	                    <input type="radio" name="usersex" value="男"
	                    	<c:if test="${sessionScope.userForm.usersex=='男' }">
	                    		checked="checked"
	                    	</c:if>
	                    />男
	                    <input type="radio" name="usersex" value="女" 
	                    	<c:if test="${sessionScope.userForm.usersex=='女' }">
	                    		checked="checked"
	                    	</c:if>
	                    />女
	                </td>
	                <td align="right">用户权限：&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td>
   			            <select name="userable">
					        <option value="0" 
					        	<c:if test="${sessionScope.userForm.userable=='0' }">
					        		selected="selected"
					        	</c:if>
					        >普通用户</option>
  							<option value="1"
  								<c:if test="${sessionScope.userForm.userable=='1' }">
					        		selected="selected"
					        	</c:if>
  							>版主</option>
  							<option value="2"
  								<c:if test="${sessionScope.userForm.userable=='2' }">
					        		selected="selected"
					        	</c:if>
  							>管理员</option>
					    </select>
					</td>
	          </tr>
   	          <tr>
	                <td align="right">联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="3"><input type="text" name="userphone" size="40" value="${sessionScope.userForm.userphone }"/></td>
	          </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="3"></td>
    	      </tr>	          
	          
    	      	
   	          <tr>
	                <td align="right">E-mail：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="3"><input type="text" name="useremail" size="50" value="${sessionScope.userForm.useremail }"/></td>
	          </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="3"></td>
    	      </tr>	          
   	          <tr>
	                <td align="right">来自：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="3"><input type="text" name="userfrom" size="60" value="${sessionScope.userForm.userfrom }"/></td>
	          </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="3"></td>
    	      </tr>	          
    	      <tr>
	                <td>&nbsp;</td>
	                <td colspan="3">
	                    <input type="submit" value="提交信息"/>
    	            </td>
	          </tr>	      	      
          </table>
    	</form>    	
    </center>
  </body>
</html>
