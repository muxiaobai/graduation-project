package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 热门需求信息
 * domain Demand.java
 * @author 张鹏飞
 * @time 2017年6月7日 下午3:05:36
 *
 */
@Entity

@XmlRootElement(name="user")
public class Demand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type; //需求产品的类型
	private String name;//需求人
	private String tel;//需求人联系方式
	private Date deadline;//截止时间
	private String addr;//需求地址
	private String num;//需求数量
	private String price;//需求数量
	private String detail;//需求的一些必备条件要求
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Demand [id=" + id + ", type=" + type + ", name=" + name + ", tel=" + tel + ", deadline=" + deadline
				+ ", addr=" + addr + ", num=" + num + ", price=" + price + ", detail=" + detail + "]";
	}
	
	
}
