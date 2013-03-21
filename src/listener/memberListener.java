package listener; /**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/21/13
 * Time: 9:24 AM
 * To change this template use File | Settings | File Templates.
 */

import model.Customer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class memberListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private timerManager tm = null;
    // Public constructor is required by servlet spec
    public memberListener() {



    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        tm.destoryTimer();
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
        System.out.println("running listener");
        Customer customer =(Customer) se.getSession().getAttribute("curcus");
        if(customer!=null)
        tm = new timerManager(3000,customer);//
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
        tm.destoryTimer();
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
