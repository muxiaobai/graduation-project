/**
 * Project Name:spring-boot
 * File Name:CORSFilter.java
 * Package Name:web
 * Date:2017年3月1日上午10:22:05
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:CORSFilter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年3月1日 上午10:22:05 <br/>
 * @author   Lenovo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class CORSFilter  implements Filter {  
        @Override  
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)  
                throws IOException, ServletException {  
            HttpServletResponse response = (HttpServletResponse) res;  
            response.setHeader("Access-Control-Allow-Origin", "*");  
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");  
            response.setHeader("Access-Control-Max-Age", "3600");  
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");  
            chain.doFilter(req, res);  
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            
            // TODO Auto-generated method stub
            
        }

        @Override
        public void destroy() {
            
            // TODO Auto-generated method stub
            
        } 
}

