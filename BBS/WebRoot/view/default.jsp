<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	 <title>首页中内容显示区中的内容</title>
  </head>
  
  <body>
    <table border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top:8">
        	<c:forEach items="${sessionScope.map }" var="entry">
        		<tr>
        			<td>
        				<table rules="none" border="1" width="100%"  cellspacing="0" cellpadding="3" bordercolor="lightgrey" >
        					<tr  height="30">
        						<td style="text-indent:5" background="${pageContext.request.contextPath }/images/index/classT.jpg">
        							<b>
        								<font color="white">■ ${entry.key.classname}</font>
        							</b>
        						</td>
        					<tr>
        					<tr bgcolor="#F9F9F9">
        						<td height="60" align="center">
        							<c:if test="${entry.value==null }">
        								<li>该论坛类别暂无版面显示！</li>
        							</c:if>
        							 
        							<c:if test="${entry.value!=null }">
        								<c:forEach items="${entry.value }" var="key">
        									<table border="1" width="100%" cellspacing="0" cellpadding="4" bgcolor="#F9F9F9" bordercolor="#EEEEEE" bordercolorlight="#EEEEEE" bordercolordark="white" rules="cols">
        										<tr height="35">
        											<td align="center" width="60" rowspan="2"><img src="${pageContext.request.contextPath }/images/index/boardPic.jpg"></td>
        											<td>
        												<img src="${pageContext.request.contextPath }/images/index/btitle.jpg">
        												<a href="${pageContext.request.contextPath }/servlet/RootShowServlet?classId=${key.boardclassid}&boardId=${key.boardid}">
        													<font>${key.boardname}</font>
        												</a>
        											</td>
        											<td rowspan="2" width="20%" align="center">
        												<table border="0" width="90%" cellspacing="3" cellpadding="0">
        													<tr>
        														<td>帖子总数：<b><font color="blue">${key.boardBbsnum }</font></b></td>
        													</tr>
        													<tr>
        														<td>精华帖子：<b><font color="green">${key.boardBbsundonum }</font></b></td>
        													</tr>
        													<tr>
        														<td>未 回 复：<b><font color="red">${key.boardBbsgoodnum }</font></b></td>
        													</tr>
        												</table>
        											</td>
        										</tr>
        										<tr height="25" background="${pageContext.request.contextPath }/images/index/masterB.jpg">
        											<td style="text-indent:60">
        												<img src="${pageContext.request.contextPath }/images/index/master.jpg">
        												<a href="${pageContext.request.contextPath }/servlet/MasterServlet?username=${key.boardmaster}">      
    	            		                              斑竹：${key.boardmaster }
    	            		                            </a>
        											</td>
        										</tr>
        									</table>
        								</c:forEach>
        							</c:if>
        						</td>
        					</tr>
        					 <tr height="25"><td style="text-indent:10" background="${pageContext.request.contextPath }/images/index/boardE.jpg"><font color="#F9F9F9)">论坛介绍:${entry.key.classintro }</font></td></tr>
        				</table>
        			</td>
        		</tr>
        		<tr height="3"><td></td></tr>	
        	</c:forEach>
        </table>
  </body>
</html>
