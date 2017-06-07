package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Cart;
import domain.Goods;
import domain.User;
/**
 * 
 * dao CartDao.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:47:05
 *
 */
@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
	@Query(" from Cart t where t.goods = ?1 and t.user =?2 order by t.id desc ")
	public List<Cart> findByGoodsAndUser(Goods Goods,User User);
	@Query(" from Cart t where t.user =?1 order by t.id desc ")
	public List<Cart> findByUser(User User);
	
}
