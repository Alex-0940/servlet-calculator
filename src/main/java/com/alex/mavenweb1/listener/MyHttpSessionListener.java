package com.alex.mavenweb1.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Alex
 */
public class MyHttpSessionListener implements HttpSessionListener{
    public MyHttpSessionListener(){
        System.out.println(">>>> HttpSessionListener - NEW !!!!!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(">>>> HttpSession - created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(">>>> HttpSession - destroyed");
    }
    
}
