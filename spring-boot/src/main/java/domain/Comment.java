package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * domain Comment.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:33:51
 *
 */
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	@OneToOne(targetEntity = Order.class)
	private Order order;
	@ManyToOne(targetEntity = Goods.class)
	private Goods goods;
	private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", order=" + order + ", goods=" + goods + ", content=" + content + "]";
	}
	
	
}
