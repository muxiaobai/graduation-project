package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Comment;
import domain.Goods;
import domain.Order;
/**
 * 
 * dao CommentDao.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:47:31
 *
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
	@Query(" from Comment  t where t.goods = ?1")
	public List<Comment> findByGoods(Goods Goods);
	@Query(" from Comment t where t.order = ?1")
	public List<Comment> findByOrder(Order Order);
}
