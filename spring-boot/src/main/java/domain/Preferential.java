package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 优惠活动
 * @author 张鹏飞
 * @time 2017年4月28日 上午9:13:07
 *
 */
@Entity
public class Preferential {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String intro;//优惠活动
	@Column(nullable=false,columnDefinition="INT default 0") 
	private Integer whichType;//判断是折扣还是减少多少，0 没有，1 discount 2 reducePrice
	private Integer discount;//折扣 3代表打三折
	private Integer reducePrice;//卖价3代表减少多少钱，如果应用于用户代表此单减多少，如果应用于商品代表每份减少多少
	public Long getId() {
		return id;
	} 
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getReducePrice() {
		return reducePrice;
	}
	public void setReducePrice(Integer reducePrice) {
		this.reducePrice = reducePrice;
	}
	public Integer getWhichType() {
		return whichType;
	}
	public void setWhichType(Integer whichType) {
		this.whichType = whichType;
	}
	@Override 
	public String toString() {
		return "Preferential [id=" + id + ", intro=" + intro + ", whichType=" + whichType + ", discount=" + discount
				+ ", reducePrice=" + reducePrice + "]";
	}
	
}
