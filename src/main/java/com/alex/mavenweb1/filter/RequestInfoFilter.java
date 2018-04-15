
package com.alex.mavenweb1.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public class RequestInfoFilter extends AbstractFilter{
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response){
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        System.out.println(">> RequestInfoFilter: method = " + method);
        System.err.println();
                
    }
    
}
