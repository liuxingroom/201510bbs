<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>编程体验BBS-论坛 后台</title>
     <link style="text/css" rel="stylesheet" href="css/style.css">
     <script type="text/javascript" src="js/bbs.js">
     </script>  
  </head>
  
  <body bgcolor="#AA8D60">
     <center>
      <table border="0" width="800" cellspacing="0" cellpadding="0">
        <tr>
            <td rowspan="3" width="172" align="center" valign="top" background="${pageContext.request.contextPath }/images/admin/back.jpg"><jsp:include page="left.jsp"/></td>
            <td align="center"><jsp:include page="top.jsp"/></td>
        </tr>
        <tr height="33">
        	<td width="center" align="center" background="${pageContext.request.contextPath }/images/admin/message.jpg">
        		<p>此处用来提示错误信息</p>
        	</td> 
        </tr>        
        <tr height="430">
        	<td align="center" valign="top" background="${pageContext.request.contextPath }/images/admin/content.jpg">
        			<c:if test="${sessionScope.backMainPage=='default.jsp' }">
        				<jsp:include page="default.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../class/classListShow.jsp' }">
        				<jsp:include page="../class/classListShow.jsp"/>
        			</c:if>    
        			<c:if test="${sessionScope.backMainPage=='../class/classSingle.jsp' }">
        				<jsp:include page="../class/classSingle.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../class/classModify.jsp' }">
        				<jsp:include page="../class/classModify.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../class/classAdd.jsp' }">
        				<jsp:include page="../class/classAdd.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../user/selectUser.jsp' }">
        				<jsp:include page="../user/selectUser.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../user/userListShow.jsp' }">
        				<jsp:include page="../user/userListShow.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../user/userModify.jsp' }">
        				<jsp:include page="../user/userModify.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../board/boardSelectShow.jsp' }">
        				<jsp:include page="../board/boardSelectShow.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../board/boardListShow.jsp' }">
        				<jsp:include page="../board/boardListShow.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../board/boardAdd.jsp' }">
        				<jsp:include page="../board/boardAdd.jsp"/>
        			</c:if>
        			<c:if test="${sessionScope.backMainPage=='../board/boardModify.jsp' }">
        				<jsp:include page="../board/boardModify.jsp"/>
        			</c:if>
        			  
        			 			
        	</td>
        </tr>
        <tr>
        	<td width="center" colspan="2">
        		<jsp:include page="end.jsp"/>
        	</td>
        </tr>
      </table>
    </center>
  </body>
</html>
