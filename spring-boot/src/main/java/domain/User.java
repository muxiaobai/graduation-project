/**
 * Project Name:spring-boot
 * File Name:User.java
 * Package Name:domain
 * Date:2017年2月28日上午10:21:43
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月28日 上午10:21:43 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Entity  
@Table(name = "user") 
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;  
    private String username;
    private String password;
    private Integer type;//用户类型，0代表默认，1位白银，2为黄金，3为白金
    @ManyToOne(targetEntity = Preferential.class)
    private Preferential preferential;//优惠，不同的type对应不同的优惠活动
    private Integer sex;//1为男，0为女
    private Date birth;
    private Integer age;
    private String addr;//默认此地址为收货地址
    @OneToMany(cascade = { CascadeType.REMOVE }, targetEntity = Demand.class)
    private List<Demand> demands;//我关注的需求
    public User() {
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Preferential getPreferential() {
		return preferential;
	}
	public void setPreferential(Preferential preferential) {
		this.preferential = preferential;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", preferential=" + preferential + ", sex=" + sex + ", birth=" + birth + ", age=" + age + ", addr="
				+ addr + "]";
	}
}

