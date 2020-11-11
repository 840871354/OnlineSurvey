<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta charset="utf-8">
        <title>企业注册页面</title>

    </head>
    <style type="text/css">
        body{
            background:url(img/re_bg.jpg);
            background-repeat:repeat-x;
            background-attachment:fixed;
        }
        .information{
            position:absolute;
            margin-left:210px;
            text-align:left;
            top:218px;
        }
        .inputinfo{
            position:absolute;
            margin-left:520px;
            top:218px;
            text-align:left;
        }
        .Header{
            height: 50px;
            width: 100%;
            position:fixed;
            left:0px;
            top:0px;
        }
        .Registered{
            width:900px;
            height:700px;
            text-align:center;
            background:#FFF;
            margin:0 auto;
            margin-top:51px;
        }

    </style>
    <body>
        <form action="corporateUser/companyRegister" method="post">
            <div class="Header">
                <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/NavigationBar.html" scrolling="no" frameborder="0"></iframe>
            </div>
            <div class="Registered">
                <br/><br/><br/>
                <span style="font-size: 38px;">企业用户注册</span><br/>
                <div class="information">
                    企司名称:<br/><br/>
                    企司类型:<br/><br/>
                    企业方向:<br/><br/>
                    企业规模:<br/><br/>
                    企业简介:<br/><br/>
                </div>
                <div class="inputinfo">
                    <input type="text" name="companyName"><br/><br/>
                    <input type="text" name="companyType"><br/><br/>
                    <input type="text" name="companyIndustry"><br/><br/>
                    <input type="text" name="companyScale"><br/><br/>
                    <input type="text" name="companyIntroduction"><br/><br/>
                </div>
                <button type="submit" style="position: absolute; margin-left: 1090px; left: -450px; top:600px; height: 35px; width: 77px; background: #06F; "><font color="#CCCCCC">提交</font></button>
                <button type="reset"style="position: absolute; margin-left: 1000px;  left: -197px; top: 600px; height: 35px; width: 77px;"><font color="#06F">重启</font></button>
                <form>
                    </body>
                    </html>