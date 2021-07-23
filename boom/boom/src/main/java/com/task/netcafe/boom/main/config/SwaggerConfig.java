package com.task.netcafe.boom.main.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(metadata())//
	          .useDefaultResponseMessages(false)
	          .tags(new Tag("getallitem", "list all service/product item"))
	          .tags(new Tag("addbucket", "get choosen service/product to the bucket"))
	          .tags(new Tag("showtotalpay", "get all tootal service/product cost"))
	          .genericModelSubstitutes(Optional.class);
	    }
	 
	 private ApiInfo metadata() {
		    return new ApiInfoBuilder()//
		        .title("NetCaffe")//
		        .description("Spring project")
		        .version("1.0.0")//
		        .license("Wiraisy License").licenseUrl("http://opensource.org/licenses/Wiraisy")//
		        .contact(new Contact("Akbar Wiraisy", null, "wiraisy@gmail.com"))//
		        .build();
		  }
}
