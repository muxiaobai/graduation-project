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

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Order;

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
public interface OrderService {
	@Transactional
    public Order getById(Long id);
	@Transactional
    public void saveList(List<?> orders);
	@Transactional
    public Page<Order> FindList(Pageable pageable);
	@Transactional
	public void save(Order order);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Order update(Order order);
	@Transactional
	public List<Order> FindMyList(Pageable pageable,Order order);
	
}

