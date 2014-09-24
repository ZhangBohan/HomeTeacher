# 家教，你好
 
##依赖
  
* `Java`版本`1.7`
* `Git`进行版本控制
* `Maven`管理项目中的依赖
* `Redis`

##安装开发环境
###UBuntu
    sudo apt-get install python-software-properties
    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update
    
    sudo apt-get install oracle-java7-installer

    sudo apt-get install git
    
    sudo apt-get install maven

    sudo apt-get install redis-server


##如何开始
    
    git clone https://github.com/ZhangBohan/jiajiaohello.git
    cd jiajiaohello
    mvn jetty:run
    curl http://localhost:8000

##涉及技术

 * 语言：`Java`, `HTML`, `JavaScript`, `CSS`, `SQL`
 * 版本管理：`Git`
 * 数据库：`MySQL`
 * 缓存 & `NoSQL`：`Redis`


##数据结构图
![image](http://static-jjh.oss-cn-beijing.aliyuncs.com/diagram.jpg)

###后台框架：

   * 控制器：`Spring MVC`
   * 依赖：`Spring`
   * 权限系统：`Spring Security`
   * 数据存储：`Hibernate`
   * [http-request](http://kevinsawicki.github.io/http-request/): A simple convenience library for using a HttpURLConnection to make requests and access the response.

###前端框架：
   * [Admin LTE](https://github.com/almasaeed2010/AdminLTE): Free Premium Admin control Panel Theme That Is Based On Bootstrap 3.x
   * [AngularJS](https://github.com/angular/angular.js): HTML enhanced for web apps!
   
##配置文件

配置文件当前使用启动后自动加载`jiajiaohello/src/main/resources/server.properties`文件，如果需要自定义
配置文件中的某项，可以使用传递系统参数的办法，例如：`mvn jetty:run -DdataSource.password=123456`
   
##组件使用
关于本项目内的一些系统级别组件的使用方法

###操作消息模块

**设置方法**

    // 消息支持 success, info, warning, error，类型可以是Model也可以是RedirectAttributes
    MessageHelper.addSuccessAttribute(model, "你好世界");
    MessageHelper.addSuccessAttribute(model, "%s，%s", "你好", "伯函"); // 也可以传递参数
    
**取得方法**

    <h2 class="${message.type}">${message.message}</h2>
   
##要完全的工作

###框架工作

* `Spring Security`支持(√)
* `AdminLTE`支持(√)
* 后台模块建立
    * 操作消息模块(√)
    * 分页模块(√)
    * 异常处理模块(√)
    * `Hibernate Validator`验证用户输入(√)
* 账户系统(√)
* 用户消息系统，应该包含发送未读信息、发短信、微信公共账号等，应该与系统解耦合
* 支付集成(√)

###实际需求
* 地区支持，用户属于某个地区
* 用户需求页
* 教员资料页
* 课程跟踪页
* 用户评论系统，可评价已结束的课程
* 搜索系统
