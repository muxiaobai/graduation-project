/**
 * Project Name:spring-boot
 * File Name:UserService.java
 * Package Name:service
 * Date:2017年2月28日上午10:14:18
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package service;

import org.springframework.stereotype.Service;

import domain.User;

/**
 * ClassName:UserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:14:18 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface UserService {
    public User getUserById(Integer id);
}

