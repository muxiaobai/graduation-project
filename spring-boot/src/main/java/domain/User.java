/**
 * Project Name:spring-boot
 * File Name:User.java
 * Package Name:domain
 * Date:2017年2月28日上午10:21:43
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package domain;

import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:21:43 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@XmlRootElement(name="user")
public class User {

    public User() {
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
    @PathParam("username")
    private String username;
    @PathParam("password")
    private String password;
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
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
    
}

