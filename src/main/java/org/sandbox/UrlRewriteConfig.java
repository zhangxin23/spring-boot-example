package org.sandbox;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

/**
 * Author: zhangxin
 * Date:   15-8-29
 */
@Configuration
public class UrlRewriteConfig {

    @Bean
    public UrlRewriteFilter urlRewriteFilter() {
        UrlRewriteFilter urlRewriteFilter = new SelfUrlRewriteFilter();
        return urlRewriteFilter;
    }

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
