/**
 * Project Name:spring-boot
 * File Name:UserService.java
 * Package Name:service
 * Date:2017年2月28日上午10:14:18
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Demand;
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
@Service
public interface UserService {
	@Transactional
    public User getById(Long id);
	@Transactional
    public void saveList(List users);
	@Transactional
    public Page<User> FindList(Pageable pageable);
	@Transactional
	public void save(User user);
	@Transactional
	public Long login(User user);
	
	@Transactional
	public void delete(Long id);
	@Transactional
	public User update(User user);
	/**
	 * 增加我的需求关注
	 * @param user
	 * @param demand 关注的需求
	 * @return
	 */
	@Transactional
	public User updateDemands(User user,List<Demand> demand);
	@Transactional
	public User isSign(String username);
}

