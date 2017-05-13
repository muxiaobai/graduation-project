package service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Preferential;
/**
 * 
 * service PreferentialService.java
 * @author 张鹏飞
 * @time 2017年5月13日 下午4:07:19
 *
 */
@Service
public interface PreferentialService {
	@Transactional
    public Preferential getById(Long id);
	@Transactional
    public Page<Preferential> FindList(Pageable pageable);
	@Transactional
	public void save(Preferential Preferential);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Preferential update(Preferential Preferential);
}
