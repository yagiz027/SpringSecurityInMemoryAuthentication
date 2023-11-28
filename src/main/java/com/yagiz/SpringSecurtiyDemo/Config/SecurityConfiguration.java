package com.yagiz.SpringSecurtiyDemo.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic(); //Eğer pop-up login form ile giriş sağlamak istiyorsak sadece bu komutu yazmamız yeterli 
        http.formLogin(); // Spring Security'nin sağlamış olduğu form login ekranını kullanarak login sağlamak istiyorsak bu komutu eklememiz gerekmektedir.

        http.authorizeHttpRequests()
            .antMatchers("/dashboard").hasAnyRole("admin","user")  // dashboard sayfasına yalnızca yetkili kişilerin erişebildiğini authenticated bir sayfa olduğunu belirten kod satırı.
            .antMatchers("/admin").hasRole("admin")
        .and()
            .authorizeHttpRequests()
            .antMatchers("/index")
            .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}1234").roles("admin")
            .and()
            .withUser("ali").password("{noop}1234").roles("user");
    }
}
