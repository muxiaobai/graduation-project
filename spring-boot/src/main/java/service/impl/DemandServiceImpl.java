package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dao.DemandDao;
import domain.Demand;
import service.DemandService;
@Service
public class DemandServiceImpl implements DemandService{
	 @Autowired
	 private DemandDao DemandDao; 
	@Override
	public Demand getById(Long id) {
		return DemandDao.findOne(id);
	}
	@Override
	public Page<Demand> FindList(Pageable pageable) {
		return DemandDao.findAll(pageable);
	}

	@Override
	public void save(Demand Demand) {
		DemandDao.save(Demand);
		
	}

	@Override
	public void delete(Long id) {
		DemandDao.delete(id);
		
	}

	@Override
	public Demand update(Demand Demand) {
		return DemandDao.save(Demand);
	}

}
