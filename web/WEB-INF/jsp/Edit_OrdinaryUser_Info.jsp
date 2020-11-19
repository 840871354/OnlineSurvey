<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta charset="utf-8">
        <title>个人信息修改页面</title>
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
        /*        .identity{
                    position: absolute;
                    bottom: 125px;
                    margin-left: 100px;
        
                }*/
        #company{
            position:absolute;
            left:340px;
            bottom: 0px;

        }
        .addcompany{
            position:absolute;
            width:auto;
            left:900px;
            bottom:0px;
        }

    </style>
    <body>
        <form action="ordinaryUser/Edit_OrdinaryUser_Info" method="post" enctype="multipart/form-data">
            <div class="Header">
                <iframe id="Header Section" name="Header" width="100%" height="50px" src="part/AfterLogin_NavigationBar" scrolling="no" frameborder="0"></iframe>
            </div>
            <div class="Registered">
                <br/><br/><br/>
                <span style="font-size: 38px;">修改个人信息</span><br/>
                <br/><br/><br/>
                <div class="information">
                    姓名:<br/><br/>
                    手机电话号码:<br/><br/>
                    电子邮箱地址:<br/><br/>
                    生日日期:<br/><br/>
                    兴趣:<br/><br/>
                    性别:<br/><br/><br/>
                    密码:<br/><br/>
                    确认密码:<br/><br/>
                </div>
                <div class="inputinfo">
                    <c:forEach items="${ordinaryUser}" var="o" varStatus="ou">
                        <input type="text" name="name" value="${o.ouName}" readonly="readonly"><br/><br/>
                        <input type="text" name="phone" value="${o.ouPhone}"><br/><br/>
                        <input type="text" name="email" value="${o.ouEmail}"><br/><br/>
                        <input type="date" name="dob" value="${o.ouDateOfBirth}"><br/><br/>
                        <input type="hidden" id="hobby" name="userHobby" value="${o.ouHobby}"/>
                        <select id="hobbyOption" name="hobby"> 
                            <option value="read">读书</option> 
                            <option value="music">音乐</option> 
                            <option value="scientific research">搞科学研究>
                            <option value="car">开车车</option>
                            <option value="game">Van♂游戏</option>
                            <option value="movie">看电影</option>
                        </select> <br/><br/>
                        <input type="hidden" id="gender" name="userGender" value="${o.ouSex}"/>
                        <label><input name="Gender" type="radio" value="male" checked="checked" />男性 </label>
                        <label><input name="Gender" type="radio" value="female" />女性 </label>
                        <br/><br/>
                        <input name="pass" type="password" value="${o.ouPassword}"><br/><br/>
                        <input name="cpass" type="password"><br/><br/>
                    </div>
                    <div class="img">
                       <img id="portrait" src="http://localhost:8080/OnlineSurvey${o.ouPhoto}" width="200px" height="200px"><br/><br/>
                    </div>
                    <input type="hidden" id="img" name="userImage" value="${o.ouPhoto}" />

                    <div class="inputimg">
                        <input type="file" name="photo" onchange="showPreview(this)"   accept="image/*"/>
                    </div>

                </c:forEach>
                <button type="submit" style="position: absolute; margin-left: 1090px; left: -450px; top: 647px; height: 35px; width: 77px; background: #06F; "><font color="#CCCCCC">提交</font></button>
                <button type="reset"style="position: absolute; margin-left: 1000px;  left: -197px; top: 649px; height: 35px; width: 77px;"><font color="#06F">重置</font></button>
            </div>
        </form>
        <script>
            var hobby = $("#hobby").val()
            $("#hobbyOption" option[value = '"+hobbyOption+"']).attr("selected", true);
//            var src = document.getElementById('img').value;
//            document.write(src);
//            document.getElementById('portrait').src = src;
//            $("#portrait").attr("src",photo);
        </script>
    </body>
</html>
