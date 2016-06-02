<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String[] weekdays={"","日","一","二","三","四","五","六"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
    	days[i]="";

    Date currentDay = new Date();
    int year=1900+currentDay.getYear();
    int month=currentDay.getMonth();
    int today=currentDay.getDate();
    int weekday=currentDay.getDay()+1;
    
    String now=year+"年"+(month+1)+"月"+today+"日"+" 星期"+weekdays[weekday];
%>
<html>
  <head>
 	<title>页眉</title>
    <script type="text/javascript">
        function showTime(showWhere){
            var now=new Date();
	        var hour=now.getHours();
	        var minu=now.getMinutes();
	        var sec=now.getSeconds();
         
            if(hour<10) hour="0"+hour;
         	if(minu<10) minu="0"+minu;
         	if(sec<10) sec="0"+sec;
         	
         	showWhere.value=hour+":"+minu+":"+sec;
            setTimeout("showTime(time)",1000)
        }
      </script>
  </head>
  
  <body onload="showTime(time)" bgcolor="#F0F0F0">
     <center>
      <table border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top:1">
        <tr height="38">
            <td colspan="2" background="${pageContext.request.contextPath }/images/index/menu.jpg">
              <table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0">
                <tr height="50%" style="font-size:10pt">
                    <td align="center">
                        <%=now %>
                        <input type="text" style="border:0;background-color:#F7F7F7" disable="true" id="time" size="9">
                    </td>
                    <td align="center" width="8%"><a href="${pageContext.request.contextPath }/index.jsp">首 页</a></td>
                    <td align="center" width="8%"><a href="${pageContext.request.contextPath }/pages/login.jsp">登 录</a></td>
                    <td align="center" width="10%"><a href="${pageContext.request.contextPath }/servlet/MyPostServlet">我的帖子</a></td>
                    <td align="center" width="10%"><a href="${pageContext.request.contextPath }/servlet/GoodPostServlet">精华帖子</a></td>
                    <td align="center" width="10%"><a href="${pageContext.request.contextPath }/servlet/BackGroundServlet">进入后台</a></td>
                    <td align="center" width="8%"><a href="${pageContext.request.contextPath }/pages/regist.jsp">注 册</a></td>
                    <td align="center" width="8%"><a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注 销</a></td>
     
                </tr>                
              </table>
            </td>
        </tr>
        <tr height="40">
            <td width="529" align="center" background="${pageContext.request.contextPath }/images/index/indexP.jpg">                
                <marquee 
			      onmouseover=this.stop()
				  onmouseout=this.start()				  
                  scrollamount="1"
				  scrolldelay="10"
				  direction="left"
				  width="470">
				  <img src="${pageContext.request.contextPath }/images/index/pcard.gif"> BBS服务热线：(0431)8491*** E-mail：BBS***@BBS.com
		        </marquee>
            </td>
            <td align="center" width="271" background="${pageContext.request.contextPath }/images/index/messages.jpg">
	           <%--  <html:errors property="userOpR"/>
	            <html:errors property="sqlvalue"/>
	            --%>
	            ssssssssss
            </td>
        </tr>
    
        <form action="${pageContext.request.contextPath }/servlet/SearchServlet" method="post">
        <tr height="38">
            <td colspan="2" background="${pageContext.request.contextPath }/images/index/indexS.jpg" align="center">
                <table border="0" width="98%">
                    <tr>
                        <td width="25%">
                        	
                        	<c:if test="${sessionScope.user==null }">
                        		<font color="red" size="3px">游客，您还没有登录    请登录！</font>
                        	</c:if>
                        	<c:if test="${sessionScope.user!=null }">
                        		<font >欢迎登录：${sessionScope.user.username}</font>
                        	</c:if>
                        	
                        </td>
                        <td align="right">                                        
			                条件：
		            		<select name="subsql">
		            			<option value="bbstitle">帖子标题</option>
		            		</select>
  
			                关键字：
            			    <input type="text" name="sqlvalue" size="30"/>
			                <input type="radio" name="searchtype" value="like" checked="checked"/>模糊
			                <input type="radio" name="searchtype" value="all"/>精确
               				<input type="submit" value="收索"/>
                        </td>
                    </tr>                    
                </table>
            </td>
        </tr>
        </form>
      </table>
    </center>
  </body>
</html>
