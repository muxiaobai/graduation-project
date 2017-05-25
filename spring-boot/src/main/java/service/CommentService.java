package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Comment;
/**
 * 
 * service CommentService.java
 * @author 张鹏飞
 * @time 2017年5月13日 下午4:07:19
 *
 */
@Service
public interface CommentService {
	@Transactional
    public Comment getById(Long id);
	@Transactional
    public Page<Comment> FindList(Pageable pageable);
	@Transactional
	public List<Comment> findByGoods(Comment Comment);
	@Transactional
	public void save(Comment Comment);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Comment update(Comment Comment);

}
