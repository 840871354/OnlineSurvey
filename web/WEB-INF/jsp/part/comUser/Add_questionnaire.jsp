<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>添加问卷页面</title>
        <base href="${pageContext.request.contextPath}/">
    </head>
    <style>
        label{
            display: inline-block;
            padding: 3px 6px;
            text-align: left;
            width:300px;

        }
        fieldset{
            background-color: #f1f1f1;
            border: none;
            border-radius: 2px;
            margin-bottom: 12px;
            overflow: hidden;
            padding: 0 .625em;
        }

    </style>
    <script>
        var nowDate = new Date();
        var myDate = nowDate.toLocaleDateString();
        window.onload = function () {
            dateShow();
        }
        function dateShow() {
            document.getElementById('date').value = myDate;
        }
    </script>
    <body>
        <%
            HttpSession s = request.getSession();
        %>
        <h1>添加新问卷</h1>
        <form action="corporateUser/addSurveyService">
            <p><label><font size="4">问卷名称:</font></label><input type="text" name="SName" required></p>
            <p><label><font size="4">公司名称:</font></label><input type="text" name="CName" required readonly value="<%=s.getAttribute("companyName")%>"></p>
            <p><label><font size="4">人员:</font></label><input type="text" name="UName" required readonly value="<%=s.getAttribute("user")%>"></p>
            <p><label><font size="4">关键词:</font></label><input type="text" name="KeyWord" required></p>
            <p><label><font size="4">发行日期:</font></label><input id="date" type="text"name="date" readonly required></p>
            <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="corporateUser/addSurveyPage"><input type="button" value="重启"></a>
        </form>
    </body>
</html>

