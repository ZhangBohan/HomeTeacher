# 家教，你好
 
##依赖
  
* `Java`版本`1.7`
* `Git`进行版本控制
* `Maven`管理项目中的依赖

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


###后台框架：

   * 控制器：`Spring MVC`
   * 依赖：`Spring`
   * 权限系统：`Spring Security`
   * 数据存储：`Hibernate`

###前端框架：
   * 页面框架：`Admin LTE`
   * 页面动态：`AngularJS`
   
##组件使用
关于本项目内的一些系统级别组件的使用方法

###消息模块

    // 消息支持 success, info, warning, error，类型可以是Model也可以是RedirectAttributes
    MessageHelper.addSuccessAttribute(model, "你好世界");
    MessageHelper.addSuccessAttribute(model, "你好，%s", "伯函"); // 也可以传递参数
   
##要完全的工作

* 后台模块建立
    * 消息模块(√)
    * 分页模块
    * 异常处理模块
* 数据结构确定
