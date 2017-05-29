package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Order;
import domain.User;
/**
 * OrderDao
 * @author 张鹏飞
 * @time 2017年5月8日 上午9:19:41
 *
 */
public interface OrderDao extends JpaRepository<Order, Long> {
	@Query(" from Order t where t.user =?1 desc")
	public List<Order> findByUser(User User);
}
