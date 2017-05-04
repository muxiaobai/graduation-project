/**
 * Project Name:spring-boot
 * File Name:User.java
 * Package Name:domain
 * Date:2017年2月28日上午10:21:43
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity  
@Table(name = "user") 
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;  
    private String username;
    private String password;
    public User() {
    }
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
  
    
}

