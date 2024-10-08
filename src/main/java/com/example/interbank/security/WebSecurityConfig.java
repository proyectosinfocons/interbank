package com.example.interbank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
		return http
				.exceptionHandling()
				.authenticationEntryPoint((swe, e) -> {					
					return Mono.fromRunnable(() -> {
						swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);						
					});
				}).accessDeniedHandler((swe, e) -> {					
					return Mono.fromRunnable(() -> {						
						swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
					});
				})
				.and()
				.csrf().disable()				
				.formLogin().disable()
				.httpBasic().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
				.pathMatchers(HttpMethod.OPTIONS).permitAll()				
				//SWAGGER PARA SPRING SECURITY				
				.pathMatchers("/swagger-resources/**").permitAll()
				.pathMatchers("/swagger-ui.html").permitAll()
				.pathMatchers("/webjars/**").permitAll()
				.pathMatchers("/v2/api**").permitAll()
				//SWAGGER PARA SPRING SECURITY
				.pathMatchers("/saveAccount").permitAll()
				.pathMatchers("/login").permitAll()
				.pathMatchers("/v2/login").permitAll()
				.pathMatchers("/v2/**").authenticated()
				//.pathMatchers("/v2/**").hasAnyAuthority("ADMIN")
				/*.pathMatchers("/v2/**")
					.access((mono, context) -> mono
	                        .map(auth -> auth.getAuthorities()
	                        		.stream()
	                                .filter(e -> e.getAuthority().equals("ADMIN"))
	                                .count() > 0)
	                        .map(AuthorizationDecision::new)
	                )*/
				.pathMatchers("/platos/**").authenticated()
				.pathMatchers("/clientes/**").authenticated()
				.pathMatchers("/facturas/**").authenticated()
				.pathMatchers("/backpressure/**").permitAll()
				.pathMatchers("/usuarios/**").permitAll()
				.pathMatchers("/menus/**").authenticated()
				.anyExchange().authenticated()
				.and().build();
	}
}
