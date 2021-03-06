/**
 * Project Name:spring-boot
 * File Name:UserServiceImpl.java
 * Package Name:service.impl
 * Date:2017年2月28日上午10:17:04
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.UserDao;
import domain.Demand;
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
    public User getById(Long id) {
         return userDao.findOne(id);
    }
	@Override
	public void saveList(List users) {
		Iterable<User> iterable =(Iterable<User>) ((ArrayList<User>)users).iterator();
		userDao.save(iterable);
	}
	@Override
	public Page<User> FindList(Pageable pageable) {
		return userDao.findAll(pageable);
		
	}
	@Override
	public void save(User user) {
		userDao.save(user);
		
	}
	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}
	@Override
	public User update(User user) {
		return userDao.save(user);
	}
	@Override
	public Long login(User user) {
		User user2 =userDao.findByUsername(user.getUsername());
		if(user2!=null&&user2.getPassword().equals(user.getPassword())){
			return user2.getId();
		}else{
			return 0L;
		}
	}
	@Override
	public User isSign(String username) {
		return userDao.findByUsername( username);
	}
	@Override
	public User updateDemands(User user, List<Demand> demand) {
		User user2 =userDao.findOne(user.getId());
		List<Demand>  demands = user2.getDemands();
		demands.addAll(demand);
		user2.setDemands(demands);
		System.out.println(demands);
		userDao.save(user2);
		return userDao.findOne(user.getId());
	}

}

