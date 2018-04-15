package com.alex.mavenweb1.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
public abstract class AbstractFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // not
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response);
    }
    
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response);


    @Override
    public void destroy() {
        // not
    }
    
}
