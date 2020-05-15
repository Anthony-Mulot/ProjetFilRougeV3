package com.projetjava.appli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class ConfigSecu extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password , 1 " +
                        "from utilisateur " +
                        "where email = ?")
                .authoritiesByUsernameQuery("select u.email, r.name " +
                        "from role r " +
                        "join utilisateur u on u.role_id = r.id " +
                        "where u.email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/inscription").permitAll()
                .antMatchers("/inscription-reussi").permitAll()
                .antMatchers("/inscription-echec").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/edit/**").hasAnyRole("EDITEUR","ADMIN","MANAGER")
                .antMatchers("/comme/**").hasAnyRole("EDITEUR","COMMERCIAL","ADMIN","CLIENT")
                .antMatchers("/manag/**").hasAnyRole("EDITEUR","ADMIN")
                .antMatchers("/**").hasAnyRole("CLIENT","EDITEUR","COMMERCIAL","MANAGER","ADMIN")
                .and().formLogin()
                .defaultSuccessUrl("/", true);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

