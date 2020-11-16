<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加新管理员页面</title>
        <base href="${pageContext.request.contextPath}/">
    </head>
    <body>
        <div>
            <br>
            <h2 >添加新管理员</h2>
            <hr>
            <br>
            <form action="adminUser/to_AddManager" method="post">
                <span>账号：</span><input type="text" name="MId" placeholder="此处输入君の名は">
                <br><br>
                <span>密码：</span><input type="text" name="MPassword" placeholder="此处输入你的密码"><br/><br/>
                <input type="submit" value="添加" >
            </form>
            <br>
            <a href="adminUser/managerList">退回</a>
        </div>
    </body>
</html>
