package com.autorapp.autorApp.websecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/newuser").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST,"/autori/dodaj").permitAll()
                .antMatchers(HttpMethod.GET,"/autori/sviautori").permitAll()
                .antMatchers(HttpMethod.GET,"/autori//pronadi/{idBroj}").permitAll()
                .antMatchers(HttpMethod.PUT,"/autori/promjeni").permitAll()
                .antMatchers(HttpMethod.DELETE,"/autori/izbrisi/{idBroj}").permitAll()
                .anyRequest().authenticated();
    }
}