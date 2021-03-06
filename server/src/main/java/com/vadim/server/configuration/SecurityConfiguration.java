package com.vadim.server.configuration;

import com.vadim.server.security.TokenAuthenticationProvider;
import com.vadim.server.security.TokenFilter;
import com.vadim.server.security.TokenValidator;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static com.vadim.controllers.api.AuthApi.basePath;
import static com.vadim.controllers.api.AuthApi.loginPath;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TokenAuthenticationProvider tokenAuthenticationProvider;
    private final TokenValidator tokenValidator;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                .disable();

        httpSecurity
                .cors()
                .and();

        httpSecurity
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity
                .addFilterBefore(new TokenFilter(tokenValidator), BasicAuthenticationFilter.class);

        httpSecurity
                .authenticationProvider(tokenAuthenticationProvider);

        httpSecurity.authorizeRequests()
                .antMatchers(POST, loginPath).permitAll()
                .antMatchers(basePath + "/**").authenticated();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(tokenAuthenticationProvider);
    }
}
