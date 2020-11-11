<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>调查清单页面</title>
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
                    <th>问题编号</th>
                    <th>用户回应</th>
                    <th>用户姓名</th>
                </tr>
                <c:forEach items ="${ordinaryUserResult}" var="our" varStatus="ouri">
                    <tr id="tr${our.id.SId}">
                        <td>${our.id.SId}</td>
                        <td>${our.id.QId}</td>
                        <td>${our.answer}</td>
                        <td>${our.id.ouName}</td>
                    </tr>
                </c:forEach>
            </table>
<!--            <script>  //Define a function that removes students based on the student's number
                function deleteSurvey(SId) {
                    $.ajax({
                        url: 'corporateUser/deleteSurvey',
                        type: 'POST',
                        data: {sid: SId}, //Send a request argument named stuId, the value of the parameter value is the value of the incoming stuId variable
                        success: function () {
                            //If you can perform to success, the background deletion is successful, and the corresponding data row in the table is also deleted here
                            $("#tr" + SId).remove(); // Remove is to delete the current element and its contents
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
