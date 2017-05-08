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
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import domain.User;

/**
 * UserDao
 * @author 张鹏飞
 * @time 2017年5月8日 上午9:19:54
 *
 */
@Repository
public interface UserDao  extends JpaRepository<User, Long>{
    public User getUserById(Long id);
}

