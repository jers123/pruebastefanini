package org.teststefanini.studenttest.config;

import static org.teststefanini.studenttest.utils.SystemConstants.LOCAL_ORIGIN_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.PUBLIC_ORIGIN_PATH;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StudenttestConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(LOCAL_ORIGIN_PATH
					,PUBLIC_ORIGIN_PATH
					//,"*"
				)
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("*")
				.allowCredentials(false)
				.maxAge(3600)
		;
	}
}