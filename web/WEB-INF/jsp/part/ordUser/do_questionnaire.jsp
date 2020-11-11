<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>试题页面</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div>
            <form action="ordinaryUser/submitAnswer">
                <h1 class ="text">选择题</h1>
                <table class="table" border="1">
                    <tr>     
                        <th>题号</th>
                        <th>题干</th>
                        <th>A</th>
                        <th>B</th>
                        <th>C</th>
                        <th>D</th>
                        <th>E</th>
                        <th>F</th>
                        <th>选项</th>
                    </tr>
                    <c:forEach items ="${questionsList}" var="q" varStatus="qs">
                        <tr>
                            <td><input type="hidden" name="QId" value="${q.id.QId}"/>${q.id.QId}</td>
                            <td>${q.QContent}</td>
                            <td>${q.aoption}</td>
                            <td>${q.boption}</td>
                            <td>${q.coption}</td>
                            <td>${q.doption}</td>
                            <td>${q.eoption}</td>
                            <td>${q.foption}</td>
                            <td>
                                <select name='option'>
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                    <option value="C">C</option>
                                    <option value="D">D</option>
                                    <option value="D">E</option>
                                    <option value="D">F</option>
                                </select>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <table>
                    <h1 class ="text">简答题</h1>
                    <c:forEach items ="${textQuestion}" var="t" varStatus="ts">      
                        <tr><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${t.id.QId}.${t.QContent}<input type="hidden"name="TId" value="${t.id.QId}"/></h3></tr>
                        <br/><br/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <textarea style="width:800px;height:200px;" id="textAnswer" name="textAnswer"></textarea>
                    </c:forEach>
                </table><br/> 
                <input type="submit" value="提交"/>
                <br/> <br/> <br/><br/> <br/> <br/>
            </form>
        </div>
    </body>
</html>
