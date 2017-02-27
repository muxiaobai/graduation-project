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
//@ConfigurationProperties(prefix = "spring.dev",locations)  
public class DevProperties {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getDriverClassName() {
            return driverClassName;
        }
        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }
        @Override
        public String toString() {
            return "DatabaseProperties [url=" + url + ", username=" + username + ", password=" + password + ", driverClassName=" + driverClassName
                    + "]";
        }
        
}

