# 家教，你好

##脑图

[项目结构脑图](http://naotu.baidu.com/viewshare.html?shareId=ar4togreg4k4)
 
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
![image](http://static-jjh.oss-cn-beijing.aliyuncs.com/diagram.jpg?v=2)

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

###如何访问数据库
如果只是基本的`CRUD`请直接使用`com.jiajiaohello.support.core.CommonDao`，谨记`DRY`原则，如果是共用的可以直接扩充该类

使用方法：

    public class CommonDaoTest extends BaseTest {
        @Autowired
        private CommonDao<Course> courseCommonDao;

        @Test
        public void testGet() throws Exception {
            Course course = courseCommonDao.get(-1, Course.class);
            assertNull(course);
        }

        @Test
        public void testSaveOrUpdate() throws Exception {
            Course course = new Course();
            course.init();
            course.setName("aaa");
            course.setDescription("www");
            courseCommonDao.saveOrUpdate(course);
        }

        @Test
        public void testGetList() throws Exception {
            List<Course> list = courseCommonDao.getList(new Course());
            System.out.println(list);
            assertNotNull(list);
        }
    }