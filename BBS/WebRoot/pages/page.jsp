<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分页导航栏</title>
  </head>
  
  <body>
    <table border="0" width="100%" cellspacing="0">
        <tr>
            <td width="37%" align="center"></td>
            <td align="center" width="37%"></td>
            <form action="${param['gowhich']}" method="post">
           		<table align="right">
              		<tr align="right">
           		 		<td width="26%" align="right">
                转到：
                			<input type="text" name="showpage" size="7">
                			sss
                			<input type="submit" value="跳转页面">
            			</td>
              		</tr>
              </table>
            </form>
        </tr>
    </table>
  </body>
</html>
