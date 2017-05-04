package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.GoodsDao;
import domain.Goods;
import service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{
	 @Autowired
	 private GoodsDao goodsDao; 
	@Override
	public Goods getById(Long id) {
		return goodsDao.findOne(id);
	}
	@Override
	public Page<Goods> FindList(Pageable pageable) {
		return goodsDao.findAll(pageable);
	}

	@Override
	public void save(Goods goods) {
		goodsDao.save(goods);
		
	}

	@Override
	public void delete(Long id) {
		goodsDao.delete(id);
		
	}

	@Override
	public Goods update(Goods goods) {
		return goodsDao.save(goods);
	}

}
