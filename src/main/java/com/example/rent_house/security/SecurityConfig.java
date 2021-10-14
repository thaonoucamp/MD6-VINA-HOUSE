package com.example.rent_house.security;

import com.example.rent_house.model.RoleName;
import com.example.rent_house.model.Roles;
import com.example.rent_house.model.Users;
import com.example.rent_house.service.roles.IRolesService;
import com.example.rent_house.service.users.IUsersService;
import com.example.rent_house.service.users.UsersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUsersService usersService;

    @Autowired
    private IRolesService rolesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    //1. mã hoá password
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/", "/login", "/apartment/**", "/signup", "/users/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }

//    @PostConstruct
//    public void init() {
//        List<Users> users = (List<Users>) usersService.getAll();
//        List<Roles> roleList = (List<Roles>) rolesService.getAll();
//        if (roleList.isEmpty()) {
//            Roles roleAdmin = new Roles();
//            roleAdmin.setId(1L);
//            roleAdmin.setName(RoleName.ROLE_ADMIN.toString());
//            rolesService.save(roleAdmin);
//            Roles roleCoach = new Roles();
//            roleCoach.setId(2L);
//            roleCoach.setName(RoleName.ROLE_USER.toString());
//            rolesService.save(roleCoach);
//            if (users.isEmpty()) {
//                Users admin = new Users();
//                Set<Roles> roles = new HashSet<>();
//                roles.add(new Roles(1L, RoleName.ROLE_ADMIN.toString()));
//                admin.setEmail("admin");
//                admin.setUsername("admin");
//                admin.setFullName("admin");
//                admin.setRoles(roles);
//                admin.setPassword(passwordEncoder.encode("123456"));
//                usersService.save(admin);
//            }
//        }
//    }
}