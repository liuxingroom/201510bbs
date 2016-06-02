<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发表帖子</title>
    <script type="text/javascript" src="../../js/bbs.jsp"></script>
  </head>
  
  <body>
    <center>
    <!-- 发表帖子 -->
    	<form action="${pageContext.request.contextPath }/servlet/AddPostServlet" method="get">
    		<table border="1" width="99%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="all" style="margin-top:8">
    			<input type="hidden" name="bbsboardid" value="${sessionScope.boardid }"/>
    			<tr bgcolor="#F0F0F0" height="30">
    				<td colspan="2" style="text-indent:5" background="${pageContext.request.contextPath }/images/index/classT.jpg">
    					<b>
    						<font color="white">■ 发表帖子</font>
    					</b>
    				</td>    				
    			</tr>
    			<tr>
    				 <td width="27%" bgcolor="#F9F9F9" align="center" valign="top">
                  		
	                 	 <table style="margin-top:10">
	                      	<tr>
	                      	  	<td valign="top" width="99%">
	                      	                             发帖许可：<br><br> 
	                      	                                     	                  
	           	                      <b>请不要发表危害祖国的非法信息！</b><br>
	           	                      <b>请不要发表侵犯个人名誉的信息！</b><br>
	           	                      <b>请不要发表不文明内容！</b><br>           	                  
	           	               </td>
	                        </tr>
	                        <tr height="40"><td align="center">违反以上规则所发生的后果自负！</td></tr>
	                     </table>
                    </td>
                     <td>
		                  <table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#E3E3E3" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows">
		                      <tr height="30">
		                          <td width="15%" align="center">【主题】</td>
		                          <td align="center"><input type="text" name="bbstitle" size="77" maxlength="35" styleId="title"/></td>
		                      </tr>
		                      <tr bgcolor="#F9F9F9">
		                          <td align="center">【表情】</td>
		                          <td align="center"><%@ include file="face.jsp" %></td>
		                      </tr>
		                      
		                      <tr><td colspan="2" align="center"><textarea name="bbscontent" rows="15" cols="79" Id="content" onkeydown="check(content,ContentUse,ContentRem,1000)" onkeyup="check(content,ContentUse,ContentRem,1000)" onchange="check(content,ContentUse,ContentRem,1000)"></textarea></td></tr>
		                      <tr height="30" align="center">
		                          <td colspan="2">
		                             <input type="submit" value="提交"/>
		                             <input type="reset" value="重新填写"/>
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
