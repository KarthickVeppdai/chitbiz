package com.villagebiz.chit.config;

import com.villagebiz.chit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http            .authorizeHttpRequests(requet -> requet.requestMatchers("/home/chithome","/home/logout").permitAll()
                        .requestMatchers("/images/**", "/js/**", "/css/**","/plugins/**","/self/**").permitAll()
                        .anyRequest()
                        .authenticated());
        http.formLogin(form-> form.loginPage("/home/chithome").
                loginProcessingUrl("/login").defaultSuccessUrl("/home/homepage",true)
                .failureUrl("/home/login")
        );
        http.logout(logout->logout.logoutUrl("/home/logout")
                .logoutSuccessUrl("/home/chithome")
                .invalidateHttpSession(true)
                .clearAuthentication(true));
        http.csrf(csrf -> csrf
                .disable());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserService userService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
