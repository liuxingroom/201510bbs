<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加版面</title>
  </head>
  
  <body>
    <center>
    	<br>
    	<form action="${pageContext.request.contextPath }/servlet/AddPageServlet">
    		<table border="0" height="250" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="all">
         
          <tr>
              <td align="center" width="30%">所属类别：</td>
              <td>
			      <select name="boardclassid">
			      	<c:forEach items="${sessionScope.cfList }" var="cf">
			      		<option value="${cf.classid }">${cf.classname }</option>
			      	</c:forEach>
			      </select>
			  </td>
	      </tr>
          <tr>
                 <td align="center">版面名称：</td>
                 <td><input type="text" name="boardname" size="45"/>
          </tr>
   	      <tr>
          		<td></td>
          		<td></td>
          </tr>          
          <tr>
                 <td align="center">版&nbsp;&nbsp;&nbsp;&nbsp;主：</td>
                 <td><input tupe="text" name="boardmaster" size="45">
          </tr>
   	      <tr>
          		<td></td>
          		<td></td>
          </tr>          
          <tr>
                 <td align="center">版面公告：</td>
                 <td><input type="text" name="boardpcard" size="45"/>
          </tr>          
   	      <tr>
          		<td></td>
          		<td></td>
          </tr>
          <tr>
                 <td></td>
                 <td>
                     <input type="submit" value="添加"/>
                     <input type="reset" value="重置"/>
                 </td>  
          </tr>
    
      </table>
    	</form>
    </center>
  </body>
</html>
