<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
    <head> 
        <meta charset="utf-8" /> 
        <title>添加问卷页面</title> 
                <base href="${pageContext.request.contextPath}/">
        <style type="text/css">
            .question{
                position:absolute;

                text-align:left;

            }
        </style>		
    </head> 
    <body> 
        <form action="corporateUser/addMultipleChoice">
            <div class="question"> 
                <label>问题内容:</label>&nbsp;<input type="text" name="QContent"><br/><br/>

                <label>A 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="aoption"><br/><br/>
                <label>B 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="boption"><br/><br/>
                <div id="option3">
                    <label>C 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="coption"></div><br/>
                <div id="option4" >
                    <label>D 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="doption"></div><br/>
                <div id="option5" >
                    <label>E 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="eoption"></div><br/>
                <div id="option6">
                    <label>F 选项:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" name="foption"></div><br/>

                <br/><br/>
                <button type="submit" value="Submit">提交</button>         
            </div> 
        </form>
    </body> 
</html> 