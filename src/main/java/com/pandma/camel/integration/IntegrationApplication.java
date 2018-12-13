package com.pandma.camel.integration;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
		while (true){

		}
	}

	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost("localhost");
		cf.setPort(5672);
		cf.setUsername("user");
		cf.setPassword("bitnami");
		cf.setVirtualHost("/");
		return cf;
	}
}
