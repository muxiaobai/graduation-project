package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 商品
 * @author 张鹏飞
 * @time 2017年4月28日 上午9:19:52
 *
 */
@Entity
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goodsName;//名称
	private Integer goodsPrice;//价格，分为单位
	private String goodeIntro;//介绍
	private String avatar;//封面图
	private Integer goodsType;//1为正常，2为热卖，3为即将卖
	private Preferential preferential;//优惠活动
	
}
