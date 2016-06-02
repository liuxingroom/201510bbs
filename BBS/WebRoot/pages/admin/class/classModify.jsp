<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/ModifyServlet?classId=${sessionScope.classForm.classid}">
    		<table border="0" width="90%" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="none">
	          <tr height="60">  <td colspan="2" style="text-indent:5">■ 修改论坛类别</td></tr>
    	      <tr height="50">
	                <td align="right" width="30%">论坛类别ID：&nbsp;&nbsp;</td>
	                <td style="text-indent:5"><input type="hidden" name="classid" value="${sessionScope.classForm.classid }" />${sessionScope.classForm.classid }</td>
	          </tr>
	          <tr height="50">
	                <td align="right">论坛类别名称：&nbsp;&nbsp;</td>
    	            <td><input type="text" name="classname" value="${sessionScope.classForm.classname }" size="50"/></td>
    	      </tr>
    	      <tr>
	                <td></td>
    	            <td></td>
    	      </tr>
	          <tr height="50">
	                <td align="right">论坛类别介绍：&nbsp;&nbsp;</td>
	                <td><input type="text" name="classintro" value="${sessionScope.classForm.classintro }" size="50"/></td>
	          </tr>
    	      <tr>
	                <td></td>
    	            <td></td>
    	      </tr>	          
    	      <tr height="50">
	                <td>&nbsp;</td>
	                <td>
	                    <input type="submit" value="提交">	                    
    	            </td>
	          </tr>	      	      
          </table>
    	</form>
    </center>
  </body>
</html>
