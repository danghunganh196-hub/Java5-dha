package vn.fpoly.java5.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.fpoly.java5.utility.CookieService;

@Configuration
public class BeanConfig {
    @Bean
    public CookieService getCookieService() {
        return new CookieService();
    }
}
