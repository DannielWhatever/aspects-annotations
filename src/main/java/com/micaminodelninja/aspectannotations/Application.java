package com.micaminodelninja.aspectannotations;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Daniel on 06-02-2016.
 *
 * run: mvn clean install && mvn tomcat7:run
 */

public class Application implements WebApplicationInitializer {



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = getContext();

        //Add servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", dispatcherServlet);

        servlet.addMapping("/*");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);


    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.micaminodelninja.aspectannotations.AppConfig");
        return context;
    }



}
