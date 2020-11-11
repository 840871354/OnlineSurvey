<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>调查表页面</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div>
            <h1 class ="text">调查表</h1>

            <br/>
            <table class="table" border="1">
                <tr>
                    <th>调查编号</th>
                    <th>调查姓名</th>
                    <th>密码</th>
                    <th>发布日期</th>
                    <th>完成编号</th>
                    <th>操作</th>
                </tr>
                <c:forEach items ="${SurveyList}" var="s" varStatus="si">
                    <tr id="tr${s.SId}">
                        <td>${s.SId}</td>
                        <td>${s.SName}</td>
                        <td>${s.SKeyWord}</td>
                        <td>${s.SDateOfRelease}</td>  
                        <td>${s.SFinish}</td>
                        <td><a href="ordinaryUser/questionaire/${s.SId}">开始答题</a></td>                       
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
