package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.PreferentialDao;
import domain.Preferential;
import service.PreferentialService;

/**
 * 
 * service.impl PreferentialServiceImpl.java
 * @author 张鹏飞
 * @time 2017年5月13日 下午4:08:09
 *
 */
@Service
public class PreferentialServiceImpl implements PreferentialService{
	@Autowired
	private PreferentialDao PreferentialDao;
	@Override
	public Preferential getById(Long id) {
		  return PreferentialDao.findOne(id);
	}

	@Override
	public Page<Preferential> FindList(Pageable pageable) {
		return PreferentialDao.findAll(pageable);
	}

	@Override
	public void save(Preferential Preferential) {
		PreferentialDao.save(Preferential);
		
	}

	@Override
	public void delete(Long id) {
		PreferentialDao.delete(id);
		
	}

	@Override
	public Preferential update(Preferential Preferential) {
		return PreferentialDao.save(Preferential);
	}

}
