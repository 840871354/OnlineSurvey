<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理员管理页面</title>
    </head>
    <style type="text/css">
        .Header{
            height: 50px;
            width: 100%;
            position:absolute;
            left:0px;
            top:0px;
        }
        .Menu {
            width: auto;
            height: 700px;
            position: absolute;
            left: -9px;
            top: 50px;
            background: #CFCFCF;

        }
        .content{
            background:#F2F2F2;
            width: 81%;
            position: absolute;
            left: 291px;
            top: 50px;
            height:700px;
        }
        body{
            overflow-x:hidden;
        }
    </style>
    <body >
        <div class="Header">
            <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/AfterLogin_NavigationBar.html" scrolling="no" frameborder="0"></iframe>
        </div>
        <div class="Menu">
            <iframe id="Menu Section" name="Menu Section" width="100%" height="100%" src="part/admUser/ad_menu.html" scrolling="no" frameborder="0"></iframe>
        </div>
        <div class="content">
            <iframe id="Content Section" name="Content Section" width="100%" height="100%"   frameborder="0"></iframe>
        </div>
         <div style="position:fixed; bottom:0px; width:100%; text-align:center; c"><h6><font color="#666666">©2020 Violet Inc. All rights reserved.</font></h6></div>
    </body>
</html>
