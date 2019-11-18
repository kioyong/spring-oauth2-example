package com.example.authorization;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * For configuring the end users recognized by this Authorization Server
 */
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                .username("enduser")
                .password("password")
                .roles("USER")
                .build(),
            User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build()
        );
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
