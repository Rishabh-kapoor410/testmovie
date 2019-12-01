package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * Sample application for demonstrating security with JWT Tokens
 * 
 * @author rishabh.kapoor
 *
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {
		SpringbootSecurityJwtApplication.class,
        Jsr310JpaConverters.class
})
@ComponentScan("com.movie")
public class SpringbootSecurityJwtApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJwtApplication.class, args);
	}
}
