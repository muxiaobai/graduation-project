/**
 * Project Name:gradle
 * File Name:Application.java
 * Package Name:web
 * Date:2017年2月27日上午11:35:34
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package web;
import org.springframework.beans.factory.annotation.Autowired;
import config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
/**
 * ClassName:Application <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

@SpringBootApplication
@EnableConfigurationProperties({RedisProperties.class,DatabaseProperties.class})  
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

