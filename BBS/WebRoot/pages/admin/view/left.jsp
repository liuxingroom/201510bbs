<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>页尾</title>
  </head>
  
  <body>
    <center>
      <table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0">
        <tr height="99">
        	<td align="center" colspan="2">
        		<img src="${pageContext.request.contextPath }/images/admin/adminL.jpg">
        	</td>
        </tr>
        <tr height="35">
              <td align="center">
              	<a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/images/admin/adminB.jpg" style="border:0"></a>
              </td>
              <td align="center">
              	<a href="${pageContext.request.contextPath }/pages/regist.jsp""><img src="${pageContext.request.contextPath }/images/admin/adminE.jpg" style="border:0"></a>
              </td>
        </tr>
        <tr height="33">
        	<td colspan="2"><img src="${pageContext.request.contextPath }/images/admin/menuT.jpg">
        	</td>
        </tr>            
        <tr>
              <td align="center" valign="top" colspan="2">
                  <table border="0" width="100%" cellspacing="0" cellpadding="0" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white" style="margin-top:1">
                      <tr bgcolor="#F0F0F0" height="33">
			              <td style="text-indent:5" colspan="2" background="${pageContext.request.contextPath }/images/admin/menu.jpg"><b><font color="white">■ 类别管理</font></b></td>
				      </tr>
				      <tr height="34">  <td style="text-indent:40" colspan="2" background="${pageContext.request.contextPath }/images/admin/subMenu.jpg"><a href="${pageContext.request.contextPath }/servlet/ClassListServlet">查看论坛类别</a></td></tr>
				      <tr height="34">  <td style="text-indent:40" colspan="2" background="${pageContext.request.contextPath }/images/admin/subMenu.jpg"><a href="${pageContext.request.contextPath }/servlet/ClassAddServlet">添加论坛类别</a></td></tr>
				      <tr bgcolor="#F0F0F0" height="33">
				            <td style="text-indent:5" colspan="2" background="${pageContext.request.contextPath }/images/admin/menu.jpg"><b><font color="white">■ 版面管理</font></b></td>
				      </tr>
				      <tr height="34">  <td style="text-indent:40" colspan="2" background="${pageContext.request.contextPath }/images/admin/subMenu.jpg"><a href="${pageContext.request.contextPath }/servlet/BoardListServlet">查看版面</a></td></tr>
				      <tr height="34">  <td style="text-indent:40" colspan="2" background="${pageContext.request.contextPath }/images/admin/subMenu.jpg"><a href="${pageContext.request.contextPath }/servlet/BoardAddServlet">添加版面</a></td></tr>
				      <tr bgcolor="#F0F0F0" height="33">
				            <td style="text-indent:5" colspan="2" background="${pageContext.request.contextPath }/images/admin/menu.jpg"><b><font color="white">■ 用户管理</font></b></td>
				      </tr>
				      <tr height="34">  <td style="text-indent:40" colspan="2" background="${pageContext.request.contextPath }/images/admin/subMenu.jpg"><a href="${pageContext.request.contextPath }/servlet/ACIDServlet">查看/修改/删除用户</a></td></tr>				      
                  </table>
              </td>
        </tr>
      </table>
    </center>
  </body>
</html>
