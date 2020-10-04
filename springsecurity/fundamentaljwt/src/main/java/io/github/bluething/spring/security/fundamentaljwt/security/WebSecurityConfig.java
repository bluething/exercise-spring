package io.github.bluething.spring.security.fundamentaljwt.security;

import io.github.bluething.spring.security.fundamentaljwt.jwt.JwtSecret;
import io.github.bluething.spring.security.fundamentaljwt.jwt.JwtToken;
import io.github.bluething.spring.security.fundamentaljwt.jwt.JwtTokenAuthFilter;
import io.github.bluething.spring.security.fundamentaljwt.jwt.Token;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new JpaUserDetailService();
    }

    @Bean
    public JwtSecret jwtSecret() {
        return new JwtSecret();
    }

    @Bean
    public Token token(JwtSecret jwtSecret) {
        return new JwtToken(jwtSecret);
    }

    @Bean
    public JwtTokenAuthFilter jwtTokenAuthFilter(Token token) {
        return new JwtTokenAuthFilter(token);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/auth/sigin").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenAuthFilter(token(jwtSecret())), UsernamePasswordAuthenticationFilter.class);
    }

}
