package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * 
 * domain Cart.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:33:56
 *
 */
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(targetEntity =User.class)
	private User user;
	private Integer number;
	@OneToOne(targetEntity = Goods.class) 
	private Goods goods;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", number=" + number + ", goods=" + goods + "]";
	}
	
}
