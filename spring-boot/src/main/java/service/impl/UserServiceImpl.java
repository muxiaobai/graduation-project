/**
 * Project Name:spring-boot
 * File Name:UserServiceImpl.java
 * Package Name:service.impl
 * Date:2017年2月28日上午10:17:04
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import domain.User;
import service.UserService;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:17:04 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;  
    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

}

