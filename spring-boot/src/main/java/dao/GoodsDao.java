/**
 * Project Name:spring-boot
 * File Name:UserServiceImpl.java
 * Package Name:impl
 * Date:2017年2月28日上午10:14:47
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Goods;

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
@Repository
public interface GoodsDao  extends JpaRepository<Goods, Long>{
}

