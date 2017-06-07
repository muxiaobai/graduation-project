/**
 * Project Name:spring-boot
 * File Name:UserRest.java
 * Package Name:rest
 * Date:2017年2月28日上午10:13:51
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package rest;

import java.util.HashMap;
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

import domain.Demand;
import service.DemandService;
/**
 * 
 * rest DemandRest.java
 * @author 张鹏飞
 * @time 2017年5月8日 上午9:23:37
 *
 */

@Path("/demand")  
@Component 
public class DemandRest {

    @Autowired  
    private DemandService DemandService;  
    private Map<String, Object> returnValue= new HashMap<String, Object>();
    @POST
    @Path("add")
//    @Consumes("application/x-www-form-urlencoded")
    @Consumes("application/json;charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> post( @RequestBody Demand Demand){
        returnValue.clear();
        DemandService.save(Demand);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "add ");
        returnValue.put("data", Demand);
        return returnValue;
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> delete(@PathParam("id") Long id) {
        returnValue.clear();
        DemandService.delete(id);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", "delete ");
        return  returnValue;
    }
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> put(@PathParam("id")Long id, @RequestBody Demand Demand) {
        returnValue.clear();
        Demand.setId(id);
        DemandService.update(Demand);
        System.out.println("============"+Demand);
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
       returnValue.put("data", DemandService.getById(id));
        return returnValue;
    }
    //http://127.0.0.1:8080/rest/users/list?page=0&size=20
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getList(@DefaultValue("0")@QueryParam("page") Integer page, @DefaultValue("20")@QueryParam("size") Integer size) {
        returnValue.clear();
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        returnValue.put("code", 200);
        returnValue.put("msg", "success");
        returnValue.put("action", " get page list");
        returnValue.put("data",DemandService.FindList(pageable));
        return returnValue;
    }
}

