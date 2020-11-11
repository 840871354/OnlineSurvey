<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>企业用户列表</title>
        <script src="js/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>

        <div class="container text-center">
            <br>
            <h1 class="text-warning">企业用户列表</h1>
            <hr>
            &nbsp;&nbsp;
            <form action="adminUser/searchCompanyUser" method="post">
                <input type="text" name="search" />
                <button type="submit" ><font color="#CCCCCC">查找</font></button>
            </form>
            <br>
            <hr>

            <table class="table table-hover table-striped">
                <tr>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>电子邮箱</th>
                    <th>密码</th>
                    <th>性别</th>
                    <th>生日日期</th>
                    <th>兴趣</th>
                    <th>公司名称</th>
                    <th>选项</th>
                </tr>
                <c:forEach items="${companyUser}" var="c">
                    <tr id="tr${c.cuName}">
                        <td>${c.cuName}</td>
                        <td>${c.cuPhone}</td>
                        <td>${c.cuEmail}</td>
                        <td>${c.cuPassword}</td>
                        <td>${c.cuSex}</td>
                        <td>${c.cuDateOfBirth}</td>
                        <td>${c.cuHobby}</td>
                        <td>${c.company.companyName}</td>
                        <td>
                            <a href="adminUser/toEditCompanyUser/${c.cuName}">编辑</a>
                            <a href="javascript:deleteCompanyUser('${c.cuName}');">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>

            <script>  //Define a function that removes students based on the student's number
                function deleteCompanyUser(name) {
                    $.ajax({
                        url: 'adminUser/deleteCompanyUser',
                        type: 'POST',
                        data: {cuName:name}, //Send a request argument named stuId, the value of the parameter value is the value of the incoming stuId variable
                        success: function () {
                            //If you can perform to success, the background deletion is successful, and the corresponding data row in the table is also deleted here
                            $("#tr" + name).remove(); // Remove is to delete the current element and its contents
                        },
                        error: function (req, status, error) {
                            alert("Ajax request failed, error：" + error);
                        }
                    });
                }
            </script>

        </div>
    </body>
</html>
