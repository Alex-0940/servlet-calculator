package com.alex.mavenweb1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Alex
 */
public class ProcessingTimeFilter implements Filter{
    
    public ProcessingTimeFilter() {
        System.out.println(">>>> ProcessingTimeFilter - NEW !!!!!");
    }
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>>> ProcessingTimeFilter - init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long inTime = System.nanoTime();
        chain.doFilter(request, response);
        long outTime = System.nanoTime();
        System.out.println(">>>> ProcessingTimeFilter: dT = " + inTime);
        System.out.println(">>>> ProcessingTimeFilter: dT = " + outTime);
        System.err.println("");
    }

    @Override
    public void destroy() {  
        System.out.println(">> ProcessingTimeFilter: - destroy");
    }
    
}
