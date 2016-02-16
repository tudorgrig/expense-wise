package com.myMoneyTracker.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myMoneyTracker.app.filter.StatelessAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        http.authorizeRequests().antMatchers("/*").permitAll().anyRequest().permitAll();
        http.csrf().disable();
        http.requiresChannel().anyRequest().requiresSecure();
        http.addFilterBefore(new StatelessAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}