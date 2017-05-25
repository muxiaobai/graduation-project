/**
 * Project Name:spring-boot
 * File Name:CartRest.java
 * Package Name:rest
 * Date:2017年2月28日上午10:13:51
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import domain.Cart;
import domain.User;
import service.CartService;
/**
 * 
 * rest CartRest.java
 * @author 张鹏飞
 * @time 2017年5月15日 下午3:51:42
 *
 */
@Path("/carts")  
@Component 
public class CartRest {

    @Autowired  
    private CartService CartService;  
    private Map<String, Object> returnValue= new HashMap<String, Object>();
    @POST
    @Path("add")
    @Consumes("application/json;charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> post(@RequestBody Cart Cart){
        returnValue.clear();
        CartService.save(Cart);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "add ");
        returnValue.put("data", Cart);
        return returnValue;
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> delete(@PathParam("id") Long id) {
        returnValue.clear();
        CartService.delete(id);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "delete ");
        return  returnValue;
    }
    /**
     * 修改
     * @param id id
     * @param Cart 修改的实例bean
     * @return
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> put(@PathParam("id")Long id, @RequestBody Cart Cart) {
        returnValue.clear();
        Cart.setId(id);
        CartService.update(Cart);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "put update");
        return returnValue;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> get(@PathParam("id") Long id) {
       returnValue.clear();
       returnValue.put("code", 200);
       returnValue.put("msg", "success");
       returnValue.put("action", "getById");
       returnValue.put("data", CartService.getById(id));
       return returnValue;
    }
    @POST
    @Path("")
    @Consumes("application/json;charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> get(@RequestBody Cart Cart) {
       returnValue.clear();
       returnValue.put("code", 200);
       returnValue.put("msg", "success");
       returnValue.put("action", "getByGoodsAndUserId");
       returnValue.put("data", CartService.findByGoodsAndUser(Cart));
       return returnValue;
    }
    //http://127.0.0.1:8080/rest/Carts/list?page=0&size=20
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getList(@DefaultValue("0")@QueryParam("page") Integer page, @DefaultValue("20")@QueryParam("size") Integer size) {
        returnValue.clear();
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "getpageList");
        returnValue.put("data",CartService.FindList(pageable));
        return returnValue;
    }
    /**
     * 获取我的购物车
     * @param page
     * @param size
     * @return
     */
    @GET
    @Path("mylist/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getMyList(@PathParam("id") Long id) {
        returnValue.clear();
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 20, sort);
        User user =new User();
        user.setId(id);
        Cart Cart =new Cart();
        Cart.setUser(user);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "getpageList");
        returnValue.put("data",CartService.FindMyList(pageable, Cart));
        return returnValue;
    }
    @GET
    @Path("/page/{pagesize}/{currentpage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getPage(@DefaultValue("20") @PathParam("pagesize") Integer pagesize, @DefaultValue("1") @PathParam("currentpage") Integer currentpage) {
        returnValue.clear();
        List<Cart> Carts = new ArrayList<Cart>();
        returnValue.put("Carts",Carts);
        return returnValue;
    }
    
}

