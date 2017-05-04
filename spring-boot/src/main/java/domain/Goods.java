package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 商品
 * @author 张鹏飞
 * @time 2017年4月28日 上午9:19:52   
 *
 */
@Entity

@XmlRootElement(name="user")
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goodsName;//名称
	private Integer goodsPrice;//价格，分为单位
	private Date goodsDate;//生产日期
	private String goodsIntro;//简介介绍
	private String detailIntro;//详细介绍
	private String avatar;//封面图
	private Integer goodsType;//1为正常，2为热卖，3为即将卖
	@ManyToOne(targetEntity= Preferential.class)
	private Preferential preferential;//优惠活动
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}
	
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	public String getDetailIntro() {
		return detailIntro;
	}
	public void setDetailIntro(String detailIntro) {
		this.detailIntro = detailIntro;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	public Preferential getPreferential() {
		return preferential;
	}
	public void setPreferential(Preferential preferential) {
		this.preferential = preferential;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", goodsDate="
				+ goodsDate + ", goodsIntro=" + goodsIntro + ", detailIntro=" + detailIntro + ", avatar=" + avatar
				+ ", goodsType=" + goodsType + ", preferential=" + preferential + "]";
	}
	
}
