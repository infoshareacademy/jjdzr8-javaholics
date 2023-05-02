package com.javaholics.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    public InMemoryUserDetailsManager get() {
//        UserDetails user = User.withUsername("user")
//                .password(getBcryptPasswordEncoder().encode("user1234"))
//                .roles("ROLE_USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(getBcryptPasswordEncoder().encode("admin1234"))
//                .roles("ROLE_ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth->
                        auth
                                .antMatchers("/public/").permitAll()
                                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                .antMatchers("/user/**").hasAuthority("ROLE_USER")
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login.html").permitAll()
                                .defaultSuccessUrl("/user/api", true)
                                .failureUrl("/login.html?error=true")
                )
                .logout(logout ->
                        logout
                                .logoutUrl("user/logout")
                                .logoutSuccessUrl("/public/logoutsucess").permitAll()
                );

        return http.build();


    }



}
