package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Order;
/**
 * OrderDao
 * @author 张鹏飞
 * @time 2017年5月8日 上午9:19:41
 *
 */
public interface OrderDao extends JpaRepository<Order, Long> {

}
