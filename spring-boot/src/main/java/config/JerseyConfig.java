/**
 * Project Name:spring-boot
 * File Name:JerseyConfig.java
 * Package Name:config
 * Date:2017年2月28日上午9:55:49
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;

/**
 * ClassName:JerseyConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午9:55:49 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */ 
@Component
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("rest");
//        register(LoggingFilter.class);
    }
}

