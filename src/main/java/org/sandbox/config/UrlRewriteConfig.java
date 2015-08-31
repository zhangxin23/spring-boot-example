package org.sandbox.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;

/**
 * Author: zhangxin
 * Date:   15-8-29
 */
@Configuration
public class UrlRewriteConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CustomUrlRewriteFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);

        return registrationBean;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");

//        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

        registration.setName("spring-boot-mybatis");

        return registration;
    }


    //    @Bean
//    public UrlRewriteFilter urlRewriteFilter() {
//        UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
//        return urlRewriteFilter;
//    }


//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.addUrlMappings("/app/*");
//        return registration;
//    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean()
//    {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//
//        registrationBean.setFilter(new UrlRewriteFilter());
//        registrationBean.addUrlPatterns("*");
//        registrationBean.addInitParameter("confReloadCheckInterval", "5");
//        registrationBean.addInitParameter("logLevel", "DEBUG");
//
//        return registrationBean;
//    }

//    @Bean
//    public UrlRewriteFilter urlRewriteFilter() {
//        UrlRewriteFilter urlRewriteFilter = new EnhancedUrlRewriteFilter();
//        return urlRewriteFilter;
//    }
}
