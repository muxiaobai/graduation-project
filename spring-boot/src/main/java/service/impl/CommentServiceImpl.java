package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.CommentDao;
import domain.Comment;
import service.CommentService;
import service.CommentService;

/**
 * 
 * service.impl CommentServiceImpl.java
 * @author 张鹏飞
 * @time 2017年5月13日 下午4:08:09
 *
 */
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao CommentDao;
	@Override
	public Comment getById(Long id) {
		  return CommentDao.findOne(id);
	}

	@Override
	public Page<Comment> FindList(Pageable pageable) {
		return CommentDao.findAll(pageable);
	}

	@Override
	public void save(Comment Comment) {
		CommentDao.save(Comment);
		
	}

	@Override
	public void delete(Long id) {
		CommentDao.delete(id);
		
	}

	@Override
	public Comment update(Comment Comment) {
		return CommentDao.save(Comment);
	}

}
