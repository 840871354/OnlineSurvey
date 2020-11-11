<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>调查列表页面</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div>
            <h1 class ="text">问题列表</h1>

            <br/>
            <table class="table" border="1">
                <tr>
                    <td>
                        <a href="corporateUser/Select_topic_type">添加新问题</a>
                    </td>
                </tr>
                <tr>
                    <th>问题编号</th>
                    <th>内容描述</th>
                    <th>A</th>
                    <th>B</th>
                    <th>C</th>
                    <th>D</th>
                    <th>E</th>
                    <th>F</th>
                    <th>操作</th>
                </tr>
                <c:forEach items ="${QuestionList}" var="q" varStatus="qi">
                    <tr id="tr${q.id.QId}">
                        <td>${q.id.QId}</td>
                        <td>${q.QContent}</td>
                        <td>${q.aoption}</td>
                        <td>${q.boption}</td>
                        <td>${q.coption}</td>
                        <td>${q.doption}</td>
                        <td>${q.eoption}</td>
                        <td>${q.foption}</td>
                        <td><a href="javascript:deleteQuestion('${q.id.QId}')">删除</a></td>                   
                    </tr>
                </c:forEach>
            </table>
            <script>  //Define a function that removes students based on the student's number
                function deleteQuestion(QId) {
                    $.ajax({
                        url: 'corporateUser/deleteQuestion',
                        type: 'POST',
                        data: {qid: QId}, //Send a request argument named stuId, the value of the parameter value is the value of the incoming stuId variable
                        success: function () {
                            //If you can perform to success, the background deletion is successful, and the corresponding data row in the table is also deleted here
                            $("#tr" + QId).remove(); // Remove is to delete the current element and its contents
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
