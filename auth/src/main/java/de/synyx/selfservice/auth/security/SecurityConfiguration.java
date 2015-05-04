package de.synyx.selfservice.auth.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by klem on 13.04.15.
 */
@Configuration
@Order(-10)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value(value = "${ldap.hostUrl}")
    private String ldapHostUrl;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //NOSONAR
        //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.ldapAuthentication().contextSource().url(ldapHostUrl).and().
                userDnPatterns("uid={0},ou=people").groupSearchBase("ou=group").
                groupSearchFilter("memberUid={1}").userSearchBase("ou=people");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception { //NOSONAR
        http
                .formLogin().permitAll()
                .and()
                .requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}