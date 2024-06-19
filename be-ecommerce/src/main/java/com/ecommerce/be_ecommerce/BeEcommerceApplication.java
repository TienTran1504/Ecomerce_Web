package com.ecommerce.be_ecommerce;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Ecommerce REST API",
				version = "v1.0",
				description = "Spring Boot Ecommerce REST APIs Documentation",
				contact = @Contact(
						name = "Tien Tran",
						url = "https://www.github.com/TienTran1504"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Ecommerce  GitHub Link",
				url = "https://github.com/TienTran1504/Ecomerce_Web"
		)
)
public class BeEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeEcommerceApplication.class, args);
	}

}
