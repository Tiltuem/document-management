package com.java.ponomarenko.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails dirSamara = User.withUsername("dirSamara")
                .password(passwordEncoder.encode("dirSamara"))
                .roles("DIR")
                .build();

        UserDetails dirMoscow = User.withUsername("dirMoscow")
                .password(passwordEncoder.encode("dirMoscow"))
                .roles("DIR")
                .build();

        UserDetails dirUfa = User.withUsername("dirUfa")
                .password(passwordEncoder.encode("dirUfa"))
                .roles("DIR")
                .build();

        UserDetails dirOren = User.withUsername("dirOren")
                .password(passwordEncoder.encode("dirOren"))
                .roles("DIR")
                .build();

        UserDetails dirPerm = User.withUsername("dirPerm")
                .password(passwordEncoder.encode("dirPerm"))
                .roles("DIR")
                .build();

        UserDetails dirChel = User.withUsername("dirChel")
                .password(passwordEncoder.encode("dirChel"))
                .roles("DIR")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(dirSamara, dirMoscow, dirUfa, dirOren, dirPerm, dirChel, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/", "/user/**", "/css/**", "/webjars/**", "/user/add")
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/admin/documents/0", true)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }


}
