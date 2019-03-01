package ru.gb.dev.spring.pfs.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import ru.gb.dev.spring.pfs.authentication.config.ServiceConfig;

import javax.sql.DataSource;

/**
 * @author V. Zinchenko
 */

@Configuration
public class JwtTokenStoreConfig {

    @Autowired
    private ServiceConfig serviceConfig;

//    @Autowired
//    @Qualifier("oauthDataSource")
//    private DataSource dataSource;

//    @Autowired
//    public JwtTokenStoreConfig(ServiceConfig serviceConfig, DataSource dataSource) {
//        this.serviceConfig = serviceConfig;
//        this.dataSource = dataSource;
//    }


//    /**
//     * Used to read data to and from a token presented to the service
//     * @return
//     */
//    @Bean
//    @Primary
//    public DefaultTokenServices defaultTokenServices() {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore());
//        defaultTokenServices.setSupportRefreshToken(true);
//        return defaultTokenServices;
//    }

    /**
     * Acts as the translator between JWT and OAuth2 server
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(serviceConfig.getJwtSigningKey());
        return converter;
    }

    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }
}
