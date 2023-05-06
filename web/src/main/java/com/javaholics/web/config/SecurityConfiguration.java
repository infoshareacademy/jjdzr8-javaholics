package com.javaholics.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;


@EnableWebSecurity
@Configuration

public class SecurityConfiguration {

    @Bean
    public UserDetailsService makeUsers() {
        UserDetails user =
                 User
                        .withUsername("user")
                        .password("{noop}user1234")
                        .roles("USER")
                        .build();

        UserDetails admin =
                 User
                        .withUsername("admin")
                        .password("{noop}admin1234")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(Arrays.asList(user, admin));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                                            auth.requestMatchers("/public/**").permitAll();
                                            auth.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN");
                                            auth.requestMatchers("/user/**").hasAuthority("ROLE_USER");
//                                            auth.anyRequest().authenticated();
                                            }
                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))


                .formLogin(formLoginConfigurer ->
                                            formLoginConfigurer
                                            .loginPage("/public/login")
                                            .defaultSuccessUrl("/public", true)
                                                    .failureForwardUrl("/public/login-error.html")

                                            .permitAll())

                .logout(httpSecurityLogoutConfigurer ->
                                            httpSecurityLogoutConfigurer
                                            .logoutUrl("public/logout")
                                            .logoutSuccessUrl("/public/logoutsucess")
                                            .permitAll())

                .oauth2Login(Customizer.withDefaults());
//                .httpBasic(Customizer.withDefaults());

        return http.build();


    }



}
