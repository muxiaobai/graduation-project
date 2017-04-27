环境在java 1.8,window 7,tomcat 8 中测试.

安装gradle 添加环境变量PATH

下载本项目后，切入到spring-boot目录后，可以直接在命令行输入命令

```
gradle bootRun
```
启动成功后,在浏览器中打开： http://127.0.0.1:8080/rest/users/1 可以看到

或者编译打包后再运行

```
gradle build && java -jar ./build/libs/spring-boot-0.0.1-SNAPSHOT.jar 

```


debug运行

```
gradle bootRun --debug-jvm

```