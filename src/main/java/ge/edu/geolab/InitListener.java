package ge.edu.geolab;

import ge.edu.geolab.dao.PersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class InitListener implements ServletContextListener {

    Logger log = LoggerFactory.getLogger(InitListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("initializing context***************************");
        PersistenceManager.getInstance().openEntityManagerFactory();
        log.info("context initialized***************************");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("destroying context***************************");
        PersistenceManager.getInstance().closeEntityManagerFactory();
        log.info("context destroyed***************************");
    }
}
