/**
 * Project Name:gradle
 * File Name:Hello.java
 * Package Name:web
 * Date:2017年2月27日上午11:38:20
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import config.RedisProperties;
/**
 * ClassName:Hello <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
//@spring-boot-devtools
@RestController
public class Hello {
    @Autowired
    private  Environment env;
    @Autowired  
    private RedisProperties redisProperties;  
    
    @RequestMapping("/")
    public String hello() {
        System.out.println(redisProperties.getHost());
        System.out.println(env.getProperty("applicationConfig"));
        return "hello wolas村ld";
    }
}

