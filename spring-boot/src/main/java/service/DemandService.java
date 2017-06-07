package service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Demand;

@Service
public interface DemandService {
	@Transactional
    public Demand getById(Long id);
	@Transactional
    public Page<Demand> FindList(Pageable pageable);
	@Transactional
	public void save(Demand Demand);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Demand update(Demand Demand);
}
