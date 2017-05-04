package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Goods;

@Service
public interface GoodsService {
	@Transactional
    public Goods getById(Long id);
	@Transactional
    public Page<Goods> FindList(Pageable pageable);
	@Transactional
	public void save(Goods goods);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Goods update(Goods goods);
}
