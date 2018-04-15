
package com.alex.mavenweb1.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author Alex
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{
    public MyHttpSessionAttributeListener(){
        System.out.println(">>>> HttpSessionAttributeListener - NEW !!!!!");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(">>>> HttpSessionAttribute - Added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(">>>> HttpSessionAttribute - removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(">>>> HttpSessionAttribute - replaced");
    }
    
}
