package com.ax.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Sebarswee
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder().encode("secret"))
                .scopes("read", "write")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .and()
                .withClient("client2")
                .secret(passwordEncoder().encode("secret2"))
                .scopes("read", "write")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .and()
                .withClient("app")
                .secret(passwordEncoder().encode("appsecret"))
                .scopes("app")
                .authorizedGrantTypes("client_credentials");
    }
}
