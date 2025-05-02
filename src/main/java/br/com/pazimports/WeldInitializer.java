package br.com.pazimports;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.jboss.weld.environment.servlet.Listener;

public class WeldInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new Listener().contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        new Listener().contextDestroyed(sce);
    }
}

