 package com.security.securityConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaltSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((requests) -> {
			requests.requestMatchers("security/demo", "security/tournament").authenticated()
					.requestMatchers("security/teams", "security/players","/register").permitAll();
		}).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();

	}

	/* configuration to deny all the request */

//    	http.authorizeHttpRequests((requests)->{
//    		requests.anyRequest().denyAll();
//    	})
//    	.formLogin(Customizer.withDefaults())
//    	.httpBasic(Customizer.withDefaults());
//        return http.build();
//    	

	/* Configuration to permit all the request */

//    	http.authorizeHttpRequests((requests)->{
//    		requests.anyRequest().permitAll();
//    	})
//    	.formLogin(Customizer.withDefaults())
//    	.httpBasic(Customizer.withDefaults());
//        return http.build();

	///////////////////////////////////////////////////////////////////////////

//        InMemoryUserDetailsManager

//        	Approach 1 where we use withDefaultPasswordEncoder() method
//    		while creating the user details
//        @Bean
//        public InMemoryUserDetailsManager userDetailsService() {
//            UserDetails admin = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("12345")
//            .authorities("admin")
//            .build();
//    UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("12345")
//            .authorities("read")
//            .build();
//    	return new InMemoryUserDetailsManager(admin, user);
//    		
//        }

//        Approach 2 where we use NoOpPasswordEncoder Bean
//  		while creating the user details
//        @Bean
//        public InMemoryUserDetailsManager userDetailsServiceWithPasswordEncrption() {
//        
//                UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("678910")
//                .authorities("admin")

//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("678910")
//                .authorities("read")
//                .build();
//        	return new InMemoryUserDetailsManager(admin, user);
//        		
//            }
//        
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	// jdbcUserdetailsManager
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}

}
