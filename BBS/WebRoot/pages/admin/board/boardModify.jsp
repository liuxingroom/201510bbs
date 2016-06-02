<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看某个版面详细内容</title>
  </head>
  
  <body>
    <center>
    	<form action="${pageContext.request.contextPath }/servlet/UpdateBoardServlet" method="get">
    		 <table border="0" width="90%" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" rules="none">
	          <tr height="60"><td colspan="2" style="text-indent:5">■ 修改版面</td></tr>
    	      <tr height="50">
	                <td align="right" width="30%">版面ID：&nbsp;&nbsp;</td>
	                <td style="text-indent:5"><input type="hidden" name="boardid" value="${sessionScope.boardForm.boardid }"/>${sessionScope.boardForm.boardid }</td>
	          </tr>
              <tr>
                    <td align="right" width="30%">所属类别：&nbsp;&nbsp;</td>
                    <td>
			            <select name="boardclassid">
			            	<c:forEach items="${sessionScope.cfList }" var="cf"> 
			            		<option value="${cf.classid }" 
			            			<c:if test="${cf.classid==sessionScope.boardForm.boardclassid }">
			            				selected="selected"
			            			</c:if>
			            		>${cf.classname }</option>
			            	</c:forEach>
			            	
			            </select>
			        </td>
	          </tr>	          
	          <tr height="50">
	                <td align="right">版面名称：&nbsp;&nbsp;</td>
    	            <td><input type="text" name="boardname" value="${sessionScope.boardForm.boardname }" size="50"/></td>
    	      </tr>
    	      <tr>
	          		<td></td>
	          		<td></td>
	          </tr>
	          <tr height="50">
	                <td align="right">版主：&nbsp;&nbsp;</td>
	                <td><input type="text" name="boardmaster" value="${sessionScope.boardForm.boardmaster }" size="50"/></td>
	          </tr>
	          <tr>
	          		<td></td>
	          		<td></td>
	          </tr>
    	      <tr height="50">
	                <td align="right">版面公告：&nbsp;&nbsp;</td>
	                <td><input type="text" name="boardpcard" value="${sessionScope.boardForm.boardpcard }" size="50"/></td>
	          </tr>
	          <tr>
	          		<td></td>
	          		<td></td>
	          </tr>
    	      <tr height="50">
	                <td>&nbsp;</td>
	                <td>
	                    <input type="submit" value="提交"/>
    	            </td>
	          </tr>	      	      
          </table>
    	</form>
    </center>
  </body>
</html>
