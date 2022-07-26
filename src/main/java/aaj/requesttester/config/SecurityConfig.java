package aaj.requesttester.config;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*Config para APIs. Así no hace redirect al login de keycloak y retorne código 401 unauthorized*/
    // TODO: AAJ - Meter los role mappings y los endpoints acá
    super.configure(http);
    http
        .authorizeRequests()
        .antMatchers("**").hasAnyRole("user")
        .antMatchers("**/docs**").permitAll()
        .and()
        .csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
    grantedAuthorityMapper.setPrefix("ROLE_");
    KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
    keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
    auth.authenticationProvider(keycloakAuthenticationProvider);
  }

  @Bean
  @Override
  @ConditionalOnMissingBean(HttpSessionManager.class)
  protected HttpSessionManager httpSessionManager() {
    return new HttpSessionManager();
  }

  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }
}