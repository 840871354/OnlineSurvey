# OnlineSurvey
2020实训作业

需要修改的地方：

1.右键点击 "Apache Tomcat" 并打开 "Edit server.xml",

在 < / host > 内添加以下内容

例:  
<Context防消失 path="/UserImage" docBase="C:\Users\MIKUO\Documents\NetBeansProjects\OnlineSurvey\UserImage"></Context防消失>

（dobase的路径需要更改为你计算机上此项目中的userimage文件夹的路径）

2.打开此项目的 Source Package,打开 com.survey.dao.impl package,打开 CorporateUserDaoImpl.java,找到getPhoto方法，

修改String path = "C:\\Users\\MIKUO\\Documents\\NetBeansProjects\\OnlineSurvey\\UserImage\\";

(dobase的路径需要更改为您计算机上这个项目的userimage文件夹的路径，注意斜线)

3.以同样方法修改 OrdinaryUserDaoImpl.java



默认管理员账号：

账号:A01    密码：123
