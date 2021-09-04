package com.stackroute.moviejpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class IbmSwagger {
	
	
	@Bean
	public Docket getdocketData()
	{
		
		return new Docket(DocumentationType.SWAGGER_2)
					     .select()
					     .apis(RequestHandlerSelectors.basePackage("com.stackroute.moviejpa"))
					     .build();
	}
	
	

}
