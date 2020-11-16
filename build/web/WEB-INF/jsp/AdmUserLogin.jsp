<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>管理员登录页面</title>
    </head>
    <style type="text/css">
        body {

            background-position:0% 0%;  
            background-size:cover;  
        }
        .Header{
            height: 50px;
            width: 100%;
            position:absolute;
            left:0px;
            top:0px;
        }
        .login {
            background-color: #FFF;
            opacity: 0.9;
            position: absolute;
            top: 80px;
            right: 450px;
            height: 620px;
            width: 580px;
            border-radius: 15px;
        }
        .input {
            height: 40px;
            width: 300px;
            border-radius: 20px;
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        }
        input:focus{
            border-color: #66afe9;
            outline: 0;
            webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
        }
        .submit {
            height: 50px;
            width: 260px;
            color: #FFF;
            background-color: #36F;
            border-radius: 10px;
        }

    </style>
     <body background="img/user_bg.jpg">
        <div class="Header">
            <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/NavigationBar.html" scrolling="no" frameborder="0"></iframe>
        </div>
        <form action="adminUser/login" method="get">
            <div class="login"><br>

                <label style="text-align:center; margin:0 auto;">
                    <br />
                    <br />
                    <br />
                    <p> <font size="8" face="Arial, Helvetica, sans-serif"> 管理员登录 </font> </p>
                </label>
                <br />
                <br />
                <br /> 

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" name="id" class="input" placeholder="请输入账号" required autofocus>
                <br />
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="password" name="password" class="input" placeholder="请输入密码" required>
                <br />
                <br>
                <br>
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="submit" value="登录" /><br><br><br><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="OrdUserLogin" style="text-decoration:none; color:#000">用户登录</a>
            </div>
        </form>
        <div style="position:fixed; bottom:0px; width:100%; text-align:center; c"><h6><font color="#666666">©2020 Violet Inc. All rights reserved.</font></h6></div>

    </body>
</html>