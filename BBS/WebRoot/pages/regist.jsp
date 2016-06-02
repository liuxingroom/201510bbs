<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>用户注册</title>
    <script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../js/bbs.js"></script>
    <script type="text/javascript" src="../js/jiaoyan.js"></script>
  </head>
  
  <body>
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/RegistServlet">
	    	<table border="1" width="80%" bgcolor="#F9F9F9" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="none" style="margin-top:5">
	    	  <tr height="80">  <td colspan="5" style="text-indent:20">■ 用户注册</td></tr>
	          <tr height="45">
	                <td align="right" width="35%">用 户 名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    	            <td colspan="4"><input type="text" name="username" size="40" id="username" value="${param.username }"/></td>
    	      </tr>
    	      <tr>
    	      		<td></td>
    	      		<td colspan="4" id="username_msg"></td>
    	      </tr>
	          <tr height="45">
	                <td align="right">用户密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="4"><input type="password" name="userpassword" size="40" /></td>
	          </tr>
	          <tr>
    	      		<td></td>
    	      		<td colspan="4" id="password_msg"></td>
    	      </tr>
    	      <tr height="45">
	                <td align="right">确认密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="3"><input type="password" name="userpassword2" size="40"/></td>
	                <td rowspan="3" width="20%" valign="bottom" style="padding-bottom:10">	                    
	                    <img id="head" src="${pageContext.request.contextPath }/images/face/user/user0.gif" style="border:1 solid">   
	                </td>
	          </tr>
	          <tr>
	          		<td></td>
    	      		<td colspan="4" id="password_msg2"></td>
    	      </tr>
    	      
    	       <tr height="45">
	                <td align="right">用户性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td>
	                    <input type="radio" name="usersex" value="男" checked="checked"/>男
	                    <input type="radio" name="usersex" value="女"/>女
	                </td>
	                <td width="15%" align="center">用户头像：</td>
	                <td width="20%" align="center">
	                	<select name="userface" onchange="showHead(this.options[this.selectedIndex].value)">
	                		<option value="">请选择</option>
	                		<option value="user0.gif">头像1</option>
	                		<option value="user1.gif">头像2</option>
	                		<option value="user6.gif">头像3</option>
	                		<option value="user7.gif">头像4</option>
	                	</select>
	                    
	                </td>
	          </tr>
   	          <tr height="45">
	                <td align="right">联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="4"><input type="text" name="userphone" size="40" value="${param.userphone }"/></td>
	          </tr>
	          <tr>
    	      		<td></td>
    	      		<td colspan="4" id="userphone_msg"></td>
    	      </tr>
	          
   	          <tr height="45">
	                <td align="right">E-mail：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="4"><input type="text" name="useremail" size="50" value="${param.useremail }"/></td>
	          </tr>
   	          <tr>
    	      		<td></td>
    	      		<td colspan="4" id="email_msg"></td>
    	      </tr>
   	          <tr height="45">
	                <td align="right">来自：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	                <td colspan="4"><input type="text" name="userfrom" size="60" value="${param.userfrom }"/></td>
	          </tr>
	          <tr>
    	      		<td></td>
    	      		<td colspan="4" id="from_msg"></td>
    	      </tr>
    	      <tr height="80">
	                <td>&nbsp;</td>
	                <td colspan="4">
	                    <input type="submit" value="提交"/>
	                    <input type="reset" value="重新填写"/>
    	            </td>
	          </tr>	   
	    	</table>
	    </form>
    </center>
  </body>
</html>
