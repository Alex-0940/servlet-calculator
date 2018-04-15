
package com.alex.mavenweb1.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 *
 * @author Alex
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener{
    public MyServletContextAttributeListener(){
        System.out.println(">>>> ServletContextAttributeListener - NEW !!!!!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println(">>>> MyServletContextAttribute - Added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println(">>>> MyServletContextAttribute - removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        System.out.println(">>>> MyServletContextAttribute - replaced");
    }
    
}
