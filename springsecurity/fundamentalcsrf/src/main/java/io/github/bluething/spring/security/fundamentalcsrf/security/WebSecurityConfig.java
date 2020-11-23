package io.github.bluething.spring.security.fundamentalcsrf.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // GENERALLY DON'T DO THIS!
        //http.csrf().disable();

        http.csrf(c -> {
            c.ignoringAntMatchers("/csrfdiabled/**");
            c.csrfTokenRepository(new CustomCsrfTokenRepository());
        });

    }
}
