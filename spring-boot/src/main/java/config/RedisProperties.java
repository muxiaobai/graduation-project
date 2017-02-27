/**
 * Project Name:spring-boot
 * File Name:ApplicationProperties.java
 * Package Name:config
 * Date:2017年2月27日下午5:12:27
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName:ApplicationProperties <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月27日 下午5:12:27 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@ConfigurationProperties(prefix = "spring.redis")  
public class RedisProperties {

private String database;
private String  host;
private String post;
private String password;
public String getDatabase() {
    return database;
}
public void setDatabase(String database) {
    this.database = database;
}
public String getHost() {
    return host;
}
public void setHost(String host) {
    this.host = host;
}
public String getPost() {
    return post;
}
public void setPost(String post) {
    this.post = post;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
@Override
public String toString() {
    return "RedisProperties [database=" + database + ", host=" + host + ", post=" + post + ", password=" + password + "]";
}

}

