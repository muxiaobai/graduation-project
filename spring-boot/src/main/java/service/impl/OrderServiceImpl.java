/**
 * Project Name:spring-boot
 * File Name:OrderServiceImpl.java
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

import dao.GoodsDao;
import dao.OrderDao;
import domain.Goods;
import domain.Order;
import service.OrderService;

/**
 * ClassName:OrderServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:17:04 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;  
    @Autowired
    private GoodsDao goodsDao;  
    @Override
    public Order getById(Long id) {
         return orderDao.findOne(id);
    }
	@Override
	public void saveList(List Orders) {
		Iterable<Order> iterable =(Iterable<Order>) ((ArrayList<Order>)Orders).iterator();
		orderDao.save(iterable);
	}
	@Override
	public Page<Order> FindList(Pageable pageable) {
		return orderDao.findAll(pageable);
		
	}
	@Override
	public void save(Order Order) {
		Goods goods = goodsDao.findOne(Order.getGoods().getId());
		goods.setGoodsStock(goods.getGoodsStock()-1);
		goodsDao.save(goods);
		orderDao.save(Order);
		
	}
	@Override
	public void delete(Long id) {
		orderDao.delete(id);
	}
	@Override
	public Order update(Order Order) {
		return orderDao.save(Order);
	}
	@Override
	public List<Order> FindMyList(Pageable pageable, Order order) {
		return orderDao.findByUser(order.getUser());
	}

}

