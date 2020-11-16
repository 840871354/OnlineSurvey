<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <base href="${pageContext.request.contextPath}/">
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>标题页面</title>
        <style type="text/css">
            button {
                margin-top:9px;
                height:35px;
                width:77px;
                border-radius: 20px;
                border-color:#06F;
            }
        </style>
    </head>
    <body>
        <%
            HttpSession s = request.getSession();
        %>

        <div style="background:#333; height:50px; width:100%; position:absolute; left:0px; top:0px;">
            <font size="+3" color="#CCCCCC">在线调查</font>
            <a href="CorUserLogin.html"target="_parent">  <button type="button" style=" position:absolute;margin-left:1090px;"><font color="#06F">注销</font></button> </a>
            <a href="to_Edit_Personal_Info" target="_parent"><button type="button" style=" position:absolute;margin-left:1000px; background:#06F"><font color="#FFFFFF"><%=s.getAttribute("user")%></font></button></a>
            <!--            <font style="color:#FFF"><B>Welcome！</b></font>-->
        </div>
    </body>
</html>
