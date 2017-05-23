package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Comment;
/**
 * 
 * dao CommentDao.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:47:31
 *
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
	//public List<Comment> findByGoods();
	//public Comment findByOrder();
}
