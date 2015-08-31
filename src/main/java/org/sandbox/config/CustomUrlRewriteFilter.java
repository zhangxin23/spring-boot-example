package org.sandbox.config;

import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;
import org.tuckey.web.filters.urlrewrite.UrlRewriter;

import javax.servlet.*;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Author: zhangxin
 * Date:   15-8-29
 */
public class CustomUrlRewriteFilter extends UrlRewriteFilter {
    private UrlRewriter urlRewriter;

    @Override
    public void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
        try {
//            FileInputStream inputStream = new FileInputStream("../resources/urlrewrite.xml");

            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("urlrewrite.xml");
            Conf conf1 = new Conf(filterConfig.getServletContext(), inputStream, "urlrewrite.xml", "");
            urlRewriter = new UrlRewriter(conf1);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public UrlRewriter getUrlRewriter(ServletRequest request, ServletResponse response, FilterChain chain) {
        return urlRewriter;
    }

    @Override
    public void destroyUrlRewriter() {
        if(urlRewriter != null)
            urlRewriter.destroy();
    }
}
