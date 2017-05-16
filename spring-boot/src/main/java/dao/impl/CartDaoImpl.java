package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Cart;

/**
 * 
 * dao.impl CartDaoImpl.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午4:38:40
 *
 */
@Repository
public class CartDaoImpl {
	@Autowired
	public EntityManager em;
	public List<Cart> findByUser(Cart Cart){
//		CartDao
		return null;
		
	} 
	public List<Cart> findByGoodsAndUser(Cart Cart){
		
		List<Cart> carts =(List<domain.Cart>) em.createQuery("  from Cart  cart where cart.user.id =  "
				+ Cart.getUser().getId()
				+ " and cart.goods.id = "+ Cart.getGoods().getId());
		System.out.println("================="+carts);
		return null;
	}
}
