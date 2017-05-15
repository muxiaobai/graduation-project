package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Cart;
/**
 * 
 * dao CartDao.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:47:05
 *
 */
@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
	public List<Cart> findByUser(Cart Cart);
}
