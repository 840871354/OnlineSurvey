<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta charset="UTF-8">
        <title>页面</title>
        <style>
            .menus {
                width: 300px;
                overflow: hidden;
                background: #CFCFCF;

            }
            .menu_title {
                width: 300px;
                height: 50px;
                line-height: 50px;
                background: #CFCFCF;
                color: #000;
                font-size: 15px;
                padding-left: 15px;
                cursor: pointer;
                position: relative;
                font-weight: bold;
                overflow: hidden;
            }

            .menu_title:hover {
                background:#666;
            }
            .menu_title a {
                width: 290px;
                height: 40px;
                display: block;
                text-decoration: none;
                color: #000;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="menus">
            <div class="menu_title" onClick="openMenu(this)"> <a href="ordinaryUser/Recommend" target="Content Section">推荐调查</a>
            </div>

            <div class="menu_title" onClick="openMenu(this)"><a href="ordinaryUser/CompletedQuestionnaire" target="Content Section"> 已完成问卷 </a>
            </div>
        </div>
    </body>
</html>
