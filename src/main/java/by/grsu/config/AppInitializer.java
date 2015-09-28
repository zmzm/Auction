package by.grsu.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    public static AnnotationConfigWebApplicationContext ctx;

    public void onStartup(ServletContext servletContext) throws ServletException {
        ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(BaseConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servletRegistration.setInitParameter(DISPATCHER_SERVLET_NAME, ctx.getApplicationName());
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);
    }

}
