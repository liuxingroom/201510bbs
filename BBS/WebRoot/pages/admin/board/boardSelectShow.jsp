<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>通过筛选论坛的类别来选择版本</title>
  </head>
  
  <body>
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/BListShowServlet" method="post">
    		<table border="0" width="580" cellspacing="0" cellpadding="0">
    			<tr>
	              <td align="center">
				     选择论坛类别：       
						  <select name="classid">
						  	 <c:forEach items="${sessionScope.cfList }" var="cf">
						  	 	<option value="${cf.classid }">${cf.classname }</option>
						  	 </c:forEach>				
						  </select>	          
				  </td>
	     		</tr>
	     		<tr>
	     			<td>&nbsp; </td>
	     		</tr>
	     		<tr>
	     			<td align="center">
	     				<input type="submit" value="显示"/>
	     			</td>
	     		</tr>
    		</table>
    	</form>
    </center>
  </body>
</html>
