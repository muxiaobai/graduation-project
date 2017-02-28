/**
 * Project Name:spring-boot
 * File Name:UserServiceImpl.java
 * Package Name:impl
 * Date:2017年2月28日上午10:14:47
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package dao.impl;

import org.springframework.stereotype.Service;

import dao.UserDao;
import domain.User;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:14:47 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(Integer id) {
        return new User("zhang","password");
    }

}

