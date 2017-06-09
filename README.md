# graduation-project
毕业设计，计划一共三部分，一部分用jersey  RESTFul提供数据，采用Spring Boot框架，前台用户界面用vue开发，后台管理系统使用easyUI框架。

 git pull origin spring-boot

 git push origin master:spring-boot
 
 git pull origin vue

 git push origin master:vue
 
 因为分为两个项目，需要分别提交，功能完成后，再合并到主分支。
 
 运行步骤，安装gradle3.4，java1.8 node4.6, nginx 
 切入spring-boot 编译后端项目后，通过java -jar运行编译的jar包，参考[spring-boot README](https://github.com/muxiaobai/graduation-project/blob/master/spring-boot/README.md)
 切入到vue编译前端页面，之后把编译后的页面，放到nginx中，启动nginx，访问即可。参考[VUE README](https://github.com/muxiaobai/graduation-project/blob/master/vue/README.md)
