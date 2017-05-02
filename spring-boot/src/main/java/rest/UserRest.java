/**
 * Project Name:spring-boot
 * File Name:UserRest.java
 * Package Name:rest
 * Date:2017年2月28日上午10:13:51
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import domain.User;
import service.UserService;

@Path("/users")  
@Component 
public class UserRest {

    @Autowired  
    private UserService userService;  
    private static Map<Integer,User> users = Collections.synchronizedMap(new HashMap<Integer,User>());
    private Map<String, Object> returnValue= new HashMap<String, Object>();
   /**
    * 添加 用户
    * @param user
    * @return
    */
    @POST
    @Path("/addUser")
    @Consumes("application/x-www-form-urlencoded")
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces({"application/xml", "application/json"})
    public Map<String, Object> postUser(@BeanParam User user){
        returnValue.clear();
        System.out.println(user);
        userService.saveUser(user);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "add user");
        returnValue.put("data", user);
        return returnValue;
    }
    /**
     * 删除
     * @param id 根据id删除此用户
     * @return
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> deleteUser(@PathParam("id") Long id) {
        returnValue.clear();
        userService.deleteUser(id);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "delete user");
        return  returnValue;
    }
    /**
     * 修改
     * @param id id
     * @param user 修改的实例bean
     * @return
     */
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String putUser(@PathParam("id")Long id, @BeanParam User user) {
        returnValue.clear();
        user.setId(id);
        userService.updateUser(user);
        return "put update";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUser(@PathParam("id") Long id) {
        returnValue.clear();
        System.out.println("get:"+id);
       User user= userService.getUserById(id);
       returnValue.put("code", 200);
       returnValue.put("user", user);
        return returnValue;
    }
    //http://127.0.0.1:8080/rest/users/list?page=0&size=20
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUserList(@DefaultValue("0")@QueryParam("page") Integer page, @DefaultValue("20")@QueryParam("size") Integer size) {
        returnValue.clear();
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> pager =userService.FindUserList(pageable);
        returnValue.put("code", 200);
        returnValue.put("message",pager);
        return returnValue;
    }
 
    @GET
    @Path("/page/{pagesize}/{currentpage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUserPage(@DefaultValue("20") @PathParam("pagesize") Integer pagesize, @DefaultValue("1") @PathParam("currentpage") Integer currentpage) {
        returnValue.clear();
        System.out.println("pagesize:"+pagesize);
        System.out.println("currentpage:"+currentpage);
        List<User> users = new ArrayList<User>();
        returnValue.put("users",users);
        return returnValue;
    }
    
}

