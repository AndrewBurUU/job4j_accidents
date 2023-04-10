package ru.job4j.accidents.filter;

import org.springframework.context.annotation.*;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import ru.job4j.accidents.config.*;

import javax.servlet.*;

public class SecurityInit extends AbstractSecurityWebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(SecurityConfig.class);
        ac.refresh();
    }
}
