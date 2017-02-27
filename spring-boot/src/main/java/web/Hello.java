/**
 * Project Name:gradle
 * File Name:Hello.java
 * Package Name:web
 * Date:2017年2月27日上午11:38:20
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package web;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
/**
 * ClassName:Hello <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@RestController
public class Hello {
        
    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }
}

