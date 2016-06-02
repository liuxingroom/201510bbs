<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示搜索结果</title>
  </head>
  
  <body>
    <center>
    	<table  border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows" style="margin-top:8">
    		<tr height="30">
    			<td colspan="5" background="${pageContext.request.contextPath }/images/index/classT.jpg" style="text-indent:5">
    				<b><font color="white">■ 搜索帖子</font></b>
    			</td>
    		</tr>
    		<tr height="30" align="center" bgcolor="#F0F0F0">
               <td width="7%">状态</td>
               <td width="35%">帖子标题</td>
               <td width="8%">回复数</td>
               <td width="25%">发布者</td>
               <td width="25%">最后回复</td>
          	</tr>
          	 <!-- 搜索帖子列表不存在 -->
          	<c:if test="${sessionScope.bfList.size()<=0 }">
          		<tr height="180">
          			<td align="center" colspan="5" bgcolor="#F9F9F9">
          				<li>对不起，未找到符合条件的帖子！</li>
          			</td>
          		</tr>
          	</c:if>
          	<!-- 搜索帖子列表存在 -->
          	<c:if test="${sessionScope.bfList.size()>0 }">
   
          			<tr>
          				<td colspan="5">
          					<table  border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="all">
          						<!-- 遍历搜索帖子列表 -->
          						<c:forEach items="${sessionScope.bfList }" var="bf">
          							<tr height="30" bgcolor="#F9F9F9">
          								<td width="7%" align="center">
          									  <c:if test="${bf.bbsisgood=='1' }">
                  	    						  精华
	                  	      				  </c:if>
                        	  				  <c:if test="${bf.bbsistop=='1' }">
      		                					  置顶
                   		      				  </c:if>	
                   		     					
                  	    		  			  <c:if test="${bf.bbsistop=='0'  }">
                  	    		  			  	 <c:if test="${ bf.bbsisgood=='0'}">
      		                	     				 普通
      		                	     			 </c:if>
                    		     			  </c:if>
	                  	     					
          								</td>
          								<td width="35%" style="text-indent:10">
          									<img src="${pageContext.request.contextPath }/images/face/bbs/${bf.bbsface}"/>
          									<a href="#?method=openShow&bbsId=${bf.bbsid}">${bf.bbstitle }</a>
          								</td>
          								<td width="8%" align="center">
          									${bf.bbsAnswerNum }
          								</td>
          								<td width="25%" align="center">
          									<a href="${pageContext.request.contextPath }/servlet/MasterServlet?username=${bf.bbssender}">
          										<b>${bf.bbssender }</b><br/>
          										${bf.bbssendtime }
          									</a>
          								</td>
          								<td width="25%" align="center">
          									<a href="${pageContext.request.contextPath }/servlet/MasterServlet?username=${bf.bbsLastUpdateUser}">
          										<b>${bf.bbsLastUpdateUser }</b><br/>
          										${bf.bbsLastUpdateTime }
          									</a>
          								</td>
          							</tr>
          						</c:forEach>
          					</table>
          				</td>
          			</tr>
          		
          	</c:if>
          	<tr height="10"><td colspan="6"></td></tr>
          	<tr height="30">
          		<td colspan="6" background="${pageContext.request.contextPath }/images/index/boardE.jpg">
          			
          		</td>
          	</tr>
    	</table>
    </center>
  </body>
</html>
