import javax.servlet.ServletContext; 
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author ISHAN
 */
public class SessionCounter1 implements HttpSessionListener {
    
    ServletContext ctx=null;  
    static int total=0,current=0; 
    
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        total++;  
        current++;  
      
        ctx=e.getSession().getServletContext();  
        ctx.setAttribute("totalusers", total);  
        ctx.setAttribute("currentusers", current);  
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        current--;  
        ctx.setAttribute("currentusers",current); 
    }
}
