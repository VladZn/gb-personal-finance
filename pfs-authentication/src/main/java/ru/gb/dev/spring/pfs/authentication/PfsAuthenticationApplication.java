package ru.gb.dev.spring.pfs.authentication;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableAuthorizationServer
public class PfsAuthenticationApplication {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mainDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> user(OAuth2Authentication user) {

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication()
                                .getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication()
                                .getAuthorities()));
        return userInfo;

    }

    public static void main(String[] args) {
        SpringApplication.run(PfsAuthenticationApplication.class, args);
    }
}
