package com.bottlepark.study_springboot_security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    //None using csrf protection


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        // None using csrf protection
        httpSecurity.csrf().disable();
        // 권한에 대한 부분 : url & roles : user url & roles
        // url, roles from Dao
        httpSecurity.authorizeRequests()
            // .antMatchers("/").authenticated()   // 로그인 여부만 판단.
            // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')") // 로그인 & 권한
            .antMatchers("/admin").authenticated()
            .antMatchers("/manager/*").access("hasRole('ROLE_ADMIN' or hasRole('ROLE_MANAGER'))")
            .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")

            .anyRequest().permitAll();      // 설정한 URL 이외는 접근 가능(로그인 & 로그아웃).
        
        // 로그인에 대한 부분
        httpSecurity.formLogin().loginPage("/loginForm")
            .failureUrl("/loginForm?fail=true") // 로그인 실패시
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/");
        


        return httpSecurity.build(); 
    }
    @Bean
    public BCryptPasswordEncoder encoderPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
