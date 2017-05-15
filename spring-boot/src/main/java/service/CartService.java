package service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.Cart;
/**
 * 
 * service CartService.java
 * @author 张鹏飞
 * @time 2017年5月13日 下午4:07:19
 *
 */
@Service
public interface CartService {
	@Transactional
    public Cart getById(Long id);
	@Transactional
    public Page<Cart> FindList(Pageable pageable);
	@Transactional
	public void save(Cart Cart);
	@Transactional
	public void delete(Long id);
	@Transactional
	public Cart update(Cart Cart);
}
