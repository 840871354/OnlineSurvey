<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<base href="${pageContext.request.contextPath}/">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>用户登录页面</title>
    </head>
    <style type="text/css">
        body {
            background-repeat:no-repeat;  
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
        .submit {
            height: 50px;
            width: 280px;
            color: #FFF;
            background-color: #36F;
            border-radius: 10px;
        }

    </style>
    <body background="img/user_bg.jpg">

        <div class="Header">
            <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/NavigationBar.html" scrolling="no" frameborder="0"></iframe>
            <form action="corporateUser/login" method="get">
                <div class="login"><br>
                    <label>
                        <p> <font  size= 5;face="Yu Gothic Light"> <span class="login1">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <a href="OrdUserLogin"  style="text-decoration:none; color:#999">个人用户 </a></font> <font  size= 5;face="Yu Gothic Light" > 
                                                                                                                              <span class="login2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <a style="text-decoration:none; color:#000">企业用户 </a></font> </p>
                    </label>
                    <br>
                    <label style="text-align: center; margin:0 auto;">
                        <p> <font size="10" face="Arial, Helvetica, sans-serif"> 登录 </font> </p>
                    </label>
                    <br />
                    <br />  
                    <br />                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="id" class="input" placeholder="请输入您的账号" required autofocus>
                    <br />
                    <br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="password" name="password" class="input" placeholder="请输入您的密码" required>
                    <br />
                    <br />
                    <br />
                    <br />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" class="submit" value="登录" />
                    <br><br><br>
                    <label>
                        <br/><br/>                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="AdmUserLogin" style="text-decoration:none; color:#000">管理员登入</a>
                    </label>
                </div>
            </form> 
            <div style="position:fixed; bottom:0px; width:100%; text-align:center; c"><h6><font color="#666666">©2020 Violet Inc. All rights reserved.</font></h6></div>
    </body>
</html>

