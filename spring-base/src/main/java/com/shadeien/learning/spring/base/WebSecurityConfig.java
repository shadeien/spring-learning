package com.shadeien.learning.spring.base;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
        return manager;
    }

    @Override
    public void configure(HttpSecurity web) throws Exception {
        web.authorizeRequests()
                // inde.html对应的url允许所任人访问
                .antMatchers("/").permitAll()
                // user.html对应的url，则需要用户有USER的角色才可以访问
                .antMatchers("/user").hasRole("USER")
                .and()
                .formLogin();
    }
}
