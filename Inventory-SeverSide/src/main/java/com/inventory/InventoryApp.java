package com.inventory;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InventoryApp {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApp.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/items/**"))
				.apis(RequestHandlerSelectors.basePackage("com.inventory"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
			"InventoryApp",
			"Items API",
			"1.0",
			"Free to Use",
			new springfox.documentation.service.Contact("Amir Friedman", "https://github.com/amirf2/" ,"amirf2@gmail.com"),
			"API License",
			"www.google.com",
			Collections.emptyList());
	}
}
