
package com.alex.mavenweb1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Alex
 */
public class MyServletContextListener implements ServletContextListener{
    public MyServletContextListener(){
        System.out.println(">>>> ServletContextListener - NEW !!!!!");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) { 
        System.out.println(">>>> ServletContext - init !!!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext - desrtoyed !!!!!");
    }
    
}
