<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head> 
<meta charset="utf-8" /> 
<title>页面</title> 
<base href="${pageContext.request.contextPath}/">
<style> 
body{ text-align:center} 

</style> 
</head> 
<style>
    button{
        width: 300px;
        height: 100px;
    }
</style>
<body> 
<div class="div"> 
    <br/><br/><br/><br/><br/><br/>
<a href="corporateUser/to_addMultipleChoice"><button type="button">多选</button></a>
<br/><br/>
<a href="corporateUser/to_addTextQuestion"><button type="button">简答</button></a>
</div> 
</body> 
</html> 