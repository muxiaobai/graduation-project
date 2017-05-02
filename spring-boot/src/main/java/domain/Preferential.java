package domain;

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
	private String intro;
	private Integer discount;//折扣
	private Boolean showdiscount;
	private Integer realPrice;//卖价
	private Boolean showPrice;
}
