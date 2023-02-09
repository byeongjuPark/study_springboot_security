package com.bottlepark.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    // @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        //권한에 대한 부분 url & roles : user url & roles
        httpSecurity.authorizeRequests()
            // .antMatchers("/").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
            .antMatchers("/").authenticated()
            .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
            .anyRequest().permitAll();

        // 로그인에 대한 부분
        httpSecurity.formLogin().loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/");

        return httpSecurity.build(); 
    }
}
