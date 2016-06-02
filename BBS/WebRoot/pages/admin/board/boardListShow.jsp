<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列表查看版面</title>
  </head>
  
  <body>
    <center>
    	<table border="1" width="580" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows">
          <tr height="29"><td background="images/admin/backLT.jpg" colspan="5" style="text-indent:5"><b><font color="white">■ 查看版面</font></b></td></tr>	      
	      <tr height="30" bgcolor="#F0F0F0">
	          <td width="15%" align="center">版面ID</td>
	          <td width="40%" align="center">版面名称</td>
	          <td width="25%" align="center">斑竹</td>	          
	          <td width="20%" align="center" colspan="2">操作</td>
	      </tr>
          <c:if test="${sessionScope.bfList.size()<=0 }">
              <tr height="80" align="center" bgcolor="#FBFBFB"><td colspan="5"><li>没有版面可显示！</li></td></tr> 
          </c:if>
          <c:if test="${sessionScope.bfList.size()>0 }">
              <tr>
                  <td colspan="5">
                  <table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="rows">              
                  <c:forEach items="${sessionScope.bfList }" var="bf">
                      <tr height="35" bgcolor="#FBFBFB">
                            <td width="15%" align="center">${bf.boardid}</td>
                            <td width="40%" align="center">${bf.boardname }</td>
                            <td width="25%" align="center">${bf.boardmaster }</td>
                            <td align="center"><a href="${pageContext.request.contextPath }/servlet/GetBoardServlet?boardid=${bf.boardid}">√修改</a></td>
                            <td align="center"><a href="${pageContext.request.contextPath }/servlet/DeleteBoardServlet?boardid=${bf.boardid}&boardclassid=${bf.boardclassid}" onclick="javaScript:return confirm('确认要删除该信息?')">×删除</a></td>
                      </tr>
                  </c:forEach>
                  </table>
                  </td>
              </tr>
         </c:if>                  
	      <tr height="19" style="background-image:url('${pageContext.request.contextPath }/images/admin/backLE.jpg')"><td colspan="5"></td></tr>	                
      </table>
    </center>
  </body>
</html>
