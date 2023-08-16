package com.hernandezalejandro.taskmanagercrud;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerCrudApplication.class, args);
	}
	
	// Genera la documentación OpenAPI para Swagger.
	// Endpoint para visualizar la documentacion: /swagger-ui/index.html
	@Bean
	public OpenAPI customOpenAPI(@Value("V1.01.01") String appVersion) {
		return new OpenAPI().info(new Info().title("TaskRepository CRUD")
			.version(appVersion)
			.description("Basic API RESTful for Task CRUD")
			.termsOfService("https://www.linkedin.com/in/alejandro-martin-hernandez/")
			.license(new License().name("HernandezAlejandro 1.0").url("https://www.linkedin.com/in/alejandro-martin-hernandez/")));
	}
}
