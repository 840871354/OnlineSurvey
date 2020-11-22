<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <base href="${pageContext.request.contextPath}/">
        <meta charset="utf-8">
        <title>公司用户注册页面</title>
        <script type="text/javascript">
            function showPreview(source) {
                var file = source.files[0];
                if (window.FileReader) {
                    var fr = new FileReader();
                    fr.onloadend = function (e) {
                        document.getElementById("portrait").src = e.target.result;
                    };
                    fr.readAsDataURL(file);
                }
            }
        </script> 
    </head>
    <style type="text/css">
        body{
            background:url(img/re_bg.jpg);
            background-repeat:repeat-x;
            background-attachment:fixed;
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
        .information{
            position:absolute;
            margin-left:110px;
            text-align:left;
            top:218px;
        }
        .inputinfo{
            position:absolute;
            margin-left:440px;
            top:220px;
            text-align:left;
        }
        .img{
            width:auto;
            height:auto;
            position:absolute;
            margin-left:650px;

        }
        .inputimg{
            position:absolute;
            margin-left:680px;
            margin-top:220px;
        }
        .identity{
            position: absolute;
            bottom: 125px;
            margin-left: 100px;

        }
        #company{
            position:absolute;
            left:340px;
            bottom: 0px;

        }
        .addcompany{
            position:absolute;
            width:auto;
            left:950px;
            bottom:0px;
        }

    </style>
    <body>
        <form action="corporateUser/register" method="post" enctype="multipart/form-data">
            <div class="Header">
                <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/NavigationBar" scrolling="no" frameborder="0"></iframe>
            </div>
            <div class="Registered">
                <br/><br/><br/>
                <span style="font-size: 38px;">公司用户注册</span><br/>
                <br/><br/><br/>
                <div class="information">
                    姓名:<br/><br/>
                    手机电话号码:<br/><br/>
                    邮箱地址:<br/><br/>
                    生日日期:<br/><br/>
                    爱好:<br/><br/>
                    性别:<br/><br/><br/>
                    密码:<br/><br/>
                    确认密码:<br/><br/>
                    公司姓名:<br/><br/>
                </div>
                <div class="inputinfo">
                    <input type="text" name="name"><br/><br/>
                    <input type="text" name="phone"><br/><br/>
                    <input type="text" name="email"><br/><br/>
                    <input type="date" name="dob"><br/><br/>
                    <select name="hobby"> 
                        <option value="read">阅读</option> 
                        <option value="music">听音乐</option> 
                        <option value="scientific research">搞科学研究</option>
                        <option value="car">开车车</option>
                        <option value="game">Van♂游戏</option>
                        <option value="movie">康电影</option>
                    </select> <br/><br/>
                    <label><input name="Gender" type="radio" value="male" checked="checked" />男性 </label>
                    <label><input name="Gender" type="radio" value="female" />女性 </label>
                    <br/><br/>
                    <input name="pass" type="password"><br/><br/>
                    <input name="cpass" type="password"><br/><br/>

                    <select name="companyName">
                        <c:forEach items ="${company}" var="c" varStatus="ci">
                            <option value="${c.companyName}">${c.companyName}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="img">
                    <img id="portrait" src="" width="200px" height="200px" ><br/><br/>	
                </div>
                <div class="inputimg">
                    <input type="file" name="photo" onchange="showPreview(this)"  accept="image/*"/>
                    <!--enctype="multipart/form-data"--> 
                </div>
                <button type="submit" style="position: absolute; margin-left: 1090px; left: -450px; top: 647px; height: 35px; width: 77px; background: #06F; "><font color="#CCCCCC">提交</font></button>
                <button type="reset"style="position: absolute; margin-left: 1000px;  left: -197px; top: 649px; height: 35px; width: 77px;"><font color="#06F">重置</font></button>

                <div class="addcompany">
                    <a href="CompanyRegistered.html"  style="text-decoration:none; color:#000;">点击此处添加您的公司</a></div>
            </div>
        </form>
    </body>
</html>
