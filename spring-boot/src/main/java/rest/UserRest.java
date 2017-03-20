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
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.springframework.beans.factory.annotation.Autowired;
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
   
    @POST
    @Path("")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public String postUser(@BeanParam User user){
        returnValue.clear();
        System.out.println(user);
        return " post success";
    }
 
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") Integer id) {
        returnValue.clear();
        return  "delete success";
    }
 
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String putUser(@PathParam("id")  Integer id, @BeanParam User user) {
        returnValue.clear();
        return "put update";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUser(@PathParam("id") Integer id) {
        returnValue.clear();
        System.out.println("get:"+id);
       User user= userService.getUserById(id);
       returnValue.put("code", 200);
       returnValue.put("user", user);
        return returnValue;
    }
 
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getUserList() {
        returnValue.clear();
        List<User> users = new ArrayList<User>();
        users.add(new User("1","1"));
        users.add(new User("2","1"));
        users.add(new User("3","1"));
        returnValue.put("code", 200);
        returnValue.put("users", users);
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

