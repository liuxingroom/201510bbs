<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看某个论坛类别详细内容</title>
  </head>
  	
  <body>
    <center>
    	<table border="0" width="90%" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="none">
	          <tr height="60">  <td colspan="2" style="text-indent:5">■ 修改论坛类别</td></tr>
    	      <tr height="50">
	                <td align="right" width="30%">论坛类别ID：&nbsp;&nbsp;</td>
	                <td style="text-indent:5">${sessionScope.classForm.classid }</td>
	          </tr>
	          <tr height="50">
	                <td align="right">论坛类别名称：&nbsp;&nbsp;</td>
    	            <td>${sessionScope.classForm.classname }</td>
    	      </tr>
    	      
	          <tr height="50">
	                <td align="right">论坛类别介绍：&nbsp;&nbsp;</td>
	                <td>${sessionScope.classForm.classintro }</td>
	          </tr>
    	           
    	            	      
          </table>
    </center>
  </body>
</html>
