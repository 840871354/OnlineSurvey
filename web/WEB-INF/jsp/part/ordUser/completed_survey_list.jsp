<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>调查表界面</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div>
            <h1 class ="text">完成调查清单</h1>

            <br/>
            <table class="table" border="1">
                <tr>
                    <th>调查编码</th>
                    <th>调查姓名</th>
                    <th>关键词</th>
                    <th>发布日期</th>
                    <th>操作</th>
                </tr>
                <c:forEach items ="${SurveyList}" var="s" varStatus="si">
                    <tr id="tr${s.SId}">
                        <td>${s.SId}</td>
                        <td>${s.SName}</td>
                        <td>${s.SKeyWord}</td>


                        <td>${s.SDateOfRelease}</td>  
                        <td><a href="javascript:deleteAnswer('${s.SId}');">删除</a></td>                       
                    </tr>
                </c:forEach>
            </table>
            <script>  //Define a function that removes students based on the student's number
                function deleteAnswer(SId) {
                    $.ajax({
                        url: 'ordinaryUser/deleteAnswer',
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
            </script>
        </div>
    </body>
</html>
