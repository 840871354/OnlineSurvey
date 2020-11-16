<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
    <head> 
        <meta charset="utf-8" /> 
        <title>添加问题页面</title> 
                <base href="${pageContext.request.contextPath}/">
        <style type="text/css">
            .question{
                position:absolute;

                text-align:left;

            }
        </style>
			
    </head> 
    <body> 
        <form action="corporateUser/addTextQuestion">
            <div class="question"> 
                <label>问题内容:</label>&nbsp;<input type="text" name="QContent"><br/><br/>

                <button type="submit" value="Submit">提交</button>         
            </div> 
        </form>
    </body> 
</html> 