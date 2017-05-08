package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Goods goods;
	private Integer money;
	private String addr;
	private User user;
}
