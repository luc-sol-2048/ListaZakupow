package pl.lukasz.shopping.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    public final DataSource dataSource;

    @Autowired
    public WebSecurity(@Qualifier("dataSource") DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").authenticated()
                .and()
                .formLogin().loginPage("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .successForwardUrl("/home")
                .permitAll()
                .and().logout().permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user0_.email , user0_.password, TRUE from user user0_ where user0_.email=?")
                .authoritiesByUsernameQuery("select u.user_email, r.role_name from user u inner JOIN role r ON u.id_role = r.id_role WHERE u.user_email=?")
                .passwordEncoder(passwordEncoder());

    }

    private PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }



}
