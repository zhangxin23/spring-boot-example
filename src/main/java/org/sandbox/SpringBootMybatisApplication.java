package org.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
//extends SpringBootServletInitializer
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        //需要放到一个能起作用的上下文中。
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("user", "123456", AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_USER")));

        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        // Customize the application or call application.sources(...) to add sources
//
//        application.sources(SpringBootMybatisApplication.class);
//        return application;
//    }
}
