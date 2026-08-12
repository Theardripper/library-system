package com.library.api.security;

import com.library.api.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder( 10 );
    }

    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "error").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/login?logout" )
                )
                .build();
                @Bean public DaoAuthenticationProvider authenticationProvider (             UserDetailsService userDetailsService, PasswordEncoder             passwordEncoder) { DaoAuthenticationProvider provider = new DaoAuthenticationProvider ();         provider.setUserDetailsService(userDetailsService);         provider.setPasswordEncoder(passwordEncoder); return provider;     }



    }
}
