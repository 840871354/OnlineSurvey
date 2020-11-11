<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.request.contextPath}/">
        <meta charset="UTF-8">
        <title>标题</title>
        <script type="text/javascript">
            var itemHeight = 40;
            var dividerHeight = 1;

            function openMenu(obj) {
                menuTitleId = obj.id;
                menuId = "menu" + menuTitleId.substring(10);
                indicatorId = "indicator" + menuTitleId.substring(10);

                menu = document.getElementById(menuId);
                indicator = document.getElementById(indicatorId);
                height = menu.style.height;

                if (height == "0px" || height == "") {
                    childAmount = menu.getElementsByTagName('div').length;
                    dividerAmount = menu.getElementsByTagName('li').length;
                    height = childAmount * itemHeight + dividerAmount * dividerHeight;
                    menu.style.height = height + "px";
                    indicator.style.transform = "rotate(180deg)";
                } else {
                    menu.style.height = "0px";
                    indicator.style.transform = "rotate(0deg)";
                }
            }
        </script>
        <style>
            .menus {
                width: 300px;
                overflow: hidden;
                background: #CFCFCF;

            }
            .menu {
                overflow: hidden;
                height: 0px;
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
            .indicator {
                font-weight: bold;
                position: absolute;
                right: 30px;
                top: 1px;
            }
            .item {
                width: 290px;
                height: 40px;
                line-height: 40px;
                background: gray;
                color: white;
                padding-left: 15px;
                cursor: pointer;
                overflow: hidden;
            }
            .item:hover {
                background: #B22222;
            }
            .item a {
                width: 290px;
                height: 40px;
                display: block;
                text-decoration: none;
                color: white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="menus">
            <div id="menu_title1" class="menu_title" onClick="openMenu(this)"> 创建管理用户
                <div class="indicator" id="indicator1">^</div>
            </div>
            <div class="menu" id="menu1">
                <div class="item"> <a href="adminUser/managerList" target="Content Section">创建新管理账户</a> </div>
            </div>

            <div id="menu_title2" class="menu_title" onClick="openMenu(this)"> 管理普通用户信息
                <div class="indicator" id="indicator2">^</div>
            </div>
            <div class="menu" id="menu2">
                <div class="item"> <a href="adminUser/ordinaryUserList" target="Content Section">查看普通用户信息</a> </div>
            </div>

            <div id="menu_title3" class="menu_title" onClick="openMenu(this)"> 管理公司用户信息
                <div class="indicator" id="indicator2">^</div>
            </div>
            <div class="menu" id="menu3">
                <div class="item"> <a href="adminUser/companyUserList" target="Content Section">查看公司用户信息</a> </div>
            </div>

            <div id="menu_title4" class="menu_title" onClick="openMenu(this)"> 管理调查表
                <div class="indicator" id="indicator3">^</div>
            </div>
            <div class="menu" id="menu4">
                <div class="item"> <a href="adminUser/unpublished" target="Content Section">查看未发布的调查问卷</a> </div>
                <div class="item"> <a href="adminUser/published" target="Content Section">查看发布的问卷</a> </div>
            </div>

        </div>
    </body>
</html>