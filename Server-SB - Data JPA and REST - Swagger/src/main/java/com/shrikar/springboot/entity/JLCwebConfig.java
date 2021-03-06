package com.shrikar.springboot.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.google.common.base.Predicates;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.shrikar.springboot")
public class JLCwebConfig implements WebMvcConfigurer {
	private ApiInfo apiDetails() {
		
		
		return new ApiInfo("CourseCube API", "Course API - part of CourseCube Application", "1.1",
				"Free API to use any time", new springfox.documentation.service.Contact("Srinivas Dande",
						"https://www.coursecube.com", "training@coursecube.com"),
				"API Under Free Licence", "https://www.coursecube.com");
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build()
				.apiInfo(apiDetails());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//enabling swagger-ui part for visual documentation
		registry.addResourceHandler("swaggerui.html").addResourceLocations("classpath:/METAINF/resources/");
				registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/METAINF/resources/webjars/");
	}
}

