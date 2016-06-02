<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加论坛类别</title>
  </head>
  
  <body>
    <center>
      <br>
      <form action="${pageContext.request.contextPath }/servlet/AddSortServlet">
      	<table border="0" height="120" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="all">
      	
         
          <tr>
                 <td>论坛名称：</td>
                 <td><input type="text" name="classname" size="50"/></td>
          </tr>
          <tr>
                 <td></td>
                 <td></td>
          </tr>
          <tr>
                 <td>论坛介绍：</td>
                 <td><input type="text" name="classintro" size="50"/></td>
          </tr>
          <tr>
                 <td></td>
                 <td></td>
          </tr>
          <tr>
                 <td></td>
                 <td>
                     <input type="submit" value="提交"/>
                     <input type="reset" value="重置"/>
                 </td>  
          </tr>
      
      </table>
     </form>
    </center>
  </body>
</html>
