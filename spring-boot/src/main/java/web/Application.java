/**
 * Project Name:gradle
 * File Name:Application.java
 * Package Name:web
 * Date:2017年2月27日上午11:35:34
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package web;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import config.DatabaseProperties;
import config.JerseyConfig;
import config.RedisProperties;
/**
 * ClassName:Application <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@ComponentScan(basePackages = { "dao","service","domain","config"})
@EnableJpaRepositories("dao") // JPA扫描该包路径下的Repositorie
@EntityScan(basePackages = { "java.lang.Object","domain"}) // 扫描实体类
@EnableAutoConfiguration  
@SpringBootApplication
@EnableConfigurationProperties({RedisProperties.class,DatabaseProperties.class})  
public class Application {
    //注册jersey
    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }
    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class)
//        .showBanner(false)
//        .run(args);
        SpringApplication.run(Application.class, args);
    }
}

