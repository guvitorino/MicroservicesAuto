package com.vitorino.msgateway.config;

import javax.servlet.http.HttpServletResponse;

import com.vitorino.msgateway.filter.JwtTokenAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationConfig config;

    @Bean
    public JwtAuthenticationConfig jwtConfig() {
        return new JwtAuthenticationConfig();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                    .logout().disable()
                    .formLogin().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .anonymous()
                    .and()
                        .exceptionHandling().authenticationEntryPoint(
                            (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                    .and()
                        .addFilterAfter(new JwtTokenAuthenticationFilter(config),
                            UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                        .antMatchers(config.getUrl()).permitAll()
                        .antMatchers("/boleto/**").hasRole("ADMIN")
                        .antMatchers("/boleto/**").hasRole("USER")
                        .antMatchers("/automoveis/**").hasRole("ADMIN")
                        .antMatchers("/automoveis/**").hasRole("USER")
                        .antMatchers("/cadastroAutomoveis/**").hasRole("ADMIN")
                        .antMatchers("/cadastroAutomoveis/**").hasRole("USER")
                        .anyRequest().authenticated();
    }
}
