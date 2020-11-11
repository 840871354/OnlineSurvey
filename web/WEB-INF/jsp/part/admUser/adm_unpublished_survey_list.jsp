<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>调查页面</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div>
            <h1 class ="text">调查列表</h1>

            <br/>
            <table class="table" border="1">
                <tr>
                    <th>调查账户</th>
                    <th>调查姓名</th>
                    <th>密码</th>
                    <th>填写电话号码</th>
                    <th>审查</th>
                    <th>发布日期</th>
                    <th colspan=2>操作</th>
                </tr>
                <c:forEach items ="${unpublishedList}" var="s" varStatus="si">
                    <tr id="tr${s.SId}">
                        <td>${s.SId}</td>
                        <td>${s.SName}</td>
                        <td>${s.SKeyWord}</td>
                        <td>${s.SFinish}</td>
                        <td>${s.SIsRelease}</td>
                        <td>${s.SDateOfRelease}</td>  
                        <td><a href="adminUser/Approved/${s.SId}">批准</a></td>
                        <td><a href="adminUser/Disapproved/${s.SId}">拒绝</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
