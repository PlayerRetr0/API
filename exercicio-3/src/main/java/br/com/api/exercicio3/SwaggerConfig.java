package br.com.api.exercicio3;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
	
	@Value("${tohstore.swagger.dev-url}")
	private String devUrl;
	
	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("server Url - Ambiente de desilvolvimento");
		
		Contact contact = new Contact();
		contact.setEmail("kaiquedmazzoco11@gmail.com");
		contact.setName("kaique");
		contact.setUrl("https://www.tohstore.com");
		
		License license = new License()
				.name("Apache license version 2.0")
				.url("https://www.apache.org/license/LICENSE-2.0");
		
		Info info = new Info()
				.title("Documentação API - tohstore")
				.version("1.0.0")
				.contact(contact)
				.termsOfService("https://www.tohstore.com/terms")
				.license(license);
		
		return new OpenAPI().info(info).servers(List.of(devServer));
	}
}
