<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
    <title>编程体验BBS-论坛</title>
    <link style="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/bbs.js"></script>    
  </head>
  <body bgcolor="#AA8D60">
    <center>
      <table bgcolor="#F0F0F0" border="0" width="800" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white">
        <tr><td><jsp:include page="top.jsp"/></td></tr>
        <tr><td><jsp:include page="menu.jsp"/></td></tr> 
        <tr><td>
        <c:if test="${sessionScope.mainPage=='default.jsp' }">
        	<jsp:include page="default.jsp"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/show/bbs/searchListShow.jsp' }">
        	<jsp:include page="../pages/show/bbs/searchListShow.jsp"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/show/bbs/listRootShow.jsp' }">
        	<jsp:include page="../pages/show/bbs/listRootShow.jsp" flush="true"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/show/bbs/goodListShow.jsp' }">
        	<jsp:include page="../pages/show/bbs/goodListShow.jsp" flush="true"/>
        </c:if> 
        <c:if test="${sessionScope.mainPage=='../pages/show/user/bbsUserSingle.jsp' }">
        	<jsp:include page="../pages/show/user/bbsUserSingle.jsp" flush="true"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/show/bbs/myBbsShow.jsp' }">
        	<tr><td><jsp:include page="../pages/show/bbs/myBbsShow.jsp" flush="true"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/show/bbs/openRootShow.jsp' }">
        	<jsp:include page="../pages/show/bbs/openRootShow.jsp" flush="true"/>
        </c:if>
        <c:if test="${sessionScope.mainPage=='../pages/add/bbsAdd.jsp' }">
        	<jsp:include page="../pages/add/bbsAdd.jsp" flush="true"/>
        </c:if>
        </td></tr>          
        <tr><td height="82"><jsp:include page="end.jsp"/></td></tr>
      </table>
    </center>
  </body>
</html>
