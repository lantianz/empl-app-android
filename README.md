# empl-app-android

## 项目介绍

这是项目中的移动App端，使用Java开发。该项目是针对某高校的就业管理系统，采用前后端分离的方式，前端使用Vue2框架，后端使用SpringBoot框架。

前端页面采用ElementUI组件库，后端使用MyBatis-Plus框架，数据库采用MySQL。

## **1.1** 毕业生的App端功能

毕业生在移动端成功安装App后，若为首次登录，则输入院系负责人分配的初始账号和密码即可登录，初始账号为学号（不可更改），初始密码为111111，如下图1所示。

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps1.png) 

图 1 App登录页面

点击登录按钮后向后端发送登录请求，后端进行身份核验，成功后将token存入Redis并同时返回给App，App将token存储在本地自定义的sp_config.xml中，方便下次进入App时判断是否直接进入主页。如下图2所示。

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps2.jpg) 

图 2 App登录成功后将token存储本地并跳转首页

 

登录成功后在首页可以进行就业相关资讯的阅览，点击搜索栏进行模糊查找资讯，点击相应资讯进入详情阅览，详情采用HTML页面实现，如下图3所示；相关首页资讯显示代码如下图4、5所示。

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps3.png) 

图 3 App首页就业资讯总览、搜索、详情

 

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps4.jpg) 

图 4 首页资讯列表实现部分相关代码

 

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps5.jpg) 

图 5 获取详情数据并加载到HTML显示

 

在“上报”页面可以上报自己的就业信息，如下图6所示。上报信息需经所在院系就业工作负责人审核后，方能正式加入毕业生就业信息数据表。

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps6.png) 

图 6 App“上报”页面提交就业信息、查看审核结果


在“我的”页面可以查看毕业生的基本信息以及退出登录操作，如下图7所示。

![img](https://github.com/lantianz/empl-app-android/raw/main/introduce-img/wps7.png) 

图 7 “我的”页面以及退出登录
