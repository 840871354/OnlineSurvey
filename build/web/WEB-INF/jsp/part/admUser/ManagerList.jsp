<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP 页面</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>

        <div class="container text-center">
            <br>
            <h1 class="text-warning">列表</h1>
            <hr>
            <a href="adminUser/addManager">添加新管理员</a>
            &nbsp;&nbsp;
            <br>
            <hr>

            <table class="table table-hover table-striped">
                <tr>
                    <th>账号</th>
                    <th>密码</th>
                </tr>
                <!--Walk through the list of students here-->
                <c:forEach items="${manager}" var="m">
                    <tr id="tr${m.MId}">
                        <td>${m.MId}</td>
                        <td>${m.MPassword}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>

            <!--            <script>  //Define a function that removes students based on the student's number
                            function deleteStudent(stuId) {
                                $.ajax({
                                    url: 'students/delete',
                                    type: 'POST',
                                    data: {srollno: stuId}, //Send a request argument named stuId, the value of the parameter value is the value of the incoming stuId variable
                                    success: function () {
                                        //If you can perform to success, the background deletion is successful, and the corresponding data row in the table is also deleted here
                                        $("#tr" + stuId).remove(); // Remove is to delete the current element and its contents
                                    },
                                    error: function (req, status, error) {
                                        alert("Ajax request failed, error：" + error);
                                    }
                                });
                            }
                        </script>-->

        </div>
    </body>
</html>
