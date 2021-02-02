package com.codegym.demo.config;

import com.codegym.demo.model.MyUserDetail;
import com.codegym.demo.model.User;
import com.codegym.demo.service.impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .defaultSuccessUrl("/customer/home")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("static/*").permitAll()
                .antMatchers("/customer/create", "/customer/edit/*", "/customer/delete/*").hasRole("USER")
                .antMatchers("/employee/create", "/employee/edit/*", "/employee/delete/*").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
//    }

    //
//////    @Override
//////    protected void configure(HttpSecurity http) throws Exception {
//////        http
//////                .formLogin()
//////                    .defaultSuccessUrl("/customer")
//////                    .permitAll()
//////                .and()
//////                    .authorizeRequests().antMatchers("/hello").permitAll()
//////                    .anyRequest().authenticated();
//////    }
//////
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String pass = bCryptPasswordEncoder.encode("123");
        System.out.println(pass);
}
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("user").password("12345").roles("USER")
//                .and()
//                .withUser("admin").password("12345").roles("ADMIN");
//    }

    //
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/user**").hasRole("USER")
//                .and()
//                .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }

}

