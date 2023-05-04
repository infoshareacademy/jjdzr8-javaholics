package com.javaholics.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;


@EnableWebSecurity
@Configuration

public class SecurityConfiguration {
//
//
//    public PasswordEncoder getBcryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public InMemoryUserDetailsManager user() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("{noop}user1234")
                        .authorities("read")
                        .build()
        );
    }

//
//    @Bean
//    public InMemoryUserDetailsManager get() {
//        UserDetails user =
//                 User.withUsername("user")
//                .password("{noop}user1234")
//                .roles("ROLE_USER")
//                .build();
//
//        UserDetails admin =
//                 User.withUsername("admin")
//                .password("{noop}admin1234")
//                .roles("ROLE_ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
//    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                                            auth.requestMatchers("/public/**").permitAll();
                                            auth.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN");
                                            auth.requestMatchers("/user/**").hasAuthority("ROLE_USER");
                                            auth.anyRequest().authenticated();
                                            }
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))


                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
//                .loginPage("/login.html").permitAll()
//                .defaultSuccessUrl("/user/api", true)
//                .failureUrl("/login.html?error=true")
//
//                .and()
//                .logout()
//                .logoutUrl("public/logout")
//                .logoutSuccessUrl("/public/logoutsucess").permitAll()


                .httpBasic(Customizer.withDefaults());

        return http.build();


    }



}
