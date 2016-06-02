<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="../../js/bbs.js"></script>
  </head>
  	<title>查看根帖</title>
  <body>
    <center>
    
    	<!-- ****************显示根帖信息**************** -->
    	<table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E0E0E0" bordercolordark="white" rules="all" style="margin-top:8;word-break:break-all">
    		 <tr height="30"><td colspan="3" background="${pageContext.request.contextPath }/images/index/classT.jpg" style="text-indent:5"><b><font color="white">■ 显示根帖</font></b></td></tr>
    		  	<tr height="30" bgcolor="#F0F0F0">
              		<td style="text-indent:5" width="27%">★ 楼主</td>
              		<td colspan="2">【主题】${sessionScope.bf.bbstitle }</td>
          		</tr>
          		<tr bgcolor="#F9F9F9">
           				<!-- 发帖者信息 -->
           			<td rowspan="3" align="center" valign="top">
           				<table width="95%" height="180" border="0" cellspacing="0" cellpadding="0" style="margin-top:3">
           					<tr height="35%">
           						<td align="center" width="30%">
           							<img src="${pageContext.request.contextPath }/images/face/user/${sessionScope.userForm.userface}" style="border:1 solid;border-color:#E3E3E3">
           						</td> 
                          		<td style="text-indent:10">
                               		<a href="${pageContext.request.contextPath }/servlet/MasterServlet?username=${sessionScope.bf.bbssender}">
                                  		<b>${sessionScope.userForm.username}</b>
                              		</a>
                          		</td>
           					</tr>
           					<tr>
           						<td align="center">性别：</td>
                          		<td style="text-indent:10">
                                	${sessionScope.userForm.usersex }
                          		</td>
           					</tr>
           					<tr>
           						<td align="center">email：</td>
                          		<td style="text-indent:10">
                                	${sessionScope.userForm.useremail }
                          		</td>
           					</tr>
           					<tr>
                          		<td align="center">来自：</td>
                          		<td style="text-indent:10">
                           			${sessionScope.userForm.userfrom }
                          		</td>
                        	</tr>                                        
           				</table>
           			</td>
           			<!-- 根帖信息 -->
              		<td width="10%">【表情】<img src="${pageContext.request.contextPath }/images/face/bbs/${sessionScope.bf.bbsface}"></td>
              		<td height="30" align="right">发表时间：『${sessionScope.bf.bbssendtime }』&nbsp;</td>
          		</tr>
          		<tr height="130">
          			<td colspan="2" valign="top" style="padding-top:6;padding-left:6;padding-right:6;padding-bottom:6">
          				${sessionScope.bf.bbscontent }
          			</td>
         		</tr>
          			<!-- 实现对根帖进行操作的超链接 -->
          		<tr height="30" bgcolor="#F9F9F9">
             		 <td align="right" colspan="2">
	              		
	              		<!-- 如果该贴不是精华帖子，并且不是置顶帖子(实际上就是普通帖子) -->
	              			<!-- 显示“将帖子提前”超链接 -->
	              		<c:if test="${sessionScope.bf.bbsisgood!='1' }">
	              			<c:if test="${sessionScope.bf.bbsistop!='1' }">
	                                                                                    ◆<a href="${pageContext.request.contextPath}/servlet/DoFristServlet?bbsid=${sessionScope.bf.bbsid}" title="帖子所属者/楼主/管理员操作">将帖子提前</a>&nbsp;
	                    	</c:if>
	                	</c:if>
	                
	                    <!-- 如果该帖不是置顶帖子 --> 
	                    	<!-- 显示“置顶帖子”超链接 -->
	               	   <c:if test="${sessionScope.bf.bbsistop!='1' }">                                
	                                                                    ◆<a href="${pageContext.request.contextPath}/servlet/DoTopServlet?bbsid=${sessionScope.bf.bbsid}" title="管理员操作">置顶帖子</a>&nbsp;
	                   </c:if>
	                    <!-- 如果该帖不是精华帖子 -->                          
	              			<!-- 显示“设为精华帖”超链接 -->
	                   <c:if test="${sessionScope.bf.bbsisgood!='1' }">
	                                                                    ◆<a href="${pageContext.request.contextPath}/servlet/DoGoodServlet?bbsid=${sessionScope.bf.bbsid}" title="管理员操作">设为精华帖</a>&nbsp;                  
	        		   </c:if>
	        			<!-- “删除”超链接 -->
	            			                          			            	                                 
	            		<a href="${pageContext.request.contextPath}/servlet/DeleteRootServlet?bbsid=${sessionScope.bf.bbsid}" title="楼主/管理员操作" onclick="javaScript:return confirm('确认要删除该信息?')">×删除</a>
	            			              
	        		
        			
              		</td>
         	 </tr>          
    	</table>
    
      
      <!-- ****************显示回复帖子**************** --> 
      <table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white"  style="margin-top:2;word-break:break-all">
          <tr height="30"><td background="${pageContext.request.contextPath }/images/index/classT.jpg" style="text-indent:5"><b><font color="white">■ 显示回复帖子</font></b></td></tr>
      </table> 
      
      <!-- 不存在回复帖子列表 -->
      <c:if test="${sessionScope.buMap.size()<=0}">
           <table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="all">
              <tr height="70" bgcolor="#F9F9F9"><td align="center"><li>暂时没有回复帖！</li></td></tr>
           </table>
      </c:if>
      <!-- 存在回复帖子列表 -->
      <c:if test="${sessionScope.buMap.size()>0}">
      		<!-- 遍历回复帖子列表 -->
      	<c:forEach items="${sessionScope.buMap }" var="entry">
      		<table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="all" style="word-break:break-all">
                  <tr height="25" bgcolor="#F0F0F0">
                      <td style="text-indent:5" width="27%">▲ 楼</td>
                      <td colspan="2">【回复主题】</td>              
                  </tr>                  
                  <tr bgcolor="#F9F9F9">
	                  <!-- 回复者信息 -->	                  
	                 <!-- 迭代回复者信息 -->
	                 
                      
                      <td rowspan="3" align="center" valign="top">
                          <table width="95%" height="150" border="0" cellspacing="0" cellpadding="0" style="margin-top:3">
                              <tr height="35%">
                                  <td align="center" width="30%"><img src="${pageContext.request.contextPath }/images/face/user/${entry.value.userface}" style="border:1 solid;border-color:#E0E0E0"></td>
                                  <td style="text-indent:10">
                                      <a href="${pageContext.request.contextPath }/servlet/MasterServlet?username=${entry.value.username}">
                                          <b>${entry.value.username}</b>
                                      </a>
                                  </td>
                              </tr>
                              <tr>
                                  <td align="right">性别：</td>
                                  <td style="text-indent:10">
                                      ${entry.value.usersex }
                                  </td>
                              </tr>
                              <tr>
           						   <td align="center">email：</td>
                          		   <td style="text-indent:10">
                                	 ${entry.value.useremail }
                          	       </td>
           					  </tr>
                              <tr>
                                  <td align="right">来自：</td>
                                  <td style="text-indent:10">
                                      ${entry.value.userfrom }
                                  </td>
                              </tr>                              
                          </table>
                      </td>
                      <!-- 回复帖子信息 -->
                      <td width="10%">【表情】<img src="${pageContext.request.contextPath }/images/face/bbs/${entry.key.bbsanswerface}"></td>
                      <td align="right" height="30">回复时间：『${entry.key.bbsanswersendtime }』&nbsp;</td>
                  </tr>
                  <tr height="130"><td colspan="2" valign="top" style="padding-top:6;padding-left:6;padding-right:6;padding-bottom:6">${entry.key.bbsanswercontent }</td></tr>
                  <!-- 删除回复帖子超链接 -->
                  <tr height="30" bgcolor="#F9F9F9">
                      <td align="right" colspan="2">
                          ◆<a href="${pageContext.request.contextPath }/servlet/DeleteAnswerServlet?bbsanswerid=${entry.key.bbsanswerid}&bbsid=${sessionScope.bf.bbsid}">删除回复</a>&nbsp;
                          ◆<a href="${pageContext.request.contextPath }/view/indexTemp.jsp" >查看根帖</a>&nbsp;
                      </td>            
                  </tr>        
              </table>
		</c:forEach>       
              <table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white">
                  <tr height="15"><td background="${pageContext.request.contextPath }/images/index/boardE.jpg"></td></tr>
              </table>
      </c:if>
      
      
      <!-- ****************回复帖子**************** -->
      
      
      <form action="${pageContext.request.contextPath }/servlet/AddAnswerServlet?" method="get">
      <table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="all">
          
		  <tr bgcolor="#F0F0F0" height="30"><td colspan="2" style="text-indent:5" background="${pageContext.request.contextPath }/images/index/classT.jpg"><b><font color="white">■ 回复【${sessionScope.bf.bbstitle }】帖子</font></b></td></tr>          
          <tr>
              <td width="27%" bgcolor="#F9F9F9" align="center" valign="top">
                  <table border="0" width="90%" height="100%">
                      <tr height="30%">
                          <td valign="top">
                              <table border="0" style="margin-top:10">
                                  <tr>
			                          <td>错误信息</td>
            			          </tr>
			                      <tr>
            			              <td>错误信息</td>
			                      </tr>
                              </table>
                          </td>
                      </tr>
                      <tr>
                      	  <td valign="top">
                      	      <table border="0" width="90%" style="margin-top:10">
                      	          <tr><td>发帖许可</td></tr>
                      	      </table>
                      	  </td>
                      </tr>
                  </table>
              </td>
              <td>
                  <table border="1" width="100" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows">
                      <tr height="30">
                      	  <!-- 封装tb_bbs表的id信息 -->
                      	  <td><input type="hidden" name="bbsid" value="${sessionScope.bf.bbsid}"/></td>
                      	  
                          <td width="15%" align="left">【主题】<b><font >${sessionScope.bf.bbstitle }</font></b></td>
                          <td align="center"><input type="hidden" name="bbsanswertitle" value="${sessionScope.bf.bbstitle }"/></td>
                      </tr>
                      <tr bgcolor="#F9F9F9">
                          <td align="left">【表情】</td>
                          <td><%@ include file="/pages/add/answerface.jsp" %></td>
                      </tr>
                     
                      <tr><td colspan="2" align="center"><textarea name="bbsanswercontent" rows="15" cols="79" styleId="content" onkeydown="check(content,ContentUse,ContentRem,1000)" onkeyup="check(content,ContentUse,ContentRem,1000)" onchange="check(content,ContentUse,ContentRem,1000)"></textarea></td></tr>
                      <tr height="30" align="center">
                          <td colspan="2">
                          	  <input type="submit" value="回复帖子"/>
                          	  <input type="radio" value="重新填写"/>                              
                          </td>
                      </tr>
                  </table>
              </td>
          </tr>
        </table>
      </form>
     
    </center>
  </body>
</html>
